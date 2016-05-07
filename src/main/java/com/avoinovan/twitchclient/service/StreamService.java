package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Game;
import com.avoinovan.twitchclient.domain.entity.Stream;

import java.util.List;

/**
 * Created by avoinovan on 3/29/16.
 */
public interface StreamService {

    List<Stream> createOrGetGameStreams(Game game);
}
