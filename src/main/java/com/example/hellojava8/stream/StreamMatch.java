package com.example.hellojava8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        Boolean matched = stream.allMatch(i -> i > 0);
        System.out.println("allMatch: " + matched);
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        matched = stream.anyMatch(i -> i > 3);
        System.out.println("anyMatch: " + matched);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        matched = stream.noneMatch(i -> i < 0);
        System.out.println("noneMatch: " + matched);

    }
}
