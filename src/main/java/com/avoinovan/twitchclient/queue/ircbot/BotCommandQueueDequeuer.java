package com.avoinovan.twitchclient.queue.ircbot;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.service.IrcBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by avoinovan on 5/6/16.
 */
@Component
public class BotCommandQueueDequeuer {

    @Autowired
    private BotCommandQueue botMessages;

    @Autowired
    private IrcBotService ircBotService;

    @Scheduled(fixedDelay = 1000)
    public void dequeue() {
        if (!botMessages.isEmpty()) {

            while (!botMessages.isEmpty()) {
                BotMessage message = botMessages.poll();

                if (message instanceof CreateStreamIrcBotMessage) {
                    ircBotService.startStreamBot((Stream) message.getBody());
                }
            }
        }
    }
}
