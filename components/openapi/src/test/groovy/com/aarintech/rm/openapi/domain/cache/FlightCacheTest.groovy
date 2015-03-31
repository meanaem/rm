package com.aarintech.rm.openapi.domain.cache

import com.aarintech.rm.openapi.domain.Flight
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static com.google.common.collect.Maps.newHashMap
import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/30/15.
 */
@RunWith(MockitoJUnitRunner)
class FlightCacheTest {

    FlightCache flightCache
    Map<String, Flight> map = newHashMap()
    @Mock
    Flight mockFlight

    @Before
    public void setUp() {
        map.put("A", mockFlight)
        flightCache = new FlightCache(flights: map)
    }

    @Test
    public void verifyFields() throws Exception {
        assertThat(flightCache.getFlight("A"), Is.is(mockFlight))
    }
}
