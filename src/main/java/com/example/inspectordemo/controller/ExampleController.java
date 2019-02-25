package com.example.inspectordemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.inspectordemo.service.ExampleService;

@RestController
@RequestMapping(value = "/api/example")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @RequestMapping(value = "/func1")
    public String func1(@RequestParam("arg1") String arg1, @RequestParam("arg2") Integer arg2) {
        String ret = exampleService.piyopiyoMethod(arg1, arg2);
        return ret;
    }
}
