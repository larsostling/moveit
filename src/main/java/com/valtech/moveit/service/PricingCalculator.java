package com.valtech.moveit.service;

import com.valtech.moveit.model.Quotation;

public class PricingCalculator {
    public int calculatePriceForQuotation(Quotation quotation) {
        return calculatePriceForDistance(quotation.getDistanceInKilometers());
    }

    private int calculatePriceForDistance(int distance) {
        if (distance < 50) {
            return 1000 + 10 * distance;
        } else if (distance < 100) {
            return 5000 + 8 * distance;
        } else {
            return 10000 + 7 * distance;
        }
    }
}
