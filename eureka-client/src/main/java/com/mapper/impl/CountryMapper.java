package com.mapper.impl;

import com.domain.Area;
import com.domain.Country;
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
public interface CountryMapper extends GenericMapper<Country> {

    @Select("SELECT * FROM country where id = #{id}")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="areas",column="id",javaType=List.class,
                    many=@Many(select="com.mapper.impl.AreaMapper.selectAreaByCountry"))
    })
    Country findById(Integer id);
}
