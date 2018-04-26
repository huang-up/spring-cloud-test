package com.service.impl;

import com.domain.Area;
import com.github.pagehelper.Page;
import com.mapper.impl.AreaMapper;
import com.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public Page<Area> findByPage() {
        return areaMapper.findByPage();
    }

    @Override
    public List<Area> findAll() {
        return areaMapper.findAll();
    }

    @Transactional
    @Rollback
    public int insert() {
        Area area = new Area();
        int i = areaMapper.insertSelective(area);
        return i > 0 ? area.getId() : i;
    }

    @Transactional
    @Rollback
    public List<Area> insertList() {
        List<Area> areas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            areas.add(new Area());
        }
        int i = areaMapper.insertList(areas);
        return i  > 0 ? areas : null;
    }

    @Transactional
    @Rollback
    public int delete() {
        return areaMapper.deleteByPrimaryKey(100);
    }
}
