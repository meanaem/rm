package com.aarintech.rm.openapi.domain.cache;

import com.aarintech.rm.openapi.domain.Flight;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by vireshkj on 3/29/15.
 */
@Component
public class FlightCache {

  Map<String, Flight> flights;


  public Flight getFlight(String flightNumber) {
    return flights.get(flightNumber);
  }
}
