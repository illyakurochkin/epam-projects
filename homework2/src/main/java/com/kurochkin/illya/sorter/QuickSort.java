package com.kurochkin.illya.sorter;

import java.util.Comparator;

public class QuickSort implements SortStrategy {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        doQuickSort(array, comparator, 0, array.length - 1);
    }

    private <T> void doQuickSort(T[] array, Comparator<T> comparator, int start, int end) {

        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int current = i - (i - j) / 2;

        while (i < j) {
            while (i < current && (comparator.compare(array[i], array[current]) <= 0)) {
                i++;
            }
            while (j > current && (comparator.compare(array[current], array[j]) <= 0)) {
                j--;
            }
            if (i < j) {

                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                if (i == current) {
                    current = j;
                } else if (j == current) {
                    current = i;
                }
            }
        }
        doQuickSort(array, comparator, start, current);
        doQuickSort(array, comparator, current + 1, end);
    }

    @Override
    public String toString() {
        return "quick sort";
    }
}
