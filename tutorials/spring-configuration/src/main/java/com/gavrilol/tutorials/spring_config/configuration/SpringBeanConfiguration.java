package com.gavrilol.tutorials.spring_config.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfiguration {
    @Bean(name = "someString")
    public String getSomething() {
        return "Huy";
    }
}
