package com.aarintech.rm.engine;

import com.aarintech.rm.openapi.domain.Flight;
import com.aarintech.rm.openapi.domain.cache.FlightCache;

import javax.annotation.Resource;


/**
 * Created by vireshkj on 3/28/15.
 */
public class HistoricalBooking {

  @Resource FlightCache flightCache;

  public void getHistoricalBooking(String flightNumber, String cabinClass) {

    Flight flight = flightCache.getFlight(flightNumber);
    flight.getCabin(cabinClass);

  }
}
