package com.avoinovan.twitchclient.queue.stream;

import com.avoinovan.twitchclient.domain.entity.Stream;

/**
 * Created by avoinovan on 5/6/16.
 */
public class StreamEndMessage  extends StreamMessage<Void> {

    public StreamEndMessage(Stream stream) {
        super(null, stream);
    }
}
