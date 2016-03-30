package com.avoinovan.twitchclient.domain.entity;

import java.util.Date;

/**
 * Created by Alex on 3/1/16.
 */
public class Stream extends AbstractEntity {

    private String channel;

    private Date startedOn;

    private Date endedOn;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Date startedOn) {
        this.startedOn = startedOn;
    }

    public Date getEndedOn() {
        return endedOn;
    }

    public void setEndedOn(Date endedOn) {
        this.endedOn = endedOn;
    }
}
