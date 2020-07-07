package com.gavrilol.tutorials.store;

import com.gavrilol.tutorials.store.configuration.HazelcastConfiguration;
import com.gavrilol.tutorials.store.configuration.KafkaClientConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import({HazelcastConfiguration.class, KafkaClientConfiguration.class})
@SpringBootApplication(exclude = {HazelcastAutoConfiguration.class})
public class StoreApplication {
    private static final Logger logger = LoggerFactory.getLogger(StoreApplication.class);

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.info("Shutting down store")));
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        while (context.isActive()) {
            Thread.sleep(5000);
        }

    }

}
