package com.avoinovan.twitchclient.queue.ircbot;

import com.avoinovan.twitchclient.domain.entity.Stream;

/**
 * Created by avoinovan on 5/6/16.
 */
public class CreateStreamIrcBotMessage extends BotMessage<Stream> {

    public CreateStreamIrcBotMessage(Stream body) {
        super(body);
    }

}
