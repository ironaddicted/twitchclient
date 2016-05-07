package com.avoinovan;

import com.avoinovan.twitchclient.TwitchClientApplication;
import com.avoinovan.twitchclient.api.TwitchApiClient;
import com.avoinovan.twitchclient.api.model.RestStream;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TwitchClientApplication.class)
@WebAppConfiguration
public class TwitchClientApplicationTests {

	@Autowired
	private TwitchApiClient twitchApiClient;

	@Test
	@Ignore
	public void contextLoads() {
	}

/*	@Test
	@Ignore
	public void testTwitchApiClient() {
		List<RestStream> restStreams =  twitchApiClient.getChannelsWithViewersGt(100, "Hearthstone: Heroes of Warcraft");
		Assert.assertNotNull(restStreams);
	}*/

}
