package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by admin on 2017/10/12.
 */
@EnableWebMvc // EnableWebMvc 使 Spring Boot 默认为我们提供了静态资源处理 WebMvcAutoConfiguration 失效
//@EnableDiscoveryClient
@SpringBootApplication
//@MapperScan(basePackages = {"com.mapper.impl"})
public class EurekaClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }
}
