package com.kurochkin.illya.company.repository;

import com.kurochkin.illya.company.entiry.Car;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayCarRepository implements CarRepository {

    private final Car[] cars;

    public ArrayCarRepository(Car...cars) {
        this.cars = Arrays.copyOf(cars, cars.length);
    }

    public <T extends Car> ArrayCarRepository(Collection<T> cars) {
        this(cars.toArray(new Car[]{}));
    }

    @Override
    public Car findCarById(long id) {
        return Arrays.stream(cars)
                .filter(car -> car.getId() == id)
                .findAny().orElse(null);
    }

    @Override
    public Set<Car> findCarsByBrand(String brand) {
        return Arrays.stream(cars)
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Car> findCarsByModel(String model) {
        return Arrays.stream(cars)
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Car> findCarsByYear(int year) {
        return Arrays.stream(cars)
                .filter(car -> car.getYear().equals(year))
                .collect(Collectors.toSet());
    }
}
