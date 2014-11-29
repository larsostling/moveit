package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;

import javax.inject.Inject;
import java.util.UUID;

public class QuotationService {

    @Inject
    PricingCalculator pricingCalculator;

    public Quotation addQuotation(Quotation quotation) {
        quotation.setPrice(pricingCalculator.calculatePriceForQuotation(quotation));
        quotation.setQuotationId(generateQuotationId());
        return quotation;
    }

    private String generateQuotationId() {
        String quotationId = UUID.randomUUID().toString();
        return quotationId.replaceAll("-", "");
    }
}
