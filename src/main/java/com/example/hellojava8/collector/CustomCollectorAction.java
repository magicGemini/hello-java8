package com.example.hellojava8.collector;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

public class CustomCollectorAction {

    public static void main(String[] args) {
        Collector<String, List<String>, List<String>> collector = new ToListCollector<>();

        List<String> arrs = Arrays.asList(
                "a", "bb", "ccc",
                "hello", "world", "Collector",
                "hello", "world", "Collector",
                "hello", "world", "Collector",
                "hello", "world", "Collector",
                "a", "bb", "ccc",
                "a", "bb", "ccc",
                "a", "bb", "ccc",
                "a", "bb", "ccc",
                "a", "bb", "ccc",
                "a", "bb", "ccc",
                "a", "bb", "ccc"
        );

//        List<String> collect = arrs.stream().filter(s -> s.length() > 3).collect(collector);
//        Optional.ofNullable(collect).ifPresent(System.out::println);

        List<String> collect = arrs.parallelStream().filter(s -> s.length() > 3).collect(collector);
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }
}
