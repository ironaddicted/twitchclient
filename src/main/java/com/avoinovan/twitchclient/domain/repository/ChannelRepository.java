package com.avoinovan.twitchclient.domain.repository;

import com.avoinovan.twitchclient.domain.entity.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 3/1/16.
 */
@Repository
public interface ChannelRepository extends MongoRepository<Channel, String> {
}
