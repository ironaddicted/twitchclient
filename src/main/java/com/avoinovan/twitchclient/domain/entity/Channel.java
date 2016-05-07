package com.avoinovan.twitchclient.domain.entity;

/**
 * Created by Alex on 3/1/16.
 */

public class Channel extends NamedMongoEntity {

    private String streamer;

    private String gameId;

    public String getStreamer() {
        return streamer;
    }

    public void setStreamer(String streamer) {
        this.streamer = streamer;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Channel channel = (Channel) o;

        if (streamer != null ? !streamer.equals(channel.streamer) : channel.streamer != null) return false;
        return gameId != null ? gameId.equals(channel.gameId) : channel.gameId == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (streamer != null ? streamer.hashCode() : 0);
        result = 31 * result + (gameId != null ? gameId.hashCode() : 0);
        return result;
    }
}
