package com.presents.repository;

import com.presents.sweets.Sweet;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SweetRepositoryHashSetImpl implements SweetRepository {

    private final Set<Sweet> set = new HashSet<>();

    public SweetRepositoryHashSetImpl() {
    }

    public SweetRepositoryHashSetImpl(Set<Sweet> sweets) {
        set.addAll(sweets);
    }

    @Override
    public Set<Sweet> selectAll() {
        return new HashSet<>(set);
    }

    @Override
    public Set<Sweet> select(Set<Integer> ids) {
        return set.stream()
                .filter(sweet -> ids.contains(sweet.getId()))
                .collect(toSet());
    }

    @Override
    public void delete(Set<Integer> ids) {
        set.removeIf(sweet -> ids.contains(sweet.getId()));
    }

    @Override
    public void insert(Set<Sweet> sweets) {
        set.addAll(sweets);
    }

    @Override
    public Set<Sweet> selectByName(String name) {
        return set.stream()
                .filter(sweet -> sweet.getName().equals(name))
                .collect(toSet());
    }

    @Override
    public Set<Sweet> selectByBrand(String brand) {
        return set.stream()
                .filter(sweet -> sweet.getBrand().equals(brand))
                .collect(toSet());
    }
}
