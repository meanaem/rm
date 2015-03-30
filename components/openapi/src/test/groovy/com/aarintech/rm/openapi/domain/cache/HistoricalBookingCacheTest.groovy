package com.aarintech.rm.openapi.domain.cache

import org.hamcrest.core.Is
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Before
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/29/15.
 */
class HistoricalBookingCacheTest {

    HistoricalBookingCache historicalBookingCache

    private final String FLIGHT_NUMBER = "XX100"
    private final String CABIN_CLASS = "Y"
    def formatter

    @Before
    public void setUp() {
        historicalBookingCache = new HistoricalBookingCache()

    }

    @Test
    public void addsBookingToCacheWhenTheCacheDoesNotContainFlight() throws Exception {
        formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
        DateTime departureDateTime = formatter.parseDateTime("2014-09-21")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 4);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 5);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 10);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 11);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, 13);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, 18);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, 19);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, 23);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, 30);

        assertThat(historicalBookingCache.getBookingsAt(0, FLIGHT_NUMBER, CABIN_CLASS).iterator().
                           next(), Is.is(30))
        assertThat(historicalBookingCache.getBookingsAt(20, FLIGHT_NUMBER, CABIN_CLASS).iterator().
                           next(), Is.is(10))
        assertThat(historicalBookingCache.
                           getBookings(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90), Is.is(3))

    }
}
