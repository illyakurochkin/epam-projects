package com.kurochkin.illya.company.service;

import com.kurochkin.illya.company.entiry.Car;

import java.util.Set;

public interface CarService {

    Set<Car> findCarsByBrand(String brand);
    Set<Car> findCarsByModelAndYearsInUse(String model, int yearsInUse);
    Set<Car> findCarsByYearAndPrice(int year, int priceMoreThan);

}
