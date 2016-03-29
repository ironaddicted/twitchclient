package com.avoinovan.twitchclient;

import com.avoinovan.twitchclient.domain.entity.Channel;
import com.avoinovan.twitchclient.domain.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitchClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitchClientApplication.class, args);
	}
}
