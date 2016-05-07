package com.avoinovan.twitchclient.api.model.response;

import com.avoinovan.twitchclient.api.model.response.Links;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by avoinovan on 4/29/16.
 */
public abstract class SearchResult<T> {

    @JsonProperty("_total")
    private int total;

    @JsonProperty("_links")
    private Links links;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
