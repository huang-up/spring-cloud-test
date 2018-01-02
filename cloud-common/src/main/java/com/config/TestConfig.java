package com.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Created by h on 2017/12/9.
 */
@Data
@EqualsAndHashCode
@ApiObject(description = "test config")
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "test")
public class TestConfig {
    // 这里的@Value注解识别不了
    @Value("${str:default test str}")
    private String testStr;

    @ApiObjectField(description = "The foo")
    private Foo foo;

    @ApiObjectField(description = "The bar")
    private Bar bar;

}
