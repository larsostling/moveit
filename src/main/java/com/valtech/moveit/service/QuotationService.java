package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuotationService {

    @Inject
    PricingCalculator pricingCalculator;

    private Map<String, Quotation> repository = new HashMap<>();

    public Quotation addQuotation(Quotation quotation) {
        quotation.setPrice(pricingCalculator.calculatePriceForQuotation(quotation));
        String quotationId = generateQuotationId();
        quotation.setQuotationId(quotationId);
        repository.put(quotationId, quotation);
        return quotation;
    }

    public Quotation getQuotation(String quotationId) {
        return repository.get(quotationId);
    }

    private String generateQuotationId() {
        String quotationId = UUID.randomUUID().toString();
        return quotationId.replaceAll("-", "");
    }
}
