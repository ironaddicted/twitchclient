package com.avoinovan.twitchclient.domain.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 3/1/16.
 */
public class Stream extends AbstractMongoEntity {

    private String channel;

    private Date startedOn;

    private Date endedOn;

    private String gameId;

    private Boolean botAssigned = Boolean.FALSE;

    private boolean finished;

    private List<StreamSplit> periods;

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

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Boolean getBotAssigned() {
        return botAssigned;
    }

    public void setBotAssigned(Boolean botAssigned) {
        this.botAssigned = botAssigned;
    }

    public List<StreamSplit> getPeriods() {
        return periods;
    }

    public void setPeriods(List<StreamSplit> periods) {
        this.periods = periods;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
