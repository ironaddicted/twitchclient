package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Game;

import java.util.List;

/**
 * Created by avoinovan on 5/5/16.
 */
public interface GameService {

    List<Game> getAllGames();
}
