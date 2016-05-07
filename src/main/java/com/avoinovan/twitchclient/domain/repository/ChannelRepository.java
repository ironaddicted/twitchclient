package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.Channel;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 3/1/16.
 */
@Repository
public class ChannelRepository extends BaseRepository<Channel> {

    public List<Channel> findByGameId(String gameId) {
        return getMongoTemplate().find(Query.query(Criteria.where("gameId").is(gameId)), getEntityClass());
    }


    @Override
    public Class<Channel> getEntityClass() {
        return Channel.class;
    }
}
