package com.avoinovan.twitchclient.queue.stream;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.queue.Message;

/**
 * Created by avoinovan on 5/6/16.
 */
public abstract class StreamMessage<T> extends Message<T> {

    private Stream stream;

    public StreamMessage(T body, Stream stream) {
        super(body);
        this.stream = stream;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }
}
