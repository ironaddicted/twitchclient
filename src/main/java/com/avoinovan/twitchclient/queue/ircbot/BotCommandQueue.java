package com.avoinovan.twitchclient.queue.ircbot;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by avoinovan on 5/6/16.
 */
@Component
public class BotCommandQueue extends ConcurrentLinkedQueue<BotMessage> {
}
