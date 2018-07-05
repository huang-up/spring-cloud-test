package com.service.impl;

import com.domain.Area;
import com.domain.Country;
import com.github.pagehelper.Page;
import com.mapper.impl.AreaMapper;
import com.mapper.impl.CountryMapper;
import com.service.AreaService;
import com.service.CountryService;
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
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper countryMapper;
    @Override
    public Country findById(Integer id) {
        return countryMapper.findById(id);
    }
}
