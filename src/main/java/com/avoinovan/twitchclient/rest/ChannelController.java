package com.avoinovan.twitchclient.rest;

import com.avoinovan.twitchclient.domain.entity.Channel;
import com.avoinovan.twitchclient.domain.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alex on 3/1/16.
 */
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveChannel(Channel channel) {
        channelRepository.save(channel);
        return ResponseEntity.accepted().build();
    }
}
