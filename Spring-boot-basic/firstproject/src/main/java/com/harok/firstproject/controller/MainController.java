package com.harok.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.harok.firstproject.service.MainService;

@RestController
public class MainController {
    
    private final MainService mainService;

    @Autowired // <- 붙여야지 아래 사용가능
    public MainController(MainService mainService) {
        this.mainService=mainService;
    }

    @GetMapping("/hello") // 리소스의 경로가 /hello임
    public String hello() {
        return mainService.hello();
    }
}
