package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Stream;

/**
 * Created by avoinovan on 5/6/16.
 */
public interface IrcBotService {

    void startStreamBot(Stream stream);
    void stopStreamBot(Stream stream);
}
