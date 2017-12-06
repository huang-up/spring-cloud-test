package com.feign;

import com.fallback.DcClientHystrix;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过Spring Cloud Feign来实现服务调用的方式更加简单了，
 * 通过@FeignClient定义的接口来统一的生命我们需要依赖的微服务接口。
 * 而在具体使用的时候就跟调用本地方法一样的进行调用即可。
 * Created by admin on 2017/10/13.
 */

// 使用@FeignClient注解来指定这个接口所要调用的服务名称
// 关闭eureka-client服务，执行fallback表示熔断成功
@FeignClient(name = "eureka-client", fallback = DcClientHystrix.class)
@Qualifier(value = "dcClient")
public interface DcClient {
    @GetMapping("/dc")
    String consumer();

    @GetMapping("/dc")
    String consumerDc();
}
