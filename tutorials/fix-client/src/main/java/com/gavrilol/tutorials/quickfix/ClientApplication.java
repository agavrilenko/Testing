package com.gavrilol.tutorials.quickfix;

import com.gavrilol.tutorials.quickfix.beans.FixClientConfiguration;
import com.gavrilol.tutorials.quickfix.beans.KafkaProducerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import({FixClientConfiguration.class, KafkaProducerConfiguration.class})
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down client")));
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);
        while (context.isActive()) {
            Thread.sleep(5000);
        }
    }
}
