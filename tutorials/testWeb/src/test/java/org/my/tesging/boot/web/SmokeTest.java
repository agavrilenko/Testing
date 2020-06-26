package org.my.tesging.boot.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.my.tesging.boot.web.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {
    @Autowired
    private HomeController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contexLoads() throws Exception {
        Assert.assertNotNull(controller);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Assert.assertEquals("Hello, World", this.restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class));
    }
}
