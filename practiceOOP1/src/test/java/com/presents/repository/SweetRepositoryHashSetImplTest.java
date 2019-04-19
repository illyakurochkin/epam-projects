package com.presents.repository;

import com.presents.sweets.Cake;
import com.presents.sweets.Candy;
import com.presents.sweets.Muffin;
import com.presents.sweets.Sweet;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;
import static org.junit.Assert.assertEquals;

public class SweetRepositoryHashSetImplTest {

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
    public void shouldCreateEmptyRepository() {
        SweetRepository sweetRepository = new SweetRepositoryHashSetImpl();
        int expectedSize = 0;
        int actualSize = sweetRepository.selectAll().size();
        assertEquals("set is empty", expectedSize, actualSize);
    }

    @Test
    public void shouldInitCorrectly() {
        SweetRepository sweetRepository =
                new SweetRepositoryHashSetImpl(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        Set<Sweet> expected = of(SWEET_1, SWEET_2, SWEET_3).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectAll();

        assertEquals("init sweets are same", expected, actual);
    }

    @Test
    public void shouldInsertSingleValue() {
        SweetRepository sweetRepository = new SweetRepositoryHashSetImpl();
        sweetRepository.insert(SWEET_1);

        Set<Sweet> expected = of(SWEET_1).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectAll();

        assertEquals("single value is inserted", expected, actual);
    }

    @Test
    public void shouldInsertSetOfValues() {
        SweetRepository sweetRepository = new SweetRepositoryHashSetImpl();
        sweetRepository.insert(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        Set<Sweet> expected = of(SWEET_1, SWEET_2, SWEET_3).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectAll();

        assertEquals("set of values was inserted", expected, actual);
    }

    @Test
    public void shouldDeleteSingleId() {
        SweetRepository sweetRepository =
                new SweetRepositoryHashSetImpl(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        sweetRepository.delete(1);

        Set<Sweet> expected = of(SWEET_2, SWEET_3).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectAll();

        assertEquals("id 1 was deleted", expected, actual);
    }

    @Test
    public void shouldDeleteSetOfIds() {
        SweetRepository sweetRepository =
                new SweetRepositoryHashSetImpl(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        sweetRepository.delete(of(1, 3).collect(toSet()));

        Set<Sweet> expected = of(SWEET_2).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectAll();

        assertEquals("set of ids was deleted", expected, actual);
    }

    @Test
    public void shouldSelectByName() {
        SweetRepository sweetRepository =
                new SweetRepositoryHashSetImpl(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        Set<Sweet> expected = of(SWEET_2).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectByName("N2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSelectByBrand() {
        SweetRepository sweetRepository =
                new SweetRepositoryHashSetImpl(of(SWEET_1, SWEET_2, SWEET_3).collect(toSet()));

        Set<Sweet> expected = of(SWEET_1, SWEET_2).collect(toSet());
        Set<Sweet> actual = sweetRepository.selectByBrand("B1");

        assertEquals(expected, actual);
    }
}