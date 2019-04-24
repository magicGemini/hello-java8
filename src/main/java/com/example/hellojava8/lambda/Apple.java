package com.example.hellojava8.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Apple {

    private String color;
    private long weight;
    private String name;

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color, long weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

}
