package com.example.hellojava8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 1);

        List<Integer> result = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(result);

        result = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        result = list.stream().distinct().skip(3).collect(Collectors.toList());
        System.out.println(result);
    }
}
