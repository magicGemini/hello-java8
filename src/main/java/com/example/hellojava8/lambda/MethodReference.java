package com.example.hellojava8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * example - 6
 */
public class MethodReference {

    public static void main(String[] args) {
        printTwice("Hello", System.out::println);

        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("red", 170),
                new Apple("green", 200), new Apple("yellow", 180));

        System.out.println(list);

        //1. 匿名内部类
        Collections.sort(list, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        //2. lambda
        list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
        //3. lambda + method reference
        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);

        // method reference
        Function<String, Integer> f1 = Integer::parseInt;
        System.out.println(f1.apply("123"));

        BiFunction<String, Integer, Character> f2 = String::charAt;
        System.out.println(f2.apply("Hello", 3));

        Function<Integer, Character> f3 = "hello"::charAt;
        System.out.println(f3.apply(4));

        BiFunction<String, Long, Apple> f4 = Apple::new;
        System.out.println(f4.apply("pink", 130l));

        ThreeFunction<String, Long, String, Apple> f5 = Apple::new;
        System.out.println(f5.apply("red", 220l, "fushi"));

        System.out.println("==================================");

        List<String> ids = Arrays.asList("2014US0002", "2013UK0001", "2016JP0004", "2015CN0003");
        System.out.println(ids);
        Collections.sort(ids, Comparator.comparingInt(id -> Integer.parseInt(id.substring(0, 4))));
        System.out.println(ids);
        ids.sort((id1, id2) -> id1.substring(4, 6).compareTo(id2.substring(4, 6)));
        System.out.println(ids);
        ids.sort(Comparator.comparingInt(id -> Integer.parseInt(id.substring(6, 10))));
        System.out.println(ids);
    }

    @FunctionalInterface
    public interface ThreeFunction<C, W, N, R> {
        R apply(C c, W w, N n);
    }

    public static <T> void printTwice(T t, Consumer consumer) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
