package com.avoinovan.twitchclient.queue;

/**
 * Created by avoinovan on 5/6/16.
 */
public abstract class Message<T> {

    private T body;

    public Message(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
