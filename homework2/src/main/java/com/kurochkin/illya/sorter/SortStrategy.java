package com.kurochkin.illya.sorter;

import java.util.Comparator;

public interface SortStrategy {
    <T> void sort(T[] array, Comparator<T> comparator);

    default <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo);
    }
}
