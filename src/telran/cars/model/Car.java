package telran.cars.model;

import java.util.Objects;

public class Car {
    private String regNumber;
    private String model;
    private String company;
    private String color;
    private double engine;

    public Car(String regNumber, String model, String company, String color, double engine) {
        this.regNumber = regNumber;
        this.model = model;
        this.company = company;
        this.color = color;
        this.engine = engine;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public String getColor() {
        return color;
    }

    public double getEngine() {
        return engine;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }
}
