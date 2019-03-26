package com.kurochkin.illya.company;

import com.kurochkin.illya.company.entiry.Car;
import com.kurochkin.illya.company.repository.ArrayCarRepository;
import com.kurochkin.illya.company.repository.CarRepository;
import com.kurochkin.illya.company.service.CarService;
import com.kurochkin.illya.company.service.CarServiceImpl;
import com.kurochkin.illya.company.ui.ConsoleUI;

public class ConsoleApplication {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1L, "BMW", "X5", 2015, 15000, "red", "AA5566BB"),
                new Car(2L, "BMW", "X3", 2010, 10000, "red", "AA5366BB"),
                new Car(3L, "BMW", "X3", 2012, 12000, "black", "AA9922BB"),
                new Car(4L, "Ford", "Mustang", 2015, 25000, "red", "AA1166BB"),
                new Car(5L, "Ford", "Focus", 2012, 12000, "red", "AA5300BB"),
                new Car(6L, "Ford", "Focus", 2010, 10000, "white", "AC5100BB"),
                new Car(7L, "Mazda", "3", 2018, 30000, "red", "AA7788BB"),
                new Car(8L, "Mazda", "CX 5", 2008, 13000, "red", "AA1166BB"),
                new Car(9L, "Honda", "Civic", 2015, 15000, "red", "AA4146BB"),
                new Car(10L, "Honda", "Civic", 2016, 15600, "black", "AA0166BB")
        };

        CarRepository carRepository = new ArrayCarRepository(cars);
        CarService carService = new CarServiceImpl(carRepository);
        Runnable application = new ConsoleUI(carService);

       application.run();


    }
}
