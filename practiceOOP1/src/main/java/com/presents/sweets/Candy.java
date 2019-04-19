package com.presents.sweets;

import java.time.LocalDate;

public class Candy extends Sweet {

    /*public Candy(int id, String name, String brand, int weight, int sugarWeight,
                LocalDate dateOfManufacture, int expirationDays) {
        super(id, name, brand, weight, sugarWeight, dateOfManufacture, expirationDays);
    }*/

    protected Candy(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Sweet.Builder<Builder> {

        protected Builder() {

        }

        @Override
        public Candy build() {
            return new Candy(this);
        }
    }
}
