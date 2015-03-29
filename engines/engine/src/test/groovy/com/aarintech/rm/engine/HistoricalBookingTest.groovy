package com.aarintech.rm.engine

import com.aarintech.rm.openapi.domain.Cabin
import com.aarintech.rm.openapi.domain.Flight
import com.aarintech.rm.openapi.domain.cache.FlightCache
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

/**
 * Created by vireshkj on 3/28/15.
 */
@RunWith(MockitoJUnitRunner)
class HistoricalBookingTest {
    HistoricalBooking historicalBooking;
    @Mock
    FlightCache mockFlightCache
    @Mock
    Flight mockFlight
    private final String FLIGHT_NUMBER = "XX100"
    private final String CABIN_CLASS = "Y"
    @Mock
    Cabin mockCabin

    @Before
    public void setUp() {
        historicalBooking = new HistoricalBooking(flightCache: mockFlightCache)
    }

    @Test
    public void historicalBookingHasAtleastOneFlight() throws Exception {

        when(mockFlightCache.getFlight(FLIGHT_NUMBER)).thenReturn(mockFlight)
        when(mockFlight.getCabin(CABIN_CLASS)).thenReturn(mockCabin)
        historicalBooking.getHistoricalBooking(FLIGHT_NUMBER, CABIN_CLASS)

        verify(mockFlightCache).getFlight(FLIGHT_NUMBER);
        verify(mockFlight).getCabin(CABIN_CLASS)

    }


}
