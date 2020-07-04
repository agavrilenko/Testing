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
    private HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    @PostConstruct
    private void quoteInit() {
        quotes = hazelcastInstance.getMap("quotes");
    }

    @Bean
    public ConcurrentMap<String, FixModel> getQuotes() {
//        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
//        ConcurrentMap<String, FixModel> quotes = hazelcastInstance.getMap("quotes");
        return quotes;
    }
}
