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

  private final transient Map<String, Table<DateTime, Integer, Integer>>
      historicalBookings =
      newHashMap();

  public Integer getBookings(String flightNumber, String cabinClass, DateTime departureDateTime,
                         int daysBeforeDeparture) {
    String bookingKey = getBookingKey(flightNumber, cabinClass);
    final Table<DateTime, Integer, Integer>
        historicalBookingForGivenFlight =
        historicalBookings.get(bookingKey);
    final Map<Integer, Integer>
        historyForGivenDepartureDate =
        historicalBookingForGivenFlight.row(departureDateTime);
    final Integer bookings = historyForGivenDepartureDate.get(daysBeforeDeparture);
    return bookings;
  }

  public void addBooking(String flightNumber, String cabinClass, DateTime departureDateTime,
                         int daysBeforeDeparture, Integer numberOfBookings) {
    final String bookingKey = getBookingKey(flightNumber, cabinClass);
    final Table<DateTime, Integer, Integer> historicalBookingForGivenFlight = getTable(bookingKey);
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
                                           String cabinClass) {

    final String bookingKey = getBookingKey(flightNumber, cabinClass);
    final Table<DateTime, Integer, Integer>
        dateTimeIntegerIntegerTable =
        historicalBookings.get(bookingKey);
    final Collection<Integer>
        bookings =
        dateTimeIntegerIntegerTable.column(daysBeforeDeparture).values();
    return bookings;
  }


  private String getBookingKey(String flightNumber, String cabinClass) {
    return flightNumber + "_" + cabinClass;
  }
}
