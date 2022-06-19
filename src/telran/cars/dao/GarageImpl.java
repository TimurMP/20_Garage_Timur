package telran.cars.dao;

import telran.cars.interfaces.Garage;
import telran.cars.model.Car;

import java.util.function.Predicate;

public class GarageImpl implements Garage {
    Car[] cars;
    int size;


    public GarageImpl(int capacity) {
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (cars.length == size) {
            return false;
        }
        if (car.equals(findCarByRegNumber(car.getRegNumber()))) {
            return false;
        }
        cars[size] = car;
        size++;

        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())) {
                Car carToRemove = cars[i];
                cars[i] = cars[size--];
                return carToRemove;
            }

        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())) {
                return cars[i];
            }
        }
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

    @Override
    public void printCars() {
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }

    }

    public int getSize() {
        return size;
    }

    private Car[] findCarsByPredicate(Predicate<Car> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(cars[i])) {
                count++;
            }
        }
        Car[] cars = new Car[count];
        for (int i = 0, j = 0; j < cars.length; i++) {
            if (predicate.test(cars[i])) {
                cars[j++] = cars[i];
            }
        }
        return cars;
    }
}
