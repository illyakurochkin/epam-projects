package com.kurochkin.illya.sorter;

import java.util.Comparator;

public class BubbleSorter implements SortStrategy {

    @Override
    public final <T> void sort(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[i], array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "bubble sort";
    }

}
