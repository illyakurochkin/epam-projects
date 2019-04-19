package com.presents.sweets;

import java.time.LocalDate;

public class Cookie extends Sweet {

    /*public Cookie(int id, String name, String brand, int weight, int sugarWeight,
                LocalDate dateOfManufacture, int expirationDays) {
        super(id, name, brand, weight, sugarWeight, dateOfManufacture, expirationDays);
    }*/

    protected Cookie(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Sweet.Builder<Builder> {

        protected Builder() {

        }

        @Override
        public Cookie build() {
            return new Cookie(this);
        }
    }
}
