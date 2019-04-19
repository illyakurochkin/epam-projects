package com.presents.repository;

import com.presents.sweets.Cake;
import com.presents.sweets.Candy;
import com.presents.sweets.Muffin;
import com.presents.sweets.Sweet;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static org.junit.Assert.assertEquals;

public class SweetRepositoryMysqlImplTest {

    private static final Sweet SWEET_1 = Candy.builder()
            .withId(1)
            .withName("N1")
            .withBrand("B1")
            .withWeight(0)
            .withSugarWeight(0)
            .withDateOfManufacture(LocalDate.of(2019, 1, 1))
            .withExpirationDays(1)
            .build();

    private static final Sweet SWEET_2 = Cake.builder()
            .withId(2)
            .withName("N2")
            .withBrand("B1")
            .withWeight(0)
            .withSugarWeight(0)
            .withDateOfManufacture(LocalDate.of(2019, 1, 1))
            .withExpirationDays(1)
            .build();

    private static final Sweet SWEET_3 = Muffin.builder()
            .withId(3)
            .withName("N3")
            .withBrand("B2")
            .withWeight(0)
            .withSugarWeight(0)
            .withDateOfManufacture(LocalDate.of(2019, 1, 1))
            .withExpirationDays(1)
            .build();

    @Test
    public void shouldInitWithoutExceptions() {
        SweetRepository sweetRepository = new SweetRepositoryMysqlImpl();
    }

    @Test
    public void shouldBeEmptyAfterInit() {
        SweetRepository sweetRepository = new SweetRepositoryMysqlImpl();

        Set<Sweet> actual = sweetRepository.selectAll();
        Set<Sweet> expected = new HashSet<>();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertSingleValue() {
        SweetRepository sweetRepository = new SweetRepositoryMysqlImpl();
        sweetRepository.insert(SWEET_1);

        Set<Sweet> actual = sweetRepository.selectAll();
        Set<Sweet> expected = of(SWEET_1).collect(toSet());

        assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertSetOfValues() {
//        SweetRepository sweetRepository = new Sw
    }
}