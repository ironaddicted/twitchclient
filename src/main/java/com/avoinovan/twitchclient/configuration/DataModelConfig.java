package com.avoinovan.twitchclient.configuration;

import com.mongodb.Mongo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by Alex on 3/1/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.avoinovan.twitchclient.domain")
class DataModelConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "twitchclient";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.avoinovan.twitchclient.domain";
    }
}
