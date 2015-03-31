package com.aarintech.rm.openapi.domain

import org.hamcrest.Matchers
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/30/15.
 *
 */
@RunWith(MockitoJUnitRunner)
class CabinTest {

    Cabin cabin
    @Mock
    ServiceClass mockServiceClass

    @Before
    public void setUp() {
        cabin = new Cabin(cabinClass: "Y", capacity: 100, bookingLimit: 100,
                          serviceClasses: [mockServiceClass] as List<ServiceClass>)
    }

    @Test
    public void testCabinClass() throws Exception {
        assertThat(cabin.getCabinClass(), Is.is("Y"))
        assertThat(cabin.getServiceClasses(), Matchers.contains(mockServiceClass))
        assertThat(cabin.getCapacity(), Is.is(100))
        assertThat(cabin.getBookingLimit(), Is.is(100))
    }
}
