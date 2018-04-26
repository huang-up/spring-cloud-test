package com.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 如何去消费服务提供者的接口?
 * Created by admin on 2017/10/13.
 */
@RestController
public class DcController {
    private final static Logger LOGGER = LoggerFactory.getLogger(DcController.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(threadPoolKey = "ribbon-eureka-client#dc", groupKey = "eureka-client", commandKey = "ribbon-dc", fallbackMethod = "consumerFallback")
    @GetMapping("/consumer")
    public String dc(HttpServletRequest request) {
        // 对于RestTemplate的使用，我们的第一个url参数有一些特别。
        // 这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成。
        // 那么这样的请求为什么可以调用成功呢？
        // 因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，
        // 并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
        LOGGER.info(String.format("===<call eureka-consumer-ribbon, TraceId = %s, SpanId = %s>===", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId")));
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String consumerFallback(HttpServletRequest request) {
        return "consumer fallback";
    }

}
