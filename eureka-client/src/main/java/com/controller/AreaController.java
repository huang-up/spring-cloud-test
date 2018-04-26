package com.controller;

import com.domain.Area;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.GenericMapper;
import com.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
@RestController
@RequestMapping(value = "/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/page")
    public PageInfo<Area> getAreasByPage(@RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum, @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(areaService.findByPage());
        return pageInfo;
    }

    @GetMapping(value = "/all")
    public List<Area> getAreas() {
        return areaService.findAll();
    }

    @GetMapping(value = "insert")
    public int insert() {
        return areaService.insert();
    }

    @GetMapping(value = "insertList")
    public List<Area> insertList() {
        return areaService.insertList();
    }

    @GetMapping(value = "delete")
    public int delete() {
        return areaService.delete();
    }
}
