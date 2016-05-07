package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.Game;
import org.springframework.stereotype.Repository;

/**
 * Created by avoinovan on 5/5/16.
 */
@Repository
public class GameRepository extends BaseRepository<Game> {
    @Override
    public Class<Game> getEntityClass() {
        return Game.class;
    }
}
