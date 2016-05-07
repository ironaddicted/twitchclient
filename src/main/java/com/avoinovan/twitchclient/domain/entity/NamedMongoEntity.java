package com.avoinovan.twitchclient.domain.entity;

/**
 * Created by Alex on 3/1/16.
 */
public class NamedMongoEntity extends AbstractMongoEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NamedMongoEntity)) return false;

        NamedMongoEntity that = (NamedMongoEntity) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
