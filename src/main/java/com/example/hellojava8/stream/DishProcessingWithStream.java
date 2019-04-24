package com.example.hellojava8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class DishProcessingWithStream {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

//        List<String> dishNames = getDishNamesByCollection(menu);
//        System.out.println(dishNames);
//
//        dishNames = getDishNamesByStream(menu);
//        System.out.println(dishNames);

        List<String> result = menu.stream().filter(dish -> {
            System.out.println("filtering->" + dish.getName());
            return dish.getCalories() > 300;
        }).map(dish -> {
            System.out.println("map->" + dish.getName());
            return dish.getName();
        }).collect(Collectors.toList());
        System.out.println(result);

    }

    private static List<String> getDishNamesByStream(List<Dish> menu) {
        return menu.parallelStream().filter(dish -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return dish.getCalories() < 400;
        })
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(dish -> dish.getName()).collect(Collectors.toList());
    }


    public static List<String> getDishNamesByCollection(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.getCalories() < 400)
                lowCalories.add(dish);
        }
        Collections.sort(lowCalories, Comparator.comparingInt(Dish::getCalories));
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : lowCalories) {
            dishNames.add(dish.getName());
        }
        return dishNames;
    }
}
