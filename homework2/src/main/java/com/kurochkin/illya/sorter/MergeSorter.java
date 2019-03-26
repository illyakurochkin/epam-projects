package com.kurochkin.illya.sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSorter implements SortStrategy {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        List<T> tempList = Stream.generate(() -> (T) null)
                .limit(array.length)
                .collect(Collectors.toCollection(ArrayList::new));
        doMergeSort(array, tempList, comparator, 0, array.length - 1);
    }

    private <T> void doMergeSort(T[] array, List<T> tempList, Comparator<T> comparator, int lowerIndex,
                                 int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(array, tempList, comparator, lowerIndex, middle);
            doMergeSort(array, tempList, comparator, middle + 1, higherIndex);
            mergeParts(array, tempList, comparator, lowerIndex, middle, higherIndex);
        }
    }

    private <T> void mergeParts(T[] array, List<T> tempList, Comparator<T> comparator, int lowerIndex, int middle,
                                int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempList.set(i, array[i]);
        }

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if(comparator.compare(tempList.get(i), tempList.get(j)) <= 0) {
                array[k] = tempList.get(i);
                i++;
            } else {
                array[k] = tempList.get(j);
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempList.get(i);
            k++;
            i++;
        }
    }

    @Override
    public String toString() {
        return "merge sort";
    }
}
