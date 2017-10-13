package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring Cloud Eureka是Spring Cloud Netflix项目下的服务治理模块。
 * 而Spring Cloud Netflix项目是Spring Cloud的子项目之一，主要内容是对Netflix公司一系列开源产品的包装，
 * 它为Spring Boot应用提供了自配置的Netflix OSS整合。
 * 通过一些简单的注解，开发者就可以快速的在应用中配置一下常用模块并构建庞大的分布式系统。
 * 它主要提供的模块包括：服务发现（Eureka），断路器（Hystrix），智能路由（Zuul），客户端负载均衡（Ribbon）等。
 *
 * 启动类需要放在根包下，这样默认会扫描根包下的注解
 * Created by admin on 2017/10/12.
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(true).run(args);
    }
}
