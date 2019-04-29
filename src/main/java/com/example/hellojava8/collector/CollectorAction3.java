package com.example.hellojava8.collector;

import com.example.hellojava8.stream.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static com.example.hellojava8.collector.CollectorAction.menu;

public class CollectorAction3 {

    public static void main(String[] args) {
        //19
        testPartitionByWithPredicate();
        //20
        testPartitionByWithPredicateAndCollector();
        //21
        testReducingBinaryOperator();
        //22
        testReducingBinaryOperatorAndIdentity();
        //23
        testReducingBinaryOperatorAndIdentityAndFunction();
        //9
        testSummarizingDouble();
        //24
        testSummarizingInt();
        //25
        testSummarizingLong();
    }

    private static void testPartitionByWithPredicate() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian)
        );
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testPartitionByWithPredicateAndCollector() {
        Map<Boolean, Long> collect = menu.stream().collect(
                Collectors.partitioningBy(Dish::isVegetarian, Collectors.counting())
        );
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperator() {
        Optional<Dish> collect = menu.stream().collect(
                Collectors.reducing(
                        BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories))
                )
        );
        collect.ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentity() {
        Integer collect = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (d1, d2) -> d1 + d2));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testReducingBinaryOperatorAndIdentityAndFunction() {
        Integer collect = menu.stream().collect(
                Collectors.reducing(0, Dish::getCalories, (d1, d2) -> d1 + d2)
        );
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizingDouble() {
        DoubleSummaryStatistics collect = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizingInt() {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizingLong() {
        LongSummaryStatistics collect = menu.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

}
