package com.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jsondoc.core.annotation.ApiObject;

/**
 * Created by h on 2017/12/10.
 */
@ApiObject
@Data
@EqualsAndHashCode
public class Bar {
    private String name;
    private int age;
}
