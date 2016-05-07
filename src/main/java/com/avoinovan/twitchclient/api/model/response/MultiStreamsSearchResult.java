package com.avoinovan.twitchclient.api.model.response;

import com.avoinovan.twitchclient.api.model.RestStream;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by avoinovan on 4/29/16.
 */
public class MultiStreamsSearchResult extends MultiEntitySearchResult<RestStream> {

    @JsonProperty("streams")
    private List<RestStream> restStreams;


    @Override
    public List<RestStream> getResults() {
        return restStreams;
    }
}
