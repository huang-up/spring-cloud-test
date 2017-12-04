package com.controller;

import com.domain.Hotel;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2017/11/21.
 */
@RestController
@RequestMapping("/hotel")
@Api(name = "HotelController相关api", description = "HotelController相关api")
public class HotelController {
    @ApiMethod(description = "获取酒店Hotel信息：getHotelInfo")
    @GetMapping(value = "/getHotelInfo")
    public Hotel getHotelInfo(@RequestParam("id") int id, @RequestParam("name") String name) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(3000);//用于测试超时
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new Hotel(id, name);
    }
}
