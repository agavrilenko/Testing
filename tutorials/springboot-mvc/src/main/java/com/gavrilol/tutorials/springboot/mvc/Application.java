package com.gavrilol.tutorials.springboot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//set  MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"
//-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=y
//java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n -jar  target/springboot-mvc-1.0-SNAPSHOT.war

}
