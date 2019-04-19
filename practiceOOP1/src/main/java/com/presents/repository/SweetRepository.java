package com.presents.repository;

import com.presents.sweets.Sweet;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

public interface SweetRepository {

    Set<Sweet> selectAll();

    Set<Sweet> select(Set<Integer> ids);

    void delete(Set<Integer> ids);

    void insert(Set<Sweet> sweets);

    Set<Sweet> selectByName(String name);

    Set<Sweet> selectByBrand(String brand);

    default Sweet select(int id) {
        Set<Integer> set = of(id).collect(toSet());
        return select(set)
                .stream()
                .findAny()
                .orElse(null);
    }

    default void delete(int id) {
        delete(of(id).collect(toSet()));
    }

    default void insert(Sweet sweet) {
        insert(of(sweet).collect(toSet()));
    }
}
