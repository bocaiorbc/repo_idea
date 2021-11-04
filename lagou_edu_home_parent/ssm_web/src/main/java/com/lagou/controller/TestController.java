package com.lagou.controller;

import com.lagou.domain.Test;
import com.lagou.service.Testservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //@Controller +@ResponseBody
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Testservice testservice;

    @RequestMapping("/findAllTest")
    public List<Test> findAllTest(){
        List<Test> allTest = testservice.findAllTest();
        return allTest;
    }
}
