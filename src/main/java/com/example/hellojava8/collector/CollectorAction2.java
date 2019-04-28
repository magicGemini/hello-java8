package com.example.hellojava8.collector;

import com.example.hellojava8.stream.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.example.hellojava8.collector.CollectorAction.menu;

public class CollectorAction2 {

    public static void main(String[] args) {
        //10
        testGroupingByConcurrent();
        //11
        testGroupingByConcurrentByFunctionAndCollector();
        //12
        testGroupingByConcurrentByFunctionAndSupplierAndCollector();
        //13
        testJoin();
        //14
        testJoinWithDelimeter();
        //15
        testJoinWithDelimeterAndPrefixAndSuffix();
        //16
        testMapping();
        //17
        testMaxBy();
        //18
        testMinBy();
    }

    private static void testGroupingByConcurrent() {
        ConcurrentMap<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentByFunctionAndCollector() {
        ConcurrentMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByConcurrentByFunctionAndSupplierAndCollector() {
        ConcurrentSkipListMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(
                Dish::getType,
                ConcurrentSkipListMap::new,
                Collectors.averagingInt(Dish::getCalories)
        ));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testJoin() {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testJoinWithDelimeter() {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testJoinWithDelimeterAndPrefixAndSuffix() {
        String collect = menu.stream().map(Dish::getName).collect(Collectors.joining(",", "[", "]"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testMapping() {
        String collect = menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testMaxBy() {
        Optional<Dish> collect = menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }

    private static void testMinBy() {
        Optional<Dish> collect = menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        collect.ifPresent(System.out::println);
    }


}
