package com.avoinovan.twitchclient.queue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by avoinovan on 3/29/16.
 */
@Component
public class StreamUpdateDequeuer {

    private static final Logger logger = LogManager.getLogger(StreamUpdateDequeuer.class);

    @Autowired
    private StreamUpdateQueue streamUpdateQueue;

    @Scheduled(fixedDelay = 10000)
    public void dequeue() {
        if (!streamUpdateQueue.isEmpty()) {

        }
    }

}
