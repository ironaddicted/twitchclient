package com.avoinovan.twitchclient.api.model.response;

import java.util.List;

/**
 * Created by avoinovan on 5/6/16.
 */
public abstract class SingleEntitySearchResult<T> extends  SearchResult<T> {
    public abstract T getResult();
}
