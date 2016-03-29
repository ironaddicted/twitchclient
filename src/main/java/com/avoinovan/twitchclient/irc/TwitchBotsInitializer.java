package com.avoinovan.twitchclient.irc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Alex on 3/3/16.
 */
@Component
public class TwitchBotsInitializer {

    @Autowired
    private ApplicationContext applicationContext;

    public TwitchBotsInitializer() {
        TwitchIrcBot bot = applicationContext.getBean(TwitchIrcBot.class);
        bot.setChannel("amazhs");
        bot.connect();
    }
}
