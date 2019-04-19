package com.presents.sweets;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class SweetPack {

    private final int id;
    private final String name;
    private final Set<Sweet> sweets;

    public SweetPack(int id, String name, Set<Sweet> sweets) {
        this.id = id;
        this.name = name;
        this.sweets = new HashSet<>(sweets);
    }

    public SweetPack(int id, String name) {
        this(id, name, new HashSet<>());
    }

    public void add(Sweet sweet) {
        sweets.add(sweet);
    }

    public boolean remove(Sweet sweet) {
        return sweets.remove(sweet);
    }

    public int count() {
        return sweets.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Sweet> getSweets() {
        return new HashSet<>(sweets);
    }

    public int countWeight() {
        return sweets.stream()
                .mapToInt(Sweet::getWeight)
                .sum();
    }

    public int countSugarWeight() {
        return sweets.stream()
                .mapToInt(Sweet::getSugarWeight)
                .sum();
    }

    public Set<Sweet> findBySugarWeight(int minWeight, int maxWeight) {
        return sweets.stream()
                .filter(sweet -> sweet.getSugarWeight() >= minWeight && sweet.getSugarWeight() <= maxWeight)
                .collect(toSet());
    }

    @Override
    public String toString() {
        return "SweetPack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sweets=" + sweets +
                '}';
    }
}
