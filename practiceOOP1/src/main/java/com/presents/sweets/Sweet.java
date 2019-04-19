package com.presents.sweets;

import java.time.LocalDate;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public /*abstract*/ class Sweet implements Comparable<Sweet> {

    private final int id;
    private final String name;
    private final String brand;
    private final int weight;
    private final int sugarWeight;
    private final LocalDate dateOfManufacture;
    private final int expirationDays;

    protected Sweet(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.brand = builder.brand;
        this.weight = builder.weight;
        this.sugarWeight = builder.sugarWeight;
        this.dateOfManufacture = builder.dateOfManufacture;
        this.expirationDays = builder.expirationDays;
    }

    public static Builder builder() {
        return new Builder();
    }

    /*protected Sweet(int id, String name, String brand, int weight, int sugarWeight,
                 LocalDate dateOfManufacture, int expirationDays) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDays = expirationDays;
    }*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getWeight() {
        return weight;
    }

    public int getSugarWeight() {
        return sugarWeight;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Sweet && ((Sweet) o).id == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Sweet another) {
        return comparing(Sweet::getName)
                .thenComparing(Sweet::getBrand)
                .thenComparing(Sweet::getWeight)
                .thenComparing(Sweet::getSugarWeight)
                .thenComparing(Sweet::getDateOfManufacture)
                .thenComparing(Comparator.comparing(Sweet::getExpirationDays).reversed())
                .thenComparing(Sweet::getId)
                .compare(this, another);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", sugarWeight=" + sugarWeight +
                ", dateOfManufacture=" + dateOfManufacture +
                '}';
    }

    public static class Builder<T extends Builder<T>> {
        private int id;
        private String name;
        private String brand;
        private int weight;
        private int sugarWeight;
        private LocalDate dateOfManufacture;
        private int expirationDays;

        protected Builder() {

        }

        public T withId(int id) {
            this.id = id;
            return self();
        }

        public T withName(String name) {
            this.name = name;
            return self();
        }

        public T withBrand(String brand) {
            this.brand = brand;
            return self();
        }

        public T withWeight(int weight) {
            this.weight = weight;
            return self();
        }

        public T withSugarWeight(int sugarWeight) {
            this.sugarWeight = sugarWeight;
            return self();
        }

        public T withDateOfManufacture(LocalDate dateOfManufacture) {
            this.dateOfManufacture = dateOfManufacture;
            return self();
        }

        public T withExpirationDays(int expirationDays) {
            this.expirationDays = expirationDays;
            return self();
        }

        public Sweet build() {
//            return new Sweet(id, name, brand, weight, sugarWeight, dateOfManufacture, expirationDays);
            return new Sweet(this);
        }

        protected T self() {
            return (T) this;
        }


    }
}
