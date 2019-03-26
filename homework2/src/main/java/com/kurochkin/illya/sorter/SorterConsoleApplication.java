package com.kurochkin.illya.sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SorterConsoleApplication {

    public static void main(String[] args) {

        SortStrategy[] sortStrategies = {
                new BubbleSorter(),
                new InsertionSorter(),
                new MergeSorter(),
                new HeapSorter(),
                new QuickSort()
        };

        for(SortStrategy sortStrategy: sortStrategies) {
            testSortStrategy(sortStrategy);
        }

    }

    private static final int ARRAY_LENGTH = 10_000; //1_000_000;

    private static void testSortStrategy(SortStrategy sortStrategy) {

        long startTime = System.currentTimeMillis();

        Integer[] array = createTestArray(ARRAY_LENGTH);
        sortStrategy.sort(array);

        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("%-17s%dms.\n", sortStrategy.toString() + ":", duration);

        Integer[] littleArray = createTestArray(5);

        System.out.print(Arrays.stream(littleArray)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));

        System.out.print(" => ");
        sortStrategy.sort(littleArray);

        System.out.println(Arrays.stream(littleArray)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));

        System.out.println();

    }

    private static final Random random = new Random();
    private static Integer[] createTestArray(int length) {
        return Stream.generate(() -> random.nextInt(1000) + 1) //.generate(random::nextInt)
                .limit(length)
                .toArray(Integer[]::new);
    }
}
