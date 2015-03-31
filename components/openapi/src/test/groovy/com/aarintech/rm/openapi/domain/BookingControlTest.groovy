package com.aarintech.rm.openapi.domain

import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/30/15.
 */
@RunWith(MockitoJUnitRunner)
class BookingControlTest {

    BookingControl bookingControl
    @Mock
    Cabin mockCabin

    @Before
    public void setUp() {
        bookingControl = new BookingControl(capacity: 100, cabins: [mockCabin])
    }

    @Test
    public void verifyElements() throws Exception {
        assertThat(bookingControl.getCapacity(), Is.is(100))
        assertThat(bookingControl.getCabins(), Is.is([mockCabin] as List<Cabin>))
    }
}
