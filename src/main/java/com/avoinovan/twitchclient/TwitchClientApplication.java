package com.avoinovan.twitchclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TwitchClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitchClientApplication.class, args);
	}
}
