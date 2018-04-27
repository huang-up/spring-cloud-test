package com.mapper.impl;

import com.domain.Area;
import com.github.pagehelper.Page;
import com.mapper.GenericMapper;
import com.mapper.driver.SimpleSelectInExtendedLanguageDriver;
import com.mapper.driver.SimpleUpdateExtendedLanguageDriver;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
@Repository
@Mapper
public interface AreaMapper extends GenericMapper<Area> {

    @Select("SELECT * FROM area")
    Page<Area> findByPage();

    @Select("SELECT * FROM area")
    List<Area> findAll();

    @Lang(SimpleSelectInExtendedLanguageDriver.class)
    @Select("SELECT * FROM area WHERE id IN (#{ids})")
    List<Area> selectAreas(@Param("ids") List<Integer> ids);

    @Lang(SimpleUpdateExtendedLanguageDriver.class)
    @Update("UPDATE area (#{area}) WHERE id = #{id} and name = #{name}")
    int updateArea(Area area);
}
