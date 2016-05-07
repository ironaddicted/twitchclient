package com.avoinovan.twitchclient.irc;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.entity.StreamSplit;
import com.avoinovan.twitchclient.queue.stream.StreamEndMessage;
import com.avoinovan.twitchclient.queue.stream.StreamSplitMessage;
import com.avoinovan.twitchclient.queue.stream.StreamUpdateQueue;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by avoinovan on 3/29/16.
 */
public class TwitchIrcBotTimerTask extends TimerTask {

    private static final Logger logger = LogManager.getLogger(TwitchIrcBotTimerTask.class);

    private Long periodMillis = 15 * 1000L;

    private Stream stream;

    private TwitchIrcBot bot;

    private Timer timer;

    private StreamUpdateQueue streamUpdateQueue;

    public TwitchIrcBotTimerTask(TwitchIrcBot twitchIrcBot, Stream stream, Long periodMillis, StreamUpdateQueue streamUpdateQueue) {
        this(twitchIrcBot, stream, streamUpdateQueue);
        this.periodMillis = periodMillis;
    }

    public TwitchIrcBotTimerTask(TwitchIrcBot twitchIrcBot, Stream stream, StreamUpdateQueue streamUpdateQueue) {
        this.stream = stream;
        this.streamUpdateQueue = streamUpdateQueue;
        bot = twitchIrcBot;
        bot.connect();

        timer = new Timer(true);
        timer.scheduleAtFixedRate(this, 0, periodMillis);
    }

    public Long getPeriodMillis() {
        return periodMillis;
    }

    public void setPeriodMillis(Long periodMillis) {
        this.periodMillis = periodMillis;
    }

    @Override
    public void run()  {
        StreamSplit split = bot.resetCounter();
        split.setStreamId(stream.getId());

        if (split.getComments() > 0) {
            streamUpdateQueue.offer(new StreamSplitMessage(split, stream));
        }

        if (!bot.isConnected()) {
            logger.info(String.format("Shutting down %s stream is dead...", stream.getChannel()));
            timer.cancel();
            this.cancel();
            streamUpdateQueue.offer(new StreamEndMessage(stream));
        }
    }
}
