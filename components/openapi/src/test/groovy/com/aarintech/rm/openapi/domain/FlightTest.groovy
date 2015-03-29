package com.aarintech.rm.openapi.domain

import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/29/15.
 */
@RunWith(MockitoJUnitRunner)
class FlightTest {

    Flight flight;
    private static final String CABIN_CLASS = "Y"
    @Mock
    Cabin mockCabin1
    @Mock
    Cabin mockCabin2
    @Mock
    Cabin mockCabin3
    @Mock
    Cabin mockCabin4
    @Mock
    Cabin mockCabin5

    @Before
    public void setUp() {
        flight = new Flight(cabins: [mockCabin1, mockCabin2, mockCabin3, mockCabin4, mockCabin5])
    }

    @Test
    public void correctlyFiltersListOfCabinsGivenACabinClass() throws Exception {

        Mockito.when(mockCabin1.getCabinClass()).thenReturn("A")
        Mockito.when(mockCabin2.getCabinClass()).thenReturn(CABIN_CLASS)
        Mockito.when(mockCabin3.getCabinClass()).thenReturn("B")
        Mockito.when(mockCabin4.getCabinClass()).thenReturn("C")
        Mockito.when(mockCabin5.getCabinClass()).thenReturn("D")
        Cabin cabin = flight.getCabin(CABIN_CLASS)
        assertThat(cabin, Is.is(mockCabin2))


    }
}
