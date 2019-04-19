package com.presents.service;

import com.presents.sweets.Sweet;

import java.util.Set;

public interface SweetService {

    Set<Sweet> selectAll();

    Set<Sweet> select(Set<Integer> ids);

    void delete(Set<Integer> ids);

    void insert(Set<Sweet> sweets);

    Set<Sweet> selectByName(String name);

    Set<Sweet> selectByBrand(String brand);

    Sweet select(int id);

    void delete(int id);

    void insert(Sweet sweet);
}
