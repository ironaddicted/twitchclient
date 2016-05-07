package com.avoinovan.twitchclient.configuration;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
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
class DataModelConfig  extends AbstractMongoConfiguration {

    @Value("${mongo.db.name}")
    private String databaseName;

    @Value("${mongo.db.host}")
    private String mongoHost;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }
}
