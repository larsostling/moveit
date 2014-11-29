package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class QuotationServiceTest {

    QuotationService underTest;

    @Before
    public void setUp() {
        underTest = new QuotationService();
    }

    @Test
    public void addQuotation() {
        Quotation quotation = new Quotation(10, 49, 0, false);
        Quotation addedQuotation = underTest.addQuotation(quotation);
        assertThat(addedQuotation.getDistanceInKilometers(), is(quotation.getDistanceInKilometers()));
        assertThat(addedQuotation.getAreaInSquareMeters(), is(quotation.getAreaInSquareMeters()));
        assertThat(addedQuotation.getStorageAreaInSquareMeters(), is(quotation.getStorageAreaInSquareMeters()));
        assertThat(addedQuotation.isIncludePiano(), is(quotation.isIncludePiano()));
        assertThat(addedQuotation.getPrice(), is(1100));
        assertThat(addedQuotation.getQuotationId(), is(notNullValue()));
    }
}
