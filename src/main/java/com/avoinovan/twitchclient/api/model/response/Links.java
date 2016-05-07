package com.avoinovan.twitchclient.api.model.response;

import java.net.URI;

/**
 * Created by avoinovan on 4/29/16.
 */
public class Links {

    private URI self;

    private URI next;

    public URI getSelf() {
        return self;
    }

    public void setSelf(URI self) {
        this.self = self;
    }

    public URI getNext() {
        return next;
    }

    public void setNext(URI next) {
        this.next = next;
    }
}
