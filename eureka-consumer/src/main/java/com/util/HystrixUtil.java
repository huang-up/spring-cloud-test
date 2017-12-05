package com.util;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.config.HyStrixProperties;
import com.hystrix.MyHystrixCommand;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
/**
 * Created by admin on 2017/11/21.
 */


@Component
public class HystrixUtil {

    @Autowired
    private HyStrixProperties hp;

    public Response execute(String hotelServiceName,
                            String hotelServiceMethodGetHotelInfo,
                            String url) throws InterruptedException, ExecutionException {
        Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(hotelServiceName));//被调用服务
        setter.andCommandKey(HystrixCommandKey.Factory.asKey(hotelServiceMethodGetHotelInfo));//被调用服务的一个被调用方法
        setter.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(hp.getTimeoutInMillions()));
        return new MyHystrixCommand(setter, url).execute();//同步执行
//        Future<Response> future = new MyHystrixCommand(setter, url).queue();//异步执行
//        return future.get();//需要时获取
    }

}