package com.aop.zht.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestAopController {

    @PostMapping("/a")
    public String test(@RequestParam String username) throws InterruptedException {
        log.info("------------------test 方法执行时-------------------");
        log.info("this is a controller");
//        Thread.sleep(300L);
        return "hello " + username + " this is a controller";
    }

}
