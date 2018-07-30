package org.my.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by trash on 28-Jul-18.
 */
@SpringBootApplication
@ImportResource({"classpath:spring/root-context.xml"})
public class Application implements CommandLineRunner {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

    }

    public void run(String... strings) throws Exception {

        System.out.println("Saying hello!!");

    }
}
