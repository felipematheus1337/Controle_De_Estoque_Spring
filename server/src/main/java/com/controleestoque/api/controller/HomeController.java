package com.controleestoque.api.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class HomeController {

    @GetMapping(path = "/ping")
    public String ping(HttpServletRequest request) {
        return ZonedDateTime.now().toString();
    }
}
