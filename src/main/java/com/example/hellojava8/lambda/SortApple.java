package com.example.hellojava8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortApple {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150),
                new Apple("red", 170),
                new Apple("green", 200),
                new Apple("yellow", 180));

        System.out.println(list);

        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Collections.sort(list, byColor);
        System.out.println(list);

        Collections.sort(list, ((o1, o2) -> (int) (o1.getWeight() - o2.getWeight())));
        System.out.println(list);

    }
}
