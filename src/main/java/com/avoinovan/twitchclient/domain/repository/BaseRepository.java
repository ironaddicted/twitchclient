package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.AbstractMongoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by avoinovan on 5/5/16.
 */
public abstract class BaseRepository<T extends AbstractMongoEntity> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public abstract Class<T> getEntityClass();

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public List<T> findAll() {
        return mongoTemplate.find(Query.query(Criteria.where("active").is(Boolean.TRUE)), getEntityClass());
    }

    public T findById(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), getEntityClass());
    }

    public void save(T entityToSave) {
        mongoTemplate.save(entityToSave);
    }

}
