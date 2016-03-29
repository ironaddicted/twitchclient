package com.avoinovan;

import com.avoinovan.twitchclient.TwitchClientApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TwitchClientApplication.class)
@WebAppConfiguration
public class TwitchClientApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}

}
