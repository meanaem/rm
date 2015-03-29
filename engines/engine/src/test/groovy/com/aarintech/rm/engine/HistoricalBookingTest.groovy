package com.aarintech.rm.engine

import org.junit.Before
import org.junit.Test

import static org.mockito.Mockito.verify

/**
 * Created by vireshkj on 3/28/15.
 */
class HistoricalBookingTest {
    HistoricalBooking historicalBooking;

    @Before
    public void setUp() {
        historicalBooking = new HistoricalBooking()
    }

    @Test
    public void historicalBookingHasAtleastOneFlight() throws Exception {

        historicalBooking.getHistoricalBooking()

        verify(historicalBooking).getFlight();

//        Assert.fail("Not implemented yet");
    }


}
