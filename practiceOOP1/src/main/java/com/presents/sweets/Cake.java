package com.presents.sweets;

public class Cake extends Sweet {

    /*protected Cake(int id, String name, String brand, int weight, int sugarWeight,
                 LocalDate dateOfManufacture, int expirationDays) {
        super(id, name, brand, weight, sugarWeight, dateOfManufacture, expirationDays);
    }*/

    protected Cake(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Sweet.Builder<Builder> {

        protected Builder() {

        }

        @Override
        public Cake build() {
            return new Cake(this);
        }
    }

}
