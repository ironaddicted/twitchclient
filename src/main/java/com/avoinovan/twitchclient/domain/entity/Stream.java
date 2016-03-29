package com.avoinovan.twitchclient.domain.entity;

import java.util.Date;

/**
 * Created by Alex on 3/1/16.
 */
public class Stream extends AbstractEntity {

    private String channelId;

    private Date startedOn;

    private Date endedOn;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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
