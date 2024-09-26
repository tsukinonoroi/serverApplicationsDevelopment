package org.example;

public class Bmw extends Car {
    private boolean isMCompetition;

    public Bmw(String model, int fuelConsumptionPer100Kilometers, int maxspeed, int speedForOptimalFuel, int priceRentalOneDay, int priceTaxiPerkilometer, String factoryCountry, int carPrice, boolean isMCompetition) {
        super(model, fuelConsumptionPer100Kilometers, maxspeed, speedForOptimalFuel, priceRentalOneDay, priceTaxiPerkilometer, factoryCountry, carPrice);
        this.isMCompetition = isMCompetition;
    }

    public boolean isMCompetition() {
        return isMCompetition;
    }

    public void setMCompetition(boolean MCompetition) {
        isMCompetition = MCompetition;
    }


}
