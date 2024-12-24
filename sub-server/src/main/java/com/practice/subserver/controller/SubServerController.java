package com.practice.subserver.controller;

import com.practice.dto.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubServerController {
    @GetMapping("/sub")
    public CustomResponse subEndpoint() {
        return new CustomResponse("Message from SubServer");
    }
}
