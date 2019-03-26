package com.kurochkin.illya.company.ui;

import com.kurochkin.illya.company.service.CarService;

import java.util.Scanner;

public class ConsoleUI implements Runnable {

    private final CarService carService;
    private Scanner scanner;

    public ConsoleUI(CarService carService){
        this.carService = carService;
    }

    @Override
    public void run() {
        System.out.println("Cars\n");
        try {
            scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            System.out.println("1: show cars by brand");
            System.out.println("2: show cars by entity that are more than x years in use");
            System.out.println("3: show cars by year which price is greater than x");

            System.out.print("choose command: ");

            int command =  scanner.nextInt();
            System.out.println();

            switch(command) {
                case 1:
                    showCarsByBrand();
                    break;
                case 2:
                    showCarsByModelAndYearsInUse();
                    break;
                case 3:
                    showCarsByYearAndPrice();
                    break;
                default:
                    System.out.println("unsupported command");
            }

        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }

    private void showCarsByBrand() {
        System.out.println("show cars by brand");
        System.out.print("enter brand name: ");
        String brand = scanner.next().trim();
        System.out.println();
        carService.findCarsByBrand(brand)
                .forEach(System.out::println);
    }

    private void showCarsByModelAndYearsInUse() {
        System.out.println("show cars by entity that are more than x years in use");
        System.out.print("enter entity: ");
        String model = scanner.next().trim();
        System.out.print("enter years in use: ");
        int yearsInUse = scanner.nextInt();
        System.out.println();
        carService.findCarsByModelAndYearsInUse(model, yearsInUse)
                .forEach(System.out::println);
    }

    private void showCarsByYearAndPrice() {
        System.out.println("show cars by year which price is greater than x");
        System.out.print("enter year: ");
        int year = scanner.nextInt();
        System.out.print("enter price: ");
        int price = scanner.nextInt();
        System.out.println();
        carService.findCarsByYearAndPrice(year, price)
                .forEach(System.out::println);
    }
}
