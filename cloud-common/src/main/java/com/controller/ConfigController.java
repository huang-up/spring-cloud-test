package com.controller;

import com.alibaba.fastjson.JSON;
import com.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by h on 2017/12/7.
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {
    @Value("${str:default str}")
    private String str;
    @Autowired
    private TestConfig testConfig;
    @GetMapping(value = "/foo")
    public String foo() {
        return JSON.toJSONString(testConfig) + ", str is " + str;
    }
}
