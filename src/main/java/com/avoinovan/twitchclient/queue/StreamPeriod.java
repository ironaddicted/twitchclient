package com.avoinovan.twitchclient.queue;

import java.util.Date;

/**
 * Created by avoinovan on 3/29/16.
 */
public class StreamPeriod {

    private Date date = new Date();
    private Integer comments = 0;
    private String streamId;

    public StreamPeriod(Integer comments, String streamId) {
        this.comments = comments;
        this.streamId = streamId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
