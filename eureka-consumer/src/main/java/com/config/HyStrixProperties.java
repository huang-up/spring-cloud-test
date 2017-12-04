package com.config;

/**
 * Created by admin on 2017/11/21.
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hystrix")
public class HyStrixProperties {
    private int timeoutInMillions;

    public int getTimeoutInMillions() {
        return timeoutInMillions;
    }

    public void setTimeoutInMillions(int timeoutInMillions) {
        this.timeoutInMillions = timeoutInMillions;
    }
}
