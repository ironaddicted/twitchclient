package com.avoinovan.twitchclient.domain.entity;


import com.google.gson.Gson;

/**
 * Created by Alex on 3/1/16.
 */

public class AbstractMongoEntity {

    private static final Gson GSON = new Gson();

    private String _id;

    private Boolean active = Boolean.TRUE;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMongoEntity)) return false;

        AbstractMongoEntity that = (AbstractMongoEntity) o;

        return _id != null ? _id.equals(that._id) : that._id == null;

    }

    @Override
    public int hashCode() {
        return _id != null ? _id.hashCode() : 0;
    }
}
