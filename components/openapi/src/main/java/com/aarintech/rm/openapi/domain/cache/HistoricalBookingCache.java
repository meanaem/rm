package com.aarintech.rm.openapi.domain.cache;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Created by vireshkj on 3/29/15.
 */
@Component
public class HistoricalBookingCache {

  Map<String, Table<DateTime, Integer, Integer>> historicalBookings = newHashMap();
//  HashBasedTable.create();

  public Integer getBookings(String flightNumber, String cabinClass, DateTime departureDateTime,
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

  public void addBooking(String flightNumber, String cabinClass, DateTime departureDateTime,
                         int daysBeforeDeparture, Integer numberOfBookings) {
    String bookingKey = getBookingKey(flightNumber, cabinClass);
    Table<DateTime, Integer, Integer> historicalBookingForGivenFlight = getTable(bookingKey);
    historicalBookingForGivenFlight.put(departureDateTime, daysBeforeDeparture, numberOfBookings);
    historicalBookings.put(bookingKey, historicalBookingForGivenFlight);
  }

  private Table<DateTime, Integer, Integer> getTable(String bookingKey) {
    Table<DateTime, Integer, Integer>
        dateTimeIntegerIntegerTable =
        historicalBookings.get(bookingKey);
    if (dateTimeIntegerIntegerTable == null) {
      dateTimeIntegerIntegerTable = HashBasedTable.create();
      historicalBookings.put(bookingKey, dateTimeIntegerIntegerTable);
    }
    return dateTimeIntegerIntegerTable;
  }


  public Collection<Integer> getBookingsAt(int daysBeforeDeparture, String flightNumber,
                                           String cabinClass,
                                           DateTime departureDateTime) {

    Table<DateTime, Integer, Integer>
        dateTimeIntegerIntegerTable =
        historicalBookings.get(getBookingKey(flightNumber, cabinClass));
    return dateTimeIntegerIntegerTable.column(daysBeforeDeparture).values();
  }
}
