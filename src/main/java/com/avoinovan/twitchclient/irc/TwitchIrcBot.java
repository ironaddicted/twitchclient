package com.avoinovan.twitchclient.irc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

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
            logger.error("Channel is not set");
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

    public Integer resetCounter() {

        int messages = messageCounter;

        if (messageCounter == 0) {
            idleCounter++;
            logger.info(String.format("%s channel is idle %d", channel, idleCounter));
        }

        if (idleCounter >= maxIdlePeriods) {
            this.disconnect();
        }

        setMessageCounter(0);
        return messages;
    }
}
