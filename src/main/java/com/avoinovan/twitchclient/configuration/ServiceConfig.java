package com.avoinovan.twitchclient.configuration;

import com.avoinovan.twitchclient.queue.StreamPeriod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by avoinovan on 3/29/16.
 */
@Configuration
public class ServiceConfig {

    @Bean
    public Queue<StreamPeriod> streamPeriodsQueue() {
        return new ConcurrentLinkedQueue<>();
    }
}
