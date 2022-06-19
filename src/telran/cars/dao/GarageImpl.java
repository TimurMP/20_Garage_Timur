package telran.cars.dao;

import telran.cars.interfaces.Garage;
import telran.cars.model.Car;

public class GarageImpl implements Garage {
    Car[] cars;
    int size;





    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public Car removeCar(String regNumber) {
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return new Car[0];
    }

    @Override
    public Car[] findCarsByColor(String color) {
        return new Car[0];
    }
}
