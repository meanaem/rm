package com.aarintech.rm.openapi.domain.cache;

import com.google.common.collect.Table;

import org.joda.time.DateTime;

import java.util.Map;

/**
 * Created by vireshkj on 3/29/15.
 */
public class HistoricalBookingCache {

  Map<String, Table<DateTime, Integer, Integer>> historicalBookings;

  public int getBookings(String flightNumber, String cabinClass, DateTime departureDateTime,
                         int daysBeforeDeparture) {
    String bookingKey = getBookingKey(flightNumber, cabinClass);
    Table<DateTime, Integer, Integer>
        historicalBookingForGivenFlight =
        historicalBookings.get(bookingKey);
    Map<Integer, Integer>
        historyForGivenDepartureDate =
        historicalBookingForGivenFlight.row(departureDateTime);
    return historyForGivenDepartureDate.get(daysBeforeDeparture);
  }

  private String getBookingKey(String flightNumber, String cabinClass) {
    return flightNumber + "_" + cabinClass;
  }

//  public void addBooking(String flightNumber, String cabinClass, DateTime departureDateTime, int daysBeforeDeparture, int numberOfBookings) {
//    String bookingKey = getBookingKey(flightNumber, cabinClass);
//    Map<Integer, Integer> historyForGivenDepartureDate = newHashMap();
//    historyForGivenDepartureDate.put(daysBeforeDeparture, numberOfBookings);
//    hi
//  }

}
