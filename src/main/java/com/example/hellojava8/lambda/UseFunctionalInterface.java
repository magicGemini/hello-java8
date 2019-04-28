package com.example.hellojava8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * example - 5
 * 流程和行为解耦
 * 函数式接口： Predicate、Consumer、Function、Supplier
 **/
public class UseFunctionalInterface {

    // 过滤
    public static List<Apple> filterApple(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple))
                result.add(apple);
        }
        return result;
    }

    // 消费
    private static void watchApple(List<Apple> apples, Consumer<Apple> consumer) {
        for (Apple apple : apples) {
            consumer.accept(apple);
        }
    }

    private static void printApple(List<Apple> apples, BiConsumer<String, Long> consumer) {
        for (Apple apple : apples) {
            consumer.accept(apple.getColor(), apple.getWeight());
        }
    }

    // supplier
    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }

    // function功能
    private static Apple growBig(Apple apple, Function<Apple, Apple> function) {
        return function.apply(apple);
    }

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("green", 150),
                new Apple("red", 170),
                new Apple("green", 200),
                new Apple("yellow", 180));

        // Predicate
        List<Apple> result = filterApple(list, (a) -> "green".equals(a.getColor()));
        System.out.println(result);
        result = filterApple(list, (a) -> a.getWeight() > 150 && a.getColor().equals("green"));
        System.out.println(result);

        System.out.println("====================================");
        // Consumer
        watchApple(list, apple -> System.out.println(apple));
        printApple(list, (c, w) -> System.out.println("i am a " + (w > 150 ? "big " : "small ") + c + " apple."));

        //Function
        System.out.println("====================================");
        List bigApples = new ArrayList();
        list.stream().forEach((apple) -> {
            bigApples.add(growBig(apple, (a) -> {
                a.setWeight(a.getWeight() * 10);
                return a;
            }));
        });
        System.out.println(bigApples);

        // Supplier
        System.out.println("====================================");
        Apple apple = createApple(() -> new Apple("bule", 220));
        System.out.println(apple);
    }
}
