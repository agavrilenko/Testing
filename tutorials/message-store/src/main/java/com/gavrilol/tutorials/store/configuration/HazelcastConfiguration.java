package com.gavrilol.tutorials.store.configuration;

import com.gavrilol.tutorials.store.beans.FixModel;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentMap;

@Configuration
public class HazelcastConfiguration {

    private ConcurrentMap<String, FixModel> quotes;
    private HazelcastInstance hazelcastInstance;

    @PostConstruct
    private void quoteInit() {
        if (hazelcastInstance == null) {
            hazelcastInstance = Hazelcast.newHazelcastInstance();
        }
        quotes = hazelcastInstance.getMap("quotes");
    }

    @Bean
    public ConcurrentMap<String, FixModel> getQuotes() {
//        ConcurrentMap<String, FixModel> quotes = hazelcastInstance.getMap("quotes");
        return quotes;
    }
}
