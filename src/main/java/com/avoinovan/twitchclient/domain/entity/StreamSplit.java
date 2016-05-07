package com.avoinovan.twitchclient.domain.entity;

import java.util.Date;

/**
 * Created by avoinovan on 3/29/16.
 */
public class StreamSplit {

    private Date startDate = new Date();
    private Integer comments = 0;
    private String streamId;
    private Integer viewers;

    public StreamSplit(Integer comments, String streamId, Date startDate) {
        this.comments = comments;
        this.streamId = streamId;
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }
}
