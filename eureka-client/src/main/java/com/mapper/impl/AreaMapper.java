package com.mapper.impl;

import com.domain.Area;
import com.github.pagehelper.Page;
import com.mapper.GenericMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
@Repository
@Mapper
public interface AreaMapper extends GenericMapper<Area> {
    @Select("select * from area")
    Page<Area> findByPage();
    @Select("select * from area")
    List<Area> findAll();
}
