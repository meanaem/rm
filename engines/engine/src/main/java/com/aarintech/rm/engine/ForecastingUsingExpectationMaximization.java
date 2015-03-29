package com.aarintech.rm.engine;

import com.aarintech.rm.openapi.domain.cache.HistoricalBookingCache;

import org.joda.time.DateTime;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.annotation.Resource;


/**
 * Created by vireshkj on 3/28/15.
 */
public class ForecastingUsingExpectationMaximization {

  @Resource HistoricalBookingCache historicalBookingCache;

  public Integer getForcastedDemandAtDepartureDate(String flightNumber, String cabinClass,
                                                   DateTime departureDateTime) {

    Integer forcastedDemand = null;
    Integer
        historicalBookings =
        historicalBookingCache.getBookings(flightNumber, cabinClass, departureDateTime, 0);

    if (historicalBookings == null) {
      forcastedDemand =
          forecastDemandUsingSimpleAverageMethod(
              historicalBookingCache.getBookingsAt(0, flightNumber, cabinClass, departureDateTime));
    }
    return forcastedDemand;

  }

  private Integer forecastDemandUsingSimpleAverageMethod(Collection<Integer> values) {
    return
        values.stream().collect(
            Collectors.reducing(0,
                                Integer::sum)) / values.size();
  }

  public int calculateDemandToCome(String flightNumber, String cabinClass,
                                   DateTime departureDateTime, int daysBeforeDeparture) {
    Integer
        forcastedDemandAtDepartureDate =
        getForcastedDemandAtDepartureDate(flightNumber, cabinClass, departureDateTime);
    Integer
        bookingsSoFar =
        historicalBookingCache
            .getBookings(flightNumber, cabinClass, departureDateTime, daysBeforeDeparture);
    return forcastedDemandAtDepartureDate - bookingsSoFar;
  }
}
