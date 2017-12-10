package com.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/10/12.
 */
@RestController
public class DcController {
    private final static Logger LOGGER = Logger.getLogger(DcController.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String index() {
        return "hello index";
    }

    @GetMapping("/dc")
    public String dc(HttpServletRequest request) {
        LOGGER.info(String.format("===<call eureka-client, TraceId = %s, SpanId = %s>===", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId")));
        String services = "Services: " + discoveryClient.getServices();
        return services;
    }

    @GetMapping("/foo")
    public String foo() {
        return "eureka-client foo";
    }

    @GetMapping("/bar")
    public String bar() {
        return "eureka-client bar";
    }
}
