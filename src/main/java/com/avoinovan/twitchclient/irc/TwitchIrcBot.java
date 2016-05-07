package com.avoinovan.twitchclient.irc;

import com.avoinovan.twitchclient.api.TwitchApiClient;
import com.avoinovan.twitchclient.api.model.RestStream;
import com.avoinovan.twitchclient.api.model.response.SingleStreamSearchResult;
import com.avoinovan.twitchclient.domain.entity.StreamSplit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Alex on 3/1/16.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TwitchIrcBot extends PircBot {

    public static final Logger logger = LogManager.getLogger(TwitchIrcBot.class);

    @Value("${twitch.irc.host}")
    private String ircHost;

    @Value("${twitch.irc.port}")
    private int ircPort;

    @Value("${twitch.irc.password}")
    private String password;

    @Value("${twitch.bot.name}")
    private String botName;

    @Value("${twitch.bot.max.idle.periods}")
    private Integer maxIdlePeriods;

    private String channel;

    private Integer messageCounter = 0;

    private Integer idleCounter = 0;

    private Date splitStart = new Date();

    @Autowired
    private TwitchApiClient twitchApiClient;

    @PostConstruct
    public void init() {
        setVerbose(false);
        setName(botName);
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        /*super.onMessage(channel, sender, login, hostname, message);*/
        messageCounter++;
        if ("ping".equalsIgnoreCase(message)) {
            sendMessage(channel, "PONG");
        }
    }


    public void connect() {
        if (channel == null) {
            logger.error("RestChannel is not set");
        }
        try {
            this.connect(ircHost, ircPort, password);
            this.joinChannel("#" + channel);
        } catch (IOException | IrcException e) {
            logger.error("Unable to connect to Twitch IRC", e);
        }
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    private void setMessageCounter(Integer messageCounter) {
        this.messageCounter = messageCounter;
    }

    public void setSplitStart(Date splitStart) {
        this.splitStart = splitStart;
    }

    public StreamSplit resetCounter() {

        RestStream stream = twitchApiClient.getStreamByChannel(channel);

/*        if (messageCounter == 0) {
            idleCounter++;
        }

        if (idleCounter >= maxIdlePeriods) {
            this.disconnect();
        }*/

        StreamSplit result =  new StreamSplit(messageCounter, null, splitStart);

        if (stream != null) {
            result.setViewers(stream.getViewers());
        } else {
            logger.info(String.format("%s channel is dead", channel));
            this.disconnect();
            return result;
        }

        setMessageCounter(0);
        setSplitStart(new Date());
        return result;
    }
}
