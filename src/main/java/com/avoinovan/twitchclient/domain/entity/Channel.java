package com.avoinovan.twitchclient.domain.entity;

/**
 * Created by Alex on 3/1/16.
 */

public class Channel extends NamedEntity {

    private String streamer;

    public String getStreamer() {
        return streamer;
    }

    public void setStreamer(String streamer) {
        this.streamer = streamer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;

        Channel channel = (Channel) o;

        return streamer != null ? streamer.equals(channel.streamer) : channel.streamer == null;

    }

    @Override
    public int hashCode() {
        return streamer != null ? streamer.hashCode() : 0;
    }
}
