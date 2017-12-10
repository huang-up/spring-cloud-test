package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Created by h on 2017/12/9.
 */
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "test")
public class TestConfig {
    // 这里的@Value注解识别不了
    @Value("${str:default test str}")
    private String testStr;
    private Foo foo;
    private Bar bar;

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
