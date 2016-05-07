package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.repository.StreamRepository;
import com.avoinovan.twitchclient.irc.TwitchIrcBot;
import com.avoinovan.twitchclient.irc.TwitchIrcBotTimerTask;
import com.avoinovan.twitchclient.queue.ircbot.BotCommandQueueDequeuer;
import com.avoinovan.twitchclient.queue.stream.StreamUpdateQueue;
import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by avoinovan on 5/6/16.
 */
@Service
public class IrcBotServiceImpl implements IrcBotService {

    private static final Logger logger = LogManager.getLogger(BotCommandQueueDequeuer.class);

    @Value("${twitch.irc.split.duration}")
    private Long splitDuration;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StreamUpdateQueue streamUpdateQueue;


    public void startStreamBot(Stream stream) {

        logger.info(String.format("Starting IRC bot for stream %s[%s]", stream.getChannel(), stream.getId()));

        TwitchIrcBot twitchIrcBot = applicationContext.getBean(TwitchIrcBot.class);
        twitchIrcBot.setChannel(stream.getChannel());

        new TwitchIrcBotTimerTask(twitchIrcBot, stream, splitDuration * 1000, streamUpdateQueue);
        stream.setBotAssigned(true);

        streamRepository.setBotAssigned(stream);


    }

    public void stopStreamBot(Stream stream) {
        stream.setBotAssigned(false);
        streamRepository.setBotAssigned(stream);
    }
}
