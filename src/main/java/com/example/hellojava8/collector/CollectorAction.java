package com.example.hellojava8.collector;

import com.example.hellojava8.stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorAction {

    static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        //1
        tetsAveragingDouble();
        //2
        testAveragingInt();
        //3
        testAveragingLong();
        //4
        testCollectionAndThen();
        //5
        testCounting();
        //6
        testGroupingBy();
        //7
        testGroupingByFunctionAndCollector();
        //8
        testGroupingByFunctionAndSupplierAndCollector();

    }

    private static void tetsAveragingDouble() {
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testAveragingInt() {
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testAveragingLong() {
        Double collect = menu.stream().collect(Collectors.averagingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testCollectionAndThen() {
        String collect = menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories),
                (aver) -> "The average of calories is " + aver));
        Optional.ofNullable(collect).ifPresent(System.out::println);
//        List<Dish> meatList = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
//        meatList.add(new Dish("abc", true, 111, Dish.Type.OTHER));
    }

    private static void testCounting() {
        Long collect = menu.stream().collect(Collectors.counting());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingBy() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndCollector() {
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        Optional.ofNullable(collect).ifPresent(System.out::println);

        Map<Dish.Type, Double> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect1).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndSupplierAndCollector() {
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.counting()));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizing() {
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
}
