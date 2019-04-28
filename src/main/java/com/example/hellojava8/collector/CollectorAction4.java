package com.example.hellojava8.collector;

import com.example.hellojava8.stream.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

import static com.example.hellojava8.collector.CollectorAction.menu;

public class CollectorAction4 {

    public static void main(String[] args) {
        //26
        testSummingDouble();
        //27
        testSummingInt();
        //28
        testSummingLong();
        //29
        testToCollection();
        //30
        testToConcurrentMap();
        //31
        testToConcurrentMapWithBinaryOperator();
        //32
        testToConcurrentMapWithBinaryOperatorAndSupplier();
        //33
        testToList();
        //34
        testToSet();
        //35
        testToMap();
        //36
        testToMapWithBinaryOperator();
        //37
        testToMapWithBinaryOperatorAndSupplier();

        testToMapThreadSafe();

    }

    private static void testSummingDouble() {
        Double collect = menu.stream().collect(Collectors.summingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummingInt() {
        Integer collect = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummingLong() {
        Long collect = menu.stream().collect(Collectors.summingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToCollection() {
        LinkedList<Dish> collect = menu.stream().filter(a -> a.getCalories() > 600).collect(Collectors.toCollection(LinkedList::new));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToConcurrentMap() {
        ConcurrentMap<String, Integer> collect = menu.stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(v -> {
            System.out.println(v.getClass());
            System.out.println(v);
        });
    }

    private static void testToConcurrentMapWithBinaryOperator() {
        ConcurrentMap<Dish.Type, Long> collect = menu.stream().collect(
                Collectors.toConcurrentMap(Dish::getType, v -> 1l, (a, b) -> a + b)
        );
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToConcurrentMapWithBinaryOperatorAndSupplier() {
        ConcurrentMap<Dish.Type, Long> collect = menu.stream().collect(
                Collectors.toConcurrentMap(
                        Dish::getType,
                        v -> 1l,
                        (a, b) -> a + b,
                        ConcurrentSkipListMap::new
                )
        );
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToList() {
        List<Dish> collect = menu.stream().filter(d -> d.isVegetarian()).collect(Collectors.toList());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToSet() {
        Set<Dish> collect = menu.stream().filter(d -> d.isVegetarian()).collect(Collectors.toSet());
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToMap() {
        Map<String, Integer> collect = menu.stream().collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToMapWithBinaryOperator() {
        Map<Dish.Type, Long> collect = menu.stream().collect(
                Collectors.toMap(Dish::getType, a -> 1l, (a, b) -> a + b)
        );
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testToMapWithBinaryOperatorAndSupplier() {
        Map<Dish.Type, Long> collect = menu.stream().collect(
                Collectors.toMap(Dish::getType, a -> 1l, (a, b) -> a + b, ConcurrentSkipListMap::new)
        );
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }


    private static void testToMapThreadSafe() {
        Map<Dish.Type, Integer> collect = menu.stream().collect(Collectors.collectingAndThen(
                Collectors.toMap(Dish::getType, a -> 1, (a, b) -> a + b), Collections::synchronizedMap)
        );
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

}
