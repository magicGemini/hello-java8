package com.example.hellojava8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    //1 写死
    public static List<Apple> findGreenApple(List<Apple> appleList) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor()))
                list.add(apple);
        }
        return list;
    }

    //2 传参
    public static List<Apple> filterAppleByColor(List<Apple> appleList, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : appleList) {
            if (color.equals(apple.getColor()))
                list.add(apple);
        }
        return list;
    }

    //3 策略模式
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    public static class GreenAnd150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return apple.getColor().equals("green") && apple.getWeight() > 150;
        }
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple))
                list.add(apple);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("red", 170),
                new Apple("green", 200));
        // 1
        List<Apple> greenApples = findGreenApple(list);
        assert greenApples.size() == 2;
        System.out.println(greenApples);

        // 2
        List<Apple> redApples = filterAppleByColor(list, "red");
        System.out.println(redApples);

        // 3.1
        List<Apple> result = findApple(list, new GreenAnd150WeightFilter());
        System.out.println(result);

        // 3.2
        result = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });
        System.out.println(result);

        // 3.3
        result = findApple(list, apple -> "green".equals(apple.getColor()) && apple.getWeight() < 170);
        System.out.println(result);
    }
}

