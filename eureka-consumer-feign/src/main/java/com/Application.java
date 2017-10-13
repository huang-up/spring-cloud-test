package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 由于Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能，也可以通过Ribbon的IRule进行策略扩展。
 * 另外，Feign还整合的Hystrix来实现服务的容错保护，在Dalston版本中，Feign的Hystrix默认是关闭的。
 * Created by admin on 2017/10/13.
 */
// 通过@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
