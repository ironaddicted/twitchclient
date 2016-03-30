package com.avoinovan.twitchclient.queue;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by avoinovan on 3/29/16.
 */
@Component
public class StreamUpdateQueue extends ConcurrentLinkedQueue<StreamPeriod> {
}
