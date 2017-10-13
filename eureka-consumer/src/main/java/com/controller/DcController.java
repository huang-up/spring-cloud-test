package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 但是这样的做法需要我们手工的去编写服务选取、链接拼接等繁琐的工作，对于开发人员来说非常的不友好。
 * 所以，下来我们看看Spring Cloud中针对客户端负载均衡的工具包：Spring Cloud Ribbon。
 * Created by admin on 2017/10/13.
 */
@RestController
public class DcController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/consumer")
    public String dc() {
        // 先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，
        // 这个服务实例的基本信息存储在ServiceInstance中
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        // 然后通过这些对象中的信息拼接出访问/dc接口的详细地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        // 最后再利用RestTemplate对象实现对服务提供者接口的调用
        return restTemplate.getForObject(url, String.class);
    }
}
