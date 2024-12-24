package com.practice.mainserver.controller;

import com.practice.dto.CustomResponse;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainServerController {
    private RestTemplate restTemplate = new RestTemplate();
    private String subServerUrl = "http://sub-service:9090/sub";
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/main")
    public CustomResponse mainEndpoint() {
        String singleResult = entityManager.createQuery("select 'Message from PostgreSQL'", String.class)
                .getSingleResult();
        String response = restTemplate.getForObject(subServerUrl, String.class);
        return new CustomResponse("Message from MainServer {%s} {%s}".formatted(response, singleResult));
    }
}
