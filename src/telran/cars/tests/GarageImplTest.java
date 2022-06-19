package telran.cars.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.cars.dao.GarageImpl;
import telran.cars.interfaces.Garage;
import telran.cars.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    Garage garage;
    Car[] speedMotors;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(6);
        speedMotors = new Car[5];
        speedMotors[0] = new Car("12345A", "2022 Mustang", "Ford", "Red", 2.3);
        speedMotors[1] = new Car("12345B", "2022 Camaro", "Chevrolet", "Silver", 6.2);
        speedMotors[2] = new Car("12345C", "Ibiza", "Seat", "Red", 1.2);
        speedMotors[3] = new Car("12345D", "Jazz", "Honda", "Silver", 1.0);
        speedMotors[4] = new Car("12345E", "Charger", "Dodge", "Black", 5.0);
        for (int i = 0; i < speedMotors.length; i++) {
            garage.addCar(speedMotors[i]);

        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(speedMotors[2]));
        Car car = new Car("12345F", "Impala", "Chevrolet", "Black", 5.8);
        assertTrue(garage.addCar(car));
        assertEquals(6, garage.getSize());
        car = new Car("12345ddF", "Impala", "Chevrolet", "Black", 5.8);
        assertFalse(garage.addCar(car));

    }

    @Test
    void removeCar() {
        assertNull(garage.removeCar("000000"));
        garage.removeCar("12345E");
        assertEquals(4, garage.getSize());
        garage.printCars();

    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("12345A");
        assertEquals(speedMotors[0], car);
        assertNull(garage.findCarByRegNumber("1111"));
    }

    @Test
    void findCarsByModel() {
        Car[] expected = {speedMotors[2]};
        assertArrayEquals(expected, garage.findCarsByModel("Ibiza"));

    }

    @Test
    void findCarsByCompany() {
        Car[] expected = {speedMotors[1]};
        assertArrayEquals(expected, garage.findCarsByCompany("Chevrolet"));

    }

    @Test
    void findCarsByEngine() {
        Car[] expected = {speedMotors[0], speedMotors[4]};
        assertArrayEquals(expected, garage.findCarsByEngine(2d,6d));
    }

    @Test
    void findCarsByColor() {
        Car[] expected = {speedMotors[0], speedMotors[2]};
        assertArrayEquals(expected, garage.findCarsByColor("Red"));


    }

    @Test
    void displayCars(){
        garage.printCars();
    }
}