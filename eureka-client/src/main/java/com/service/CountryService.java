package com.service;

import com.domain.Country;
import com.github.pagehelper.Page;

/**
 * Created by h on 2018/4/25.
 */
public interface CountryService {
    Country findById(Integer id);
}
