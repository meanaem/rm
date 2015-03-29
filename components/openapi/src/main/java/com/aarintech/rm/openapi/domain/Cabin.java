package com.aarintech.rm.openapi.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by vireshkj on 3/22/15.
 */
@Data
public class Cabin {
    private int capacity;
    private int bookingLimit;
    private List<ServiceClass> serviceClasses;
}
