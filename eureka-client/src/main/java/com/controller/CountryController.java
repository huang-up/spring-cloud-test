package com.controller;

import com.domain.Area;
import com.domain.Country;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AreaService;
import com.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by h on 2018/4/25.
 */
@RestController
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/{id}")
    public Country getCountry(@PathVariable(name = "id") int id) {
        return countryService.findById(id);
    }
}
