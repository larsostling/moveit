package com.larsostling.moveit.service;

import com.larsostling.moveit.model.Quotation;
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
        Quotation quotation = new Quotation("", "", "", "", 10, 0, 0, false);
        int price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1100));

        quotation = new Quotation("", "", "", "", 49, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1490));

        quotation = new Quotation("", "", "", "", 50, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5400));

        quotation = new Quotation("", "", "", "", 51, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5408));

        quotation = new Quotation("", "", "", "", 99, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(5792));

        quotation = new Quotation("", "", "", "", 100, 0, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(10700));
    }

    @Test
    public void calculatePriceForQuotationBasedOnArea() {
        Quotation quotation = new Quotation("", "", "", "", 10, 49, 0, false);
        int price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1100));

        quotation = new Quotation("", "", "", "", 10, 10, 25, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(2200));

        quotation = new Quotation("", "", "", "", 10, 50, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(2200));

        quotation = new Quotation("", "", "", "", 10, 100, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(3300));

        quotation = new Quotation("", "", "", "", 10, 150, 0, false);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(4400));
    }

    @Test
    public void calculatePriceForQuotationWithOrWithoutPiano() {
        Quotation quotation = new Quotation("", "", "", "", 10, 49, 0, false);
        int price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(1100));

        quotation = new Quotation("", "", "", "", 10, 49, 0, true);
        price = underTest.calculatePriceForQuotation(quotation);
        assertThat(price, is(6100));
    }
}
