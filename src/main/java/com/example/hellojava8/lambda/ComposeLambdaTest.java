package com.example.hellojava8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComposeLambdaTest {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("red", 170),
                new Apple("green", 200),
                new Apple("green", 120),
                new Apple("red", 130),
                new Apple("yellow", 210));


        // 比较器的复合 Comparator.comparing()
        list.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(list);

        // 谓词复合
        Predicate<Apple> redApple = (a) -> a.getColor().equals("red");
        Predicate<Apple> greenApple = apple -> apple.getColor().equals("green");
        Predicate<Apple> bigApple = apple -> apple.getWeight() > 150;
        List<Apple> result = list.stream().filter(redApple.or(greenApple).and(bigApple)).collect(Collectors.toList());
        Optional.ofNullable(result).ifPresent(System.out::println);

        // 函数复合  andThen = g(f(x)), compose = f(g(x))
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Integer[] number = new Integer[]{1, 2, 3};
        Optional.of(
                Stream.of(number)
                        .map(x -> f.andThen(g).apply(x))
                        .collect(Collectors.toList())
        ).ifPresent(System.out::println);

        Optional.of(
                Stream.of(number)
                        .map(x -> f.compose(g).apply(x))
                        .collect(Collectors.toList())
        ).ifPresent(System.out::println);

    }
}
