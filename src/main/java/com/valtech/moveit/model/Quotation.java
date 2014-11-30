package com.valtech.moveit.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quotation {

    private int distanceInKilometers;
    private int areaInSquareMeters;
    private int storageAreaInSquareMeters;
    private boolean includePiano;

    private int price;
    private String quotationId;

    public Quotation() {}

    public Quotation(int distanceInKilometers, int areaInSquareMeters, int storageAreaInSquareMeters,
                     boolean includePiano) {
        this.distanceInKilometers = distanceInKilometers;
        this.areaInSquareMeters = areaInSquareMeters;
        this.storageAreaInSquareMeters = storageAreaInSquareMeters;
        this.includePiano = includePiano;
    }

    public int getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public void setDistanceInKilometers(int distanceInKilometers) {
        this.distanceInKilometers = distanceInKilometers;
    }

    public int getAreaInSquareMeters() {
        return areaInSquareMeters;
    }

    public void setAreaInSquareMeters(int areaInSquareMeters) {
        this.areaInSquareMeters = areaInSquareMeters;
    }

    public int getStorageAreaInSquareMeters() {
        return storageAreaInSquareMeters;
    }

    public void setStorageAreaInSquareMeters(int storageAreaInSquareMeters) {
        this.storageAreaInSquareMeters = storageAreaInSquareMeters;
    }

    public boolean getIncludePiano() {
        return includePiano;
    }

    public void setIncludePiano(boolean includePiano) {
        this.includePiano = includePiano;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }
}
