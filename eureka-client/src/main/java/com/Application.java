package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by admin on 2017/10/12.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(
                Application.class)
                .web(true).run(args);
    }
}
