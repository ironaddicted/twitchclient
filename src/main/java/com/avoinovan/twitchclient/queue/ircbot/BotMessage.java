package com.avoinovan.twitchclient.queue.ircbot;

import com.avoinovan.twitchclient.queue.Message;

/**
 * Created by avoinovan on 5/6/16.
 */
public class BotMessage<T> extends Message<T> {

    public BotMessage(T body) {
        super(body);
    }

}
