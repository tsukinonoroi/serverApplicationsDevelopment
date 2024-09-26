package org.example;

import java.util.ArrayList;

public class Car {
    private String model;
    private int fuelConsumptionPer100Kilometers;
    private int maxspeed;
    private int speedForOptimalFuel; // максимальная скорость для оптимального
    // потребления топлива (например, 8л/100км при скорости 110кмч)
    private int priceRentalOneDay;
    private int priceTaxiPerkilometer;
    private String factoryCountry;


    private int carPrice;

    public final Car addToCarList(ArrayList<Car> carList) {
        carList.add(this);
        return this;
    }

    public Car(String model, int fuelConsumptionPer100Kilometers, int maxspeed,
               int speedForOptimalFuel, int priceRentalOneDay, int priceTaxiPerkilometer,
               String factoryCountry, int carPrice) {
        this.model = model;
        this.fuelConsumptionPer100Kilometers = fuelConsumptionPer100Kilometers;
        this.maxspeed = maxspeed;
        this.speedForOptimalFuel = speedForOptimalFuel;
        this.priceRentalOneDay = priceRentalOneDay;
        this.priceTaxiPerkilometer = priceTaxiPerkilometer;
        this.factoryCountry = factoryCountry;
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Модель : " + model + "\n" +
                "-----------------------------------\n" +
                "Расход топлива (на 100 км)  : " + fuelConsumptionPer100Kilometers + " л\n" +
                "Максимальная скорость : " + maxspeed + " л\n" +
                "Оптимальная скорость для 8л/100км  : " + speedForOptimalFuel + " л\n" +
                "Цена аренды (за 1 день)     : " + priceRentalOneDay + " руб.\n" +
                "Цена такси (за километр)    : " + priceTaxiPerkilometer + " руб.\n" +
                "Страна производства         : " + factoryCountry + "\n" +
                "Стоимость автомобиля        : " + carPrice + " руб.\n" +
                "-----------------------------------";
    }

    public String getModel() {
        return model;
    }

    public int getFuelConsumptionPer100Kilometers() {
        return fuelConsumptionPer100Kilometers;
    }

    public int getPriceRentalOneDay() {
        return priceRentalOneDay;
    }

    public int getPriceTaxiPerkilometer() {
        return priceTaxiPerkilometer;
    }

    public String getFactoryCountry() {
        return factoryCountry;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelConsumptionPer100Kilometers(int fuelConsumptionPer100Kilometers) {
        this.fuelConsumptionPer100Kilometers = fuelConsumptionPer100Kilometers;
    }

    public void setPriceRentalOneDay(int priceRentalOneDay) {
        this.priceRentalOneDay = priceRentalOneDay;
    }

    public void setPriceTaxiPerkilometer(int priceTaxiPerkilometer) {
        this.priceTaxiPerkilometer = priceTaxiPerkilometer;
    }

    public void setFactoryCountry(String factoryCountry) {
        this.factoryCountry = factoryCountry;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }


}


