package com;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by admin on 2017/10/13.
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AdminServerApplication.class).web(true).run(args);
    }
}
