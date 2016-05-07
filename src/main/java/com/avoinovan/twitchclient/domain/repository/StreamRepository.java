package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.Stream;
import com.avoinovan.twitchclient.domain.entity.StreamSplit;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 3/1/16.
 */
@Repository
public class StreamRepository extends BaseRepository<Stream> {

    public void upsertSplit(StreamSplit split, String streamId) {
        getMongoTemplate().upsert(Query.query(Criteria.where("_id").is(streamId)), new Update().push("splits", split), getEntityClass());
    }

    public void setBotAssigned(Stream stream) {
        getMongoTemplate().updateFirst(Query.query(Criteria.where("_id").is(stream.getId())), new Update().set("botAssigned", stream.getBotAssigned()), getEntityClass());
    }

    public void finishStream(String streamId) {
        getMongoTemplate().upsert(Query.query(Criteria.where("_id").is(streamId)), new Update().set("finished", true).set("botAssigned", false), getEntityClass());
    }

    @Override
    public Class<Stream> getEntityClass() {
        return Stream.class;
    }
}
