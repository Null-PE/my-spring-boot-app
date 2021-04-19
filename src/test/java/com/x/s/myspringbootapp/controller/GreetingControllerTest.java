package com.x.s.myspringbootapp.controller;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GreetingControllerTest {
    private static final String HOST = "http://localhost:";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greeting_should_return_with_param() throws Exception {
        String param = "test name";
        String path = "/greeting";
        assertThat(this.restTemplate.getForObject(HOST + port + path + "?name=" + param, String.class)).contains("Hello, " + param);
    }

    @Test
    public void greeting_should_return_default() throws Exception {
        String path = "/greeting";
        assertThat(this.restTemplate.getForObject(HOST + port + path, String.class)).contains("Hello, World!");
    }

}
