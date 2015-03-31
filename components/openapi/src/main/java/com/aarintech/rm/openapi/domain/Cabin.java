package com.aarintech.rm.openapi.domain;

import java.util.List;

import lombok.Getter;

/**
 * Created by vireshkj on 3/22/15.
 */
@Getter
public class Cabin {
  private int capacity;
  private int bookingLimit;
  private String cabinClass;
  private List<ServiceClass> serviceClasses;
}
