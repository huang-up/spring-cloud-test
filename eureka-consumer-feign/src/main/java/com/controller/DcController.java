package com.controller;

import com.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
}
