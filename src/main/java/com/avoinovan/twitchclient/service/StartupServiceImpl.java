package com.avoinovan.twitchclient.service;

import com.avoinovan.twitchclient.domain.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by avoinovan on 5/5/16.
 */

@Service
public class StartupServiceImpl implements StartupService {

    @Autowired
    private GameService gameService;

    @Autowired
    private StreamService streamService;



    @Override
    @PostConstruct
    @Scheduled(fixedDelay = 10 * 1000, initialDelay = 60 * 1000)
    public void init() {

        List<Game> games = gameService.getAllGames();

        for (Game eachGame : games) {
            streamService.createOrGetGameStreams(eachGame);
        }


    }
}
