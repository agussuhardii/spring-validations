package com.agussuhardi.springvalidation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.URI;

/**
 * @author agus.suhardii@gmail.com
 * @created 14/06/23/06/2023 :20.01
 * @project spring-validation
 * <p>
 * integration test api
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //set random port start test
@Slf4j
class SampleControllerTest {

    @LocalServerPort
    protected Integer port; //get running port

    @Autowired
    protected TestRestTemplate restTemplate; // http client

    @Test
    void addUserSuccess() {

        var form = new UserVO("agus suhardi", "123456", "Sumbawa"); //prepare data request form

//        create header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

//        create request entity
        var request = new RequestEntity<>(form, headers, HttpMethod.POST, URI.create("http://localhost:" + port + "/sample"));
        var response = restTemplate.exchange(request, String.class); // send request and response string ( response can set object, map, or any)

//      you can get response body and show log
        log.info("response=>{}", response.getBody());

//        check response status
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void addUserBadRequest() {

        var form = new UserVO("agus suhardi", "333333", "Sumbawa");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var request = new RequestEntity<>(form, headers, HttpMethod.POST, URI.create("http://localhost:" + port + "/sample"));
        var response = restTemplate.exchange(request, String.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}