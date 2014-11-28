package com.valtech.moveit.model;

public class Quotation {

    private int distanceInKilometers;
    private int areaInSquareMeters;
    private int storageAreaInSquareMeters;
    private boolean includePiano;

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

    public boolean isIncludePiano() {
        return includePiano;
    }

    public void setIncludePiano(boolean includePiano) {
        this.includePiano = includePiano;
    }
}
