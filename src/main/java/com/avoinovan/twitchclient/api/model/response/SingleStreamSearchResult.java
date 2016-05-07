package com.avoinovan.twitchclient.api.model.response;

import com.avoinovan.twitchclient.api.model.RestStream;

/**
 * Created by avoinovan on 5/6/16.
 */
public class SingleStreamSearchResult extends SingleEntitySearchResult<RestStream> {

    private RestStream stream;

    @Override
    public RestStream getResult() {
        return stream;
    }

    public void setStream(RestStream stream) {
        this.stream = stream;
    }
}
