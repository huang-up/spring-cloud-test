package com.controller;

import com.alibaba.fastjson.JSON;
import com.config.TestConfig;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by h on 2017/12/7.
 */
@Api(description = "The config controller", name = "Config service")
@RestController
@RequestMapping(value = "/config")
public class ConfigController {
    @Value("${str:default str}")
    private String str;
    @Autowired
    private TestConfig testConfig;

    @ApiMethod
    @GetMapping(value = "/{foo}")
    public @ApiResponseObject String foo(@ApiBodyObject() @RequestBody(required = false) Object test,
                                   @ApiPathParam @PathVariable String foo,
                                   @ApiQueryParam @RequestParam(required = false, defaultValue = "1") Object id,
                                   UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("PathVariable:" + id);
        System.out.println("RequestParam:" + foo);
        return JSON.toJSONString(this.testConfig);
//        return JSON.toJSONString(testConfig) + ", str is " + str;
    }

    /*@ApiMethod
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ApiResponseObject ResponseEntity<Void> save(@ApiBodyObject @RequestBody Book book, UriComponentsBuilder uriComponentsBuilder) {
        bookRepository.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }*/
}
