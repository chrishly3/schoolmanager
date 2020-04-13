package com.schoolmanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class AppController {

    @RequestMapping(value = "/caseTest",method = RequestMethod.GET)
    public String caseTest(){
        return  "111";
    }
}
