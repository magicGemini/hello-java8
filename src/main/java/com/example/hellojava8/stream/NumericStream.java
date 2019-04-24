package com.example.hellojava8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStream {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Integer sum = stream.filter(integer -> integer.intValue() > 3).reduce(0, Integer::sum);
        System.out.println(sum);

        //
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        IntStream integerStream = stream.filter(i -> i.intValue() > 3).mapToInt(i -> i.intValue());
        sum = integerStream.sum();
        System.out.println(sum);
    }
}
