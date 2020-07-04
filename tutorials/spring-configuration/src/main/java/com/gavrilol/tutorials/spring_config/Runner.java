package com.gavrilol.tutorials.spring_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    @Qualifier(value = "someString")
    String someString;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Thread.sleep(5000);
            System.out.println("Hello spring " + someString);
        }

    }
}
