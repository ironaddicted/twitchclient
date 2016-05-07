package com.avoinovan.twitchclient.queue.stream;

import com.avoinovan.twitchclient.domain.entity.StreamSplit;
import com.avoinovan.twitchclient.domain.repository.StreamRepository;
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

    @Autowired
    private StreamRepository streamRepository;

    @Scheduled(fixedDelay = 10000)
    public void dequeue() {
        if (!streamUpdateQueue.isEmpty()) {

            while (!streamUpdateQueue.isEmpty()) {

                StreamMessage streamMessage = streamUpdateQueue.poll();

                if (streamMessage instanceof StreamEndMessage) {

                    streamRepository.finishStream(streamMessage.getStream().getId());

                } else if (streamMessage instanceof StreamSplitMessage) {

                    streamRepository.upsertSplit((StreamSplit) streamMessage.getBody(), streamMessage.getStream().getId());

                }

            }
        }
    }
}
