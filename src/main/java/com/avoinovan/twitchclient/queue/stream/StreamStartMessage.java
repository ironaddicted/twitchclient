package com.avoinovan.twitchclient.queue.stream;

import com.avoinovan.twitchclient.api.model.RestStream;
import com.avoinovan.twitchclient.domain.entity.Stream;

/**
 * Created by avoinovan on 5/6/16.
 */
public class StreamStartMessage extends StreamMessage<RestStream> {

    public StreamStartMessage(RestStream body, Stream stream) {
        super(body, stream);
    }

}
