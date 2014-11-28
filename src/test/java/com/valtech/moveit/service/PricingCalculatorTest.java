package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PricingCalculatorTest {

    PricingCalculator underTest;

    @Before
    public void setUp() {
        underTest = new PricingCalculator();
    }

    @Test
    public void calculatePriceForQuotationBasedOnDistance() {
        Quotation quotation = new Quotation(10, 0, 0, false);
        int price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1100));

        quotation = new Quotation(49, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1490));

        quotation = new Quotation(50, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5400));

        quotation = new Quotation(51, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5408));

        quotation = new Quotation(99, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5792));

        quotation = new Quotation(100, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(10700));
    }
}
