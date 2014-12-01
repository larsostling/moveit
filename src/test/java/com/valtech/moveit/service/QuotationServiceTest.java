package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;
import org.junit.Before;
import org.junit.Test;

import static com.valtech.moveit.TestHelper.assertThatActualQuotationEqualsExpectedQuotation;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuotationServiceTest {

    private static final int EXPECTED_PRICE = 1100;

    QuotationService underTest;

    @Before
    public void setUp() {
        underTest = new QuotationService();
        PricingCalculator calculatorMock = mock(PricingCalculator.class);
        when(calculatorMock.calculatePriceForQuotation(anyObject())).thenReturn(EXPECTED_PRICE);
        underTest.pricingCalculator = calculatorMock;
    }

    @Test
    public void addQuotation() {
        Quotation quotation = new Quotation("", "", "", "", 10, 49, 0, false);
        Quotation addedQuotation = underTest.addQuotation(quotation);
        assertThatActualQuotationEqualsExpectedQuotation(addedQuotation, quotation);
        assertThat(addedQuotation.getPrice(), is(EXPECTED_PRICE));
        assertThat(addedQuotation.getQuotationId(), is(notNullValue()));
    }

    @Test
    public void getQuotation() {
        Quotation quotation = new Quotation("", "", "", "", 10, 49, 0, false);
        Quotation expectedQuotation = underTest.addQuotation(quotation);
        Quotation returnedQuotation = underTest.getQuotation(expectedQuotation.getQuotationId());
        assertThatActualQuotationEqualsExpectedQuotation(returnedQuotation, expectedQuotation);
        assertThat(returnedQuotation.getDistanceInKilometers(), is(expectedQuotation.getDistanceInKilometers()));
        assertThat(returnedQuotation.getAreaInSquareMeters(), is(expectedQuotation.getAreaInSquareMeters()));
        assertThat(returnedQuotation.getStorageAreaInSquareMeters(), is(expectedQuotation.getStorageAreaInSquareMeters()));
        assertThat(returnedQuotation.getIncludePiano(), is(expectedQuotation.getIncludePiano()));
        assertThat(returnedQuotation.getPrice(), is(expectedQuotation.getPrice()));
        assertThat(returnedQuotation.getQuotationId(), is(expectedQuotation.getQuotationId()));
    }
}
