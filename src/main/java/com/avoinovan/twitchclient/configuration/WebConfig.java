package com.avoinovan.twitchclient.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Alex on 3/1/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.avoinovan.twitchclient.rest")
public class WebConfig {
}
