package com.kurochkin.illya.company.entiry;

import java.util.Objects;

public class Car {

    private final long id;
    private final String brand;
    private final String model;
    private final Integer year;
    private int price;
    private final String color;
    private final String registrationNumber;

    public Car(long id, String brand, String model, Integer year, int price, String color, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                getPrice() == car.getPrice() &&
                getBrand().equals(car.getBrand()) &&
                getModel().equals(car.getModel()) &&
                getYear().equals(car.getYear()) &&
                getColor().equals(car.getColor()) &&
                getRegistrationNumber().equals(car.getRegistrationNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getYear(), getPrice(), getColor(), getRegistrationNumber());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + brand + '\'' +
                ", entiry='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
