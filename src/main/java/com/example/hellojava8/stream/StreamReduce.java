package com.example.hellojava8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer sum = stream.reduce(0, (i, j) -> i + j);
        System.out.println(sum);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce((i, j) -> i > j ? i : j).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Integer sum2 = stream.filter(i -> i % 2 == 0).reduce(0, Integer::sum);
        Optional.of(sum2).ifPresent(System.out::println);

    }
}
