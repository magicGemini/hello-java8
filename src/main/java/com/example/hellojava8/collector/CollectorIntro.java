package com.example.hellojava8.collector;

import com.example.hellojava8.lambda.Apple;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorIntro {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170),
                new Apple("green", 150),
                new Apple("yellow", 120),
                new Apple("green", 170));

        List<Apple> greenList = appleList.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);

        Optional.ofNullable(groupByNormal(appleList)).ifPresent(System.out::println);

        Optional.ofNullable(groupByFunction(appleList)).ifPresent(System.out::println);

        Optional.ofNullable(groupByCollector(appleList)).ifPresent(System.out::println);

    }

    private static Map<String, List<Apple>> groupByNormal(List<Apple> appleList) {
        Map<String, List<Apple>> ret = new HashMap<>();
        for (Apple apple : appleList) {
            List<Apple> list = ret.get(apple.getColor());
            if (list == null) {
                list = new ArrayList<>();
                ret.put(apple.getColor(), list);
            }
            list.add(apple);
        }
        return ret;
    }

    private static Map<String, List<Apple>> groupByFunction(List<Apple> appleList) {
        Map<String, List<Apple>> ret = new HashMap<>();

        appleList.stream().forEach((apple) -> {
            List<Apple> colorList = Optional.ofNullable(ret.get(apple.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                ret.put(apple.getColor(), list);
                return list;
            });
            colorList.add(apple);
        });
        return ret;
    }

    private static Map<String, List<Apple>> groupByCollector(List<Apple> appleList) {
        return appleList.stream().collect(Collectors.groupingBy(Apple::getColor));
    }


}
