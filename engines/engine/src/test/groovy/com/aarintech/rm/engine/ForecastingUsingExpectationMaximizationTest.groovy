package com.aarintech.rm.engine

import com.aarintech.rm.openapi.domain.cache.HistoricalBookingCache
import org.hamcrest.core.Is
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/28/15.
 */
@RunWith(MockitoJUnitRunner)
class ForecastingUsingExpectationMaximizationTest {

    ForecastingUsingExpectationMaximization forecastingUsingExpectationMaximization;
    private final String FLIGHT_NUMBER = "XX100"
    private final String CABIN_CLASS = "Y"
    HistoricalBookingCache historicalBookingCache = new HistoricalBookingCache()
    def formatter

    @Before
    public void setUp() {
        forecastingUsingExpectationMaximization = new ForecastingUsingExpectationMaximization(
                historicalBookingCache: historicalBookingCache)

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

        departureDateTime = formatter.parseDateTime("2014-09-28")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 4);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 4);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 5);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 11);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, 16);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, 20);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, 22);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, 27);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, 27);

        departureDateTime = formatter.parseDateTime("2014-10-05")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 5);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 9);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 9);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 11);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 18);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, 18);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, 18);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, 23);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, 28);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, 28);

        departureDateTime = formatter.parseDateTime("2014-10-12")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 7);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 14);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, 20);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, 22);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, 24);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, 24);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, 27);

        departureDateTime = formatter.parseDateTime("2014-10-19")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 4);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 14);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 21);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, 28);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, 28);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, 32);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-10-26")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 6);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 9);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 15);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, 22);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-11-02")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 5);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 6);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, 6);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-11-09")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 2);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 3);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 6);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, 9);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-11-16")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 0);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-11-23")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 1);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, 4);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-11-30")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 0);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

        departureDateTime = formatter.parseDateTime("2014-12-07")
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 180, 0);
        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 90, 4);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 40, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 30, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 20, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 10, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 8, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 6, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 4, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 2, null);
//        historicalBookingCache.addBooking(FLIGHT_NUMBER, CABIN_CLASS, departureDateTime, 0, null);

    }

    @Test
    public void correctlyCalculatesForecastedDemandAtDepartureTimeWhenDemandAtDepartureIsNotAvailable()
            throws Exception {
        def demandAtDepartureDate = forecastingUsingExpectationMaximization.
                getForcastedDemandAtDepartureDate(FLIGHT_NUMBER, CABIN_CLASS,
                                                  formatter.parseDateTime("2014-10-26"))

        assertThat(demandAtDepartureDate, Is.is(28))

    }

    @Test
    public void correctlyCalculatesForecastedDemandAtDepartureTimeWhenDemandAtDepartureIsAvailable()
            throws Exception {
        def demandAtDepartureDate = forecastingUsingExpectationMaximization.
                getForcastedDemandAtDepartureDate(FLIGHT_NUMBER, CABIN_CLASS,
                                                  formatter.parseDateTime("2014-10-12"))

        assertThat(demandAtDepartureDate, Is.is(27))

    }

    @Test
    public void correctlyCalculatesDemandToComeAtGivenTime() throws Exception {
        def demandToCome = forecastingUsingExpectationMaximization.
                calculateDemandToCome(FLIGHT_NUMBER, CABIN_CLASS,
                                      formatter.parseDateTime("2014-10-26"), 10)
        assertThat(demandToCome, Is.is(6))
    }


}
