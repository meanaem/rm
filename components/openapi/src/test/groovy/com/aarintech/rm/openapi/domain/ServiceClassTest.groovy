package com.aarintech.rm.openapi.domain

import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat

/**
 * Created by vireshkj on 3/30/15.
 */
class ServiceClassTest {

    ServiceClass serviceClass

    @Before
    public void setUp() {
        serviceClass = new ServiceClass(serviceClassId: "Y")
    }

    @Test
    public void testServiceClassIdIsInitialized() throws Exception {
        assertThat(serviceClass.getServiceClassId(), Is.is("Y"))
    }
}
