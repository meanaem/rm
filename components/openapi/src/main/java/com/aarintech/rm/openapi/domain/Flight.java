package com.aarintech.rm.openapi.domain;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;

/**
 * Created by vireshkj on 3/28/15.
 */
public class Flight {

  List<Cabin> cabins;

  public Cabin getCabin(String cabinClass) {
    Collection<Cabin>
        matchingCabins =
        filter(cabins, cabin -> cabin.getCabinClass().equals(cabinClass));
    if (matchingCabins != null && !matchingCabins.isEmpty()) {
      return matchingCabins.iterator().next();
    }
    return null;
  }
}
