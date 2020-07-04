package com.gavrilol.tutorials.quickfix.server;

import com.gavrilol.tutorials.quickfix.server.beans.FixServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import(FixServerConfiguration.class)
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down server")));
        ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        while (context.isActive()) {
            Thread.sleep(5000);
        }

    }
}
