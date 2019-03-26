package com.kurochkin.illya.sorter;

import java.util.Comparator;

public class HeapSorter implements SortStrategy{

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, comparator, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, comparator, i, 0);
        }
    }

    private <T> void heapify(T[] array, Comparator<T> comparator, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparator.compare(array[l], array[largest]) > 0) {
            largest = l;
        }

        if (r < n && comparator.compare(array[r], array[largest]) > 0) {
            largest = r;
        }

        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, comparator, n, largest);
        }
    }

    @Override
    public String toString() {
        return "heap sort";
    }
}
