package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Game;
import com.avoinovan.twitchclient.domain.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by avoinovan on 5/5/16.
 */
@Service
public class GameServiceImpl implements  GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
