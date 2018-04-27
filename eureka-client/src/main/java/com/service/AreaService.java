package com.service;

import com.domain.Area;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
public interface AreaService {
    Page<Area> findByPage();
    List<Area> findAll();
    List<Area> selectAreas();
    int insert();
    List<Area> insertList();
    int delete(int id);
}
