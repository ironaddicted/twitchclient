package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.Stream;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Alex on 3/1/16.
 */
public interface StreamRepository extends MongoRepository<Stream, String> {
}
