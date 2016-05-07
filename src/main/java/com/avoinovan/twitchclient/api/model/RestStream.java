package com.avoinovan.twitchclient.api.model;

/**
 * Created by avoinovan on 4/29/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestStream {

    @JsonProperty("_id")
    private long id;
    private String game;
    private int viewers;
    private Date createdAt;
    private int videoHeight;
    private double averageFps;
    private StreamPreview preview;
    private RestChannel channel;

    /**
     * Check if a stream is online.
     * If this is an empty stream object, then the stream is offline.
     *
     * @return <code>true</code> if the stream is online, <code>false</code> otherwise
     */
    public boolean isOnline() {
        return id != 0;
    }

    @Override
    public String toString() {
        return "RestStream{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", viewers=" + viewers +
                ", createdAt=" + createdAt +
                ", videoHeight=" + videoHeight +
                ", averageFps=" + averageFps +
                ", preview=" + preview +
                ", channel=" + channel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestStream restStream = (RestStream) o;

        return id == restStream.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public StreamPreview getPreview() {
        return preview;
    }

    public void setPreview(StreamPreview preview) {
        this.preview = preview;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(int videoHeight) {
        this.videoHeight = videoHeight;
    }

    public double getAverageFps() {
        return averageFps;
    }

    public void setAverageFps(double averageFps) {
        this.averageFps = averageFps;
    }

    public RestChannel getChannel() {
        return channel;
    }

    public void setChannel(RestChannel channel) {
        this.channel = channel;
    }
}