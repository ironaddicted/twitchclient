package com.avoinovan.twitchclient.irc;

import com.avoinovan.twitchclient.domain.entity.Channel;
import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.repository.ChannelRepository;
import com.avoinovan.twitchclient.domain.repository.StreamRepository;
import com.avoinovan.twitchclient.queue.StreamUpdateQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 3/3/16.
 */
@Component
public class TwitchBotsInitializer {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StreamUpdateQueue streamUpdateQueue;

    @PostConstruct
    public void init() {

        List<Channel> channels  = channelRepository.findAll();

        channels.forEach(channel -> {
            TwitchIrcBot twitchIrcBot = applicationContext.getBean(TwitchIrcBot.class);
            twitchIrcBot.setChannel(channel.getName());

            Stream stream = new Stream();
            stream.setChannel(channel.getName());
            stream.setStartedOn(new Date());
            streamRepository.insert(stream);

            new TwitchIrcBotManager(twitchIrcBot, stream, 100L, streamUpdateQueue);

        });
    }
}
