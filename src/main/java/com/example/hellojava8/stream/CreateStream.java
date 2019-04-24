package com.example.hellojava8.stream;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
//        createStreamFormCollection().forEach(System.out::println);
//
//        createStreamFromValues().forEach(System.out::println);
//
//        createStreamFormArrays().forEach(System.out::println);
//
//        createStreamFromFile().forEach(System.out::println);

//        createStreamFromIterator().limit(10).forEach(System.out::println);

//        createStreamFromGenerator().forEach(System.out::println);

        createObjStreamFromGenerator().limit(10).forEach(System.out::println);
    }

    private static Stream<String> createStreamFormCollection() {
        List<String> list = Arrays.asList("hello", "alex", "abc", "world");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "alex", "abc", "world");
    }

    private static Stream<String> createStreamFormArrays() {
        return Arrays.stream(new String[]{"hello", "alex", "abc", "world"});
    }

    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("D:\\workspace_idea\\hello-java8\\src\\main\\resources\\test.txt");
        Stream lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Stream<Integer> createStreamFromIterator() {
        Stream<Integer> stream = Stream.iterate(0, n -> n + 2);
        return stream;
    }

    private static Stream<Double> createStreamFromGenerator() {
        return Stream.generate(Math::random);
    }

    private static Stream<CustomObj> createObjStreamFromGenerator() {
        return Stream.generate(new CustomObjSupplier());
    }

    static class CustomObjSupplier implements Supplier<CustomObj> {
        int index = 0;
        Random random = new Random(System.currentTimeMillis());

        @Override
        public CustomObj get() {
            index = random.nextInt(100);
            return new CustomObj(index, "Name-" + index);
        }
    }

    @Getter
    @Setter
    @ToString
    static class CustomObj {
        Integer index;
        String name;

        public CustomObj(Integer index, String name) {
            this.index = index;
            this.name = name;
        }
    }

}
