package com.controller;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.util.HystrixUtil;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by admin on 2017/11/21.
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Value("${service.hotel.url}")
    private String HOTEL_URL;

    @Value("${service.hotel.name}")
    private String hotelServiceName;

    @Value("${service.hotel.method.getHotelInfo}")
    private String hotelServiceMethodGetHotelInfo;

    @Autowired
    private HystrixUtil hystrixUtil;

    @GetMapping(value = "/firstHystrix")
    public String getHotelInfo(@RequestParam("id") int id, @RequestParam("name") String name) {
        String url = String.format(HOTEL_URL, id, name);
        Response response = null;
        try {
            response = hystrixUtil.execute(hotelServiceName, hotelServiceMethodGetHotelInfo, url);
            if (response != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (response != null && response.body() != null) {
                response.body().close();// 资源关闭
            }
        }
        return "获取酒店信息失败";
    }

}
