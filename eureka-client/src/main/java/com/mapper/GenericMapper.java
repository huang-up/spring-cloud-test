package com.mapper;

import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by h on 2018/4/25.
 */
@NoRepositoryBean
public interface GenericMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
