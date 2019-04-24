package com.example.hellojava8.stream;

import com.example.hellojava8.stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7, 1);

        List<Integer> result = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(result);

        List<String> dishNames = dishList().stream().map(dish -> dish.getName()).collect(Collectors.toList());
        System.out.println(dishNames);

        // 扁平化
        String[] words = {"Hello", "World"};
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        List<String> chars = stringStream.collect(Collectors.toList());
        System.out.println(chars);

    }

    private static List<Dish> dishList() {
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
        return menu;
    }
}
