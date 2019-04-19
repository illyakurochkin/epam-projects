package com.presents.ui;

import com.presents.repository.SweetRepository;
import com.presents.service.SweetPackService;
import com.presents.service.SweetService;
import com.presents.sweets.Candy;
import com.presents.sweets.SweetPack;

import java.time.LocalDate;
import java.util.Scanner;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

public class ConsoleApplication {

    private final SweetService sweetService;
    private final SweetPackService sweetPackService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApplication(SweetService sweetService, SweetPackService sweetPackService) {
        this.sweetService = sweetService;
        this.sweetPackService = sweetPackService;
        scanner.useDelimiter("\n");
    }

    public void run() {
        printAllSweets();
        addCandy();
        printAllSweets();
        printAllSweetPacks();
        addSweetPack();
        printAllSweetPacks();
    }

    private void addSweetPack() {
        SweetPack pack = new SweetPack(10, "sweet pack");
        sweetService.selectByBrand("Brand1")
                .forEach(pack::add);
        System.out.println(pack);
        System.out.println("sweets with sugar between 5 and 10");
        pack.findBySugarWeight(5, 10).forEach(System.out::println);
        sweetPackService.insert(of(pack).collect(toSet()));
    }

    private void addCandy() {
        System.out.println("insert new candy");
        Candy candy = Candy.builder()
                .withId(10)
                .withName("new candy")
                .withBrand("old brand")
                .withWeight(100)
                .withSugarWeight(15)
                .withDateOfManufacture(LocalDate.of(2018, 1, 1))
                .withExpirationDays(100)
                .build();
        sweetService.insert(candy);
    }

    private void printAllSweets() {
        System.out.println("print all sweets");
        sweetService.selectAll().forEach(System.out::println);
    }

    private void printAllSweetPacks() {
        System.out.println("print all sweet packs");
        sweetPackService.selectAll().forEach(System.out::println);
    }
}
