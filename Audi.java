package org.example;

public class Audi extends Car {

    private boolean isRSComplectation;

    public Audi(String model, int fuelConsumptionPer100Kilometers, int maxspeed, int speedForOptimalFuel, int priceRentalOneDay, int priceTaxiPerkilometer, String factoryCountry, int carPrice, boolean isRSComplectation) {
        super(model, fuelConsumptionPer100Kilometers, maxspeed, speedForOptimalFuel, priceRentalOneDay, priceTaxiPerkilometer, factoryCountry, carPrice);
        this.isRSComplectation = isRSComplectation;
    }

    public boolean isRSComplectation() {
        return isRSComplectation;
    }

    public void setRSComplectation(boolean RSComplectation) {
        isRSComplectation = RSComplectation;
    }

}
