package com.avoinovan.twitchclient.configuration;

import com.avoinovan.twitchclient.domain.entity.StreamSplit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by avoinovan on 3/29/16.
 */
@Configuration
public class ServiceConfig {

    @Bean
    public Queue<StreamSplit> streamPeriodsQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
