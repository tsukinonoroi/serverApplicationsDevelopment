package org.example;

public class Mercedes extends Car {
    private boolean isAMGComplectation;

    public Mercedes(String model, int fuelConsumptionPer100Kilometers, int maxspeed, int speedForOptimalFuel, int priceRentalOneDay, int priceTaxiPerkilometer, String factoryCountry, int carPrice, boolean isAMGComplectation) {
        super(model, fuelConsumptionPer100Kilometers, maxspeed, speedForOptimalFuel, priceRentalOneDay, priceTaxiPerkilometer, factoryCountry, carPrice);
        this.isAMGComplectation = isAMGComplectation;
    }

    public boolean isAMGComplectation() {
        return isAMGComplectation;
    }

    public void setAMGComplectation(boolean AMGComplectation) {
        isAMGComplectation = AMGComplectation;
    }

}
