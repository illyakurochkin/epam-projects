package com.kurochkin.illya.company.service;

import com.kurochkin.illya.company.entiry.Car;
import com.kurochkin.illya.company.repository.CarRepository;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Set<Car> findCarsByBrand(String brand) {
        return carRepository.findCarsByBrand(brand);
    }

    @Override
    public Set<Car> findCarsByModelAndYearsInUse(String model, int yearsInUse) {
        int currentYear = LocalDate.now().getYear();
        return carRepository.findCarsByModel(model).stream()
                .filter(car -> currentYear - car.getYear() >= yearsInUse)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Car> findCarsByYearAndPrice(int year, int priceMoreThan) {

        return carRepository.findCarsByYear(year).stream()
                .filter(car -> car.getPrice() >= priceMoreThan)
                .collect(Collectors.toSet());
    }
}
