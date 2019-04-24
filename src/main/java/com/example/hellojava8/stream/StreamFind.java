package com.example.hellojava8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

    public static void main(String[] args) {

        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional optional1 = stream.filter(i -> i % 2 == 0).findAny();      //findAny
        System.out.println(optional1.get());

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional optional2 = stream.filter(i -> i % 2 == 0).findFirst();    //findFirst
        optional2.ifPresent(System.out::println);   //ifPresent(Consumer)

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        Optional optional3 = stream.filter(i -> i < 10).findAny();
        System.out.println(optional3.orElse(-1));   //orElse

    }
}
