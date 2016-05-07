package com.avoinovan.twitchclient.queue.stream;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by avoinovan on 3/29/16.
 */
@Component
public class StreamUpdateQueue extends ConcurrentLinkedQueue<StreamMessage> {
}
