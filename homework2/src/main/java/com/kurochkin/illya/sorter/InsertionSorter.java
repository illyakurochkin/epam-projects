package com.kurochkin.illya.sorter;

import java.util.Comparator;

public class InsertionSorter implements SortStrategy {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(comparator.compare(array[j], array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "insertion sort";
    }
}
