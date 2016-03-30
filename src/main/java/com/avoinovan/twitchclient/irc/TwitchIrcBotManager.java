package com.avoinovan.twitchclient.irc;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.queue.StreamPeriod;
import com.avoinovan.twitchclient.queue.StreamUpdateQueue;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by avoinovan on 3/29/16.
 */
public class TwitchIrcBotManager extends TimerTask {

    private static final Logger logger = LogManager.getLogger(TwitchIrcBotManager.class);

    private Long periodMillis = 60 * 1000L;

    private Stream stream;

    private TwitchIrcBot bot;

    private Timer timer;

    private StreamUpdateQueue streamUpdateQueue;

    public TwitchIrcBotManager(TwitchIrcBot twitchIrcBot, Stream stream, Long periodMillis, StreamUpdateQueue streamUpdateQueue) {
        this(twitchIrcBot, stream, streamUpdateQueue);
        this.periodMillis = periodMillis;
    }

    public TwitchIrcBotManager(TwitchIrcBot twitchIrcBot, Stream stream, StreamUpdateQueue streamUpdateQueue) {
        this.stream = stream;
        this.streamUpdateQueue = streamUpdateQueue;
        bot = twitchIrcBot;
        bot.connect();

        timer = new Timer(true);
        timer.scheduleAtFixedRate(this, 0, periodMillis);
    }

    @Override
    public void run()  {
        int messageCount = bot.resetCounter();

        if (messageCount > 0) {
            streamUpdateQueue.offer(new StreamPeriod(messageCount, stream.getId()));
        }

        if (!bot.isConnected()) {
            logger.info(String.format("Shutting down %s stream is dead...", stream.getChannel()));
            timer.cancel();
            this.cancel();
        }
    }
}
