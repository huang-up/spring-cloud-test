package com.controller;

import com.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/10/13.
 */
@RestController
public class DcController {
    @Autowired
    @Qualifier(value = "dcClient")
    private DcClient dcClient;
    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @GetMapping("/consumerDc")
    public String consumerDc() {
        return dcClient.consumerDc();
    }
}
