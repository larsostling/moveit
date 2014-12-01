package com.valtech.moveit;

import com.valtech.moveit.model.Quotation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestHelper {
    public static void assertThatActualQuotationEqualsExpectedQuotation(Quotation actual, Quotation expected) {
        assertThat(actual.getRequesterName(), is(expected.getRequesterName()));
        assertThat(actual.getRequesterEmail(), is(expected.getRequesterEmail()));
        assertThat(actual.getFromAddress(), is(expected.getFromAddress()));
        assertThat(actual.getToAddress(), is(expected.getToAddress()));
        assertThat(actual.getDistanceInKilometers(), is(expected.getDistanceInKilometers()));
        assertThat(actual.getAreaInSquareMeters(), is(expected.getAreaInSquareMeters()));
        assertThat(actual.getStorageAreaInSquareMeters(), is(expected.getStorageAreaInSquareMeters()));
        assertThat(actual.getIncludePiano(), is(expected.getIncludePiano()));
    }
}
