package com.avoinovan.twitchclient.queue.stream;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.entity.StreamSplit;

/**
 * Created by avoinovan on 5/6/16.
 */
public class StreamSplitMessage extends StreamMessage<StreamSplit> {

    public StreamSplitMessage(StreamSplit body, Stream stream) {
        super(body, stream);
    }

}
