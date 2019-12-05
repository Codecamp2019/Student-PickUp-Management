package org.launchcode.StudentPickUpManagement.models.Entity;

public enum pickUpType {
    BUS_LINE("BusLine"),
    CAR_LINE("CarLine"),
    WALKERS("Walkers"),
    AFTERCARE("AfterCare");

    String type;

    pickUpType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
