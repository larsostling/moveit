package com.larsostling.moveit.service;

import com.larsostling.moveit.model.Quotation;

import javax.inject.Singleton;

@Singleton
public class PricingCalculator {

    public int calculatePriceForQuotation(Quotation quotation) {
        int pricePerCar = calculatePriceForDistance(quotation.getDistanceInKilometers());
        int numberOfCars =
                calculateNumberOfCars(quotation.getAreaInSquareMeters(), quotation.getStorageAreaInSquareMeters());
        int priceForPiano = getPriceForPiano(quotation.getIncludePiano());
        return pricePerCar * numberOfCars + priceForPiano;
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

    private int calculateNumberOfCars(int area, int storageArea) {
        int totalArea = area + 2 * storageArea;
        return 1 + totalArea / 50;
    }

    private int getPriceForPiano(boolean includePiano) {
        return includePiano ? 5000 : 0;
    }
}
