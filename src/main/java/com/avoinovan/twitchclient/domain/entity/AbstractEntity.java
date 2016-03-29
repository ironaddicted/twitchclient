package com.avoinovan.twitchclient.domain.entity;


import com.google.gson.Gson;
import org.springframework.data.annotation.Id;

/**
 * Created by Alex on 3/1/16.
 */

public class AbstractEntity {

    private static final Gson GSON = new Gson();

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
