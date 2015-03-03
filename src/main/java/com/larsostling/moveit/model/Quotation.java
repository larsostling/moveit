package com.larsostling.moveit.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Quotation {

    private String requesterName;
    private String requesterEmail;
    private String fromAddress;
    private String toAddress;
    private int distanceInKilometers;
    private int areaInSquareMeters;
    private int storageAreaInSquareMeters;
    private boolean includePiano;

    private int price;
    private String quotationId;

    public Quotation() {}

    public Quotation(String requesterName, String requesterEmail, String fromAddress, String toAddress,
                     int distanceInKilometers, int areaInSquareMeters, int storageAreaInSquareMeters,
                     boolean includePiano) {
        this.requesterName = requesterName;
        this.requesterEmail = requesterEmail;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.distanceInKilometers = distanceInKilometers;
        this.areaInSquareMeters = areaInSquareMeters;
        this.storageAreaInSquareMeters = storageAreaInSquareMeters;
        this.includePiano = includePiano;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
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
