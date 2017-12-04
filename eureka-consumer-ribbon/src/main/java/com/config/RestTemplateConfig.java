package com.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * REST接口配置
 * @author Administrator
 *
 */
@Configuration
public class RestTemplateConfig {
	
	private static final int CONNECT_TIMEOUT = 10000;
	private static final int READ_TIMEOUT = 30000;

	/**
	 * REST接口
	 * @param builder 接口构建器
	 * @return REST接口
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(CONNECT_TIMEOUT).setReadTimeout(READ_TIMEOUT).build();
	}
    
}
