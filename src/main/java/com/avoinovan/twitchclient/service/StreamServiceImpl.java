package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.api.TwitchApiClient;
import com.avoinovan.twitchclient.api.model.RestStream;
import com.avoinovan.twitchclient.domain.entity.Channel;
import com.avoinovan.twitchclient.domain.entity.Game;
import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.repository.ChannelRepository;
import com.avoinovan.twitchclient.domain.repository.StreamRepository;
import com.avoinovan.twitchclient.queue.ircbot.BotCommandQueue;
import com.avoinovan.twitchclient.queue.ircbot.CreateStreamIrcBotMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by avoinovan on 3/29/16.
 */
@Service
public class StreamServiceImpl implements StreamService {

    @Value("${stream.viewers.threshold}")
    private Integer minUsersThreshold;


    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StreamRepository streamRepository;

    @Autowired
    private TwitchApiClient twitchApiClient;

    @Autowired
    private BotCommandQueue botCommandQueue;

    @Override
    public List<Stream> createOrGetGameStreams(Game game) {
        List<Stream> results = new LinkedList<>();
        int currentPage = 1;
        List<RestStream> restStreams;

        List<Channel> dbStoredChannels = channelRepository.findByGameId(game.getId());

        Map<String, Channel> dbChannelMap =  new HashMap<>();



        for (Channel eachdbChannel : dbStoredChannels) {
            dbChannelMap.put(eachdbChannel.getName(), eachdbChannel);
        }


        do {

            restStreams = twitchApiClient.getChannelsWithViewersGt(minUsersThreshold, game.getName(), currentPage++ );

            for (RestStream eachRestStream : restStreams) {
                if (!dbChannelMap.containsKey(eachRestStream.getChannel().getName())) {
                    Channel channel = new Channel();
                    channel.setName(eachRestStream.getChannel().getName());
                    channel.setGameId(game.getId());
                    channelRepository.save(channel);
                    dbChannelMap.put(channel.getName(), channel);
                }

                Stream stream  = streamRepository.findById(eachRestStream.getId() + "");

                if (stream != null && stream.getBotAssigned() != null && stream.getBotAssigned()) {
                    //if stream already exists and bot is assigned - skip it
                    continue;
                }

                //Stream stream = streamRepository.

                if (stream == null) {
                    stream = new Stream();
                    stream.setId(eachRestStream.getId() + "");
                    stream.setChannel(eachRestStream.getChannel().getName());
                    stream.setGameId(game.getId());
                    stream.setStartedOn(eachRestStream.getCreatedAt());
                    streamRepository.save(stream);
                }

                botCommandQueue.offer(new CreateStreamIrcBotMessage(stream));

                results.add(stream);
            }

        } while(restStreams != null && restStreams.size() > 0);


        return results;
    }
}
