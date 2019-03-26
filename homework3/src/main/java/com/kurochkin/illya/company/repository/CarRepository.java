package com.kurochkin.illya.company.repository;

import com.kurochkin.illya.company.entiry.Car;

import java.util.Set;

public interface CarRepository {

    Car findCarById(long id);
    Set<Car> findCarsByBrand(String brand);
    Set<Car> findCarsByModel(String model);
    Set<Car> findCarsByYear(int year);

}
