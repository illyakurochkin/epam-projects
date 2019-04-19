package com.presents.helpers;

import com.presents.repository.SweetPackRepository;
import com.presents.repository.SweetRepository;
import com.presents.sweets.*;

import java.time.LocalDate;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

public class RepositoryFiller {

    private final SweetRepository sweetRepository;
    private final SweetPackRepository sweetPackRepository;

    public RepositoryFiller(SweetRepository sweetRepository, SweetPackRepository sweetPackRepository) {
        this.sweetRepository = sweetRepository;
        this.sweetPackRepository = sweetPackRepository;
    }

    public void fill() {
        Cake cake1 = Cake.builder().withId(1).withName("Cake1").withBrand("Brand1")
                .withWeight(100).withSugarWeight(10)
                .withDateOfManufacture(LocalDate.of(2019, 10, 10))
                .withExpirationDays(10).build();

        Cake cake2 = Cake.builder().withId(2).withName("Cake2").withBrand("Brand2")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Muffin muffin1 = Muffin.builder().withId(3).withName("Muffin1").withBrand("Brand1")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Muffin muffin2 = Muffin.builder().withId(4).withName("Muffin2").withBrand("Brand2")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Cookie cookie1 = Cookie.builder().withId(5).withName("Cookie1").withBrand("Brand1")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Cookie cookie2 = Cookie.builder().withId(6).withName("Cookie2").withBrand("Brand2")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Candy candy1 = Candy.builder().withId(7).withName("Candy1").withBrand("Brand1")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Candy candy2 = Candy.builder().withId(8).withName("Candy2").withBrand("Brand2")
                .withWeight(50).withSugarWeight(5)
                .withDateOfManufacture(LocalDate.of(2019, 9, 9))
                .withExpirationDays(14).build();

        Set<Sweet> sweets = of(cake1, cake2, candy1, candy2, cookie1, cookie2, muffin1, muffin2)
                .collect(toSet());

        sweetRepository.insert(sweets);

        SweetPack sweetPack1 = new SweetPack(1, "Pack1",
                of(cake1, cookie2, muffin1).collect(toSet()));

        SweetPack sweetPack2 = new SweetPack(2, "Pack2",
                of(cake2, muffin2, candy1, candy2).collect(toSet()));

        SweetPack sweetPack3 = new SweetPack(3, "Pack3",
                of(cookie1).collect(toSet()));

        Set<SweetPack> sweetPacks = of(sweetPack1, sweetPack2, sweetPack3).collect(toSet());

        sweetPackRepository.insert(sweetPacks);
    }
}
