package com.presents.helpers;

import com.presents.sweets.Sweet;

import java.util.Comparator;

import static java.util.Comparator.*;

public final class SweetComparators {

    public static final Comparator<Sweet> BY_WEIGHT_COMPARATOR = comparing(Sweet::getWeight)
            .thenComparing(Sweet::getName)
            .thenComparing(Sweet::getBrand)
            .thenComparing(Sweet::getSugarWeight)
            .thenComparing(Sweet::getDateOfManufacture)
            .thenComparing(Sweet::getExpirationDays)
            .thenComparing(Sweet::getId);

    public static final Comparator<Sweet> BY_SUGAR_WEIGHT_COMPARATOR = comparing(Sweet::getSugarWeight)
            .thenComparing(Sweet::getName)
            .thenComparing(Sweet::getBrand)
            .thenComparing(Sweet::getWeight)
            .thenComparing(comparing(Sweet::getDateOfManufacture).reversed())
            .thenComparing(Sweet::getExpirationDays)
            .thenComparing(Sweet::getId);

    public static final Comparator<Sweet> DEFAULT_COMPARATOR = Sweet::compareTo;
}
