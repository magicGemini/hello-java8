package com.example.hellojava8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;

public class ReadFile {

    public static void main(String[] args) {
        String filePath = "D:\\workspace_idea\\hello-java8\\README.md";

        // try() 可以不用显示的关闭资源
        Optional.ofNullable(readFileByTry(filePath)).ifPresent(System.out::println);

        // 使用lambda，把方法作为值传递
        Optional.ofNullable(readFileByLambda(filePath, (s) -> {
            try {
                BufferedReader br = new BufferedReader(new FileReader(s));
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        })).ifPresent(System.out::println);
    }


    private static String readFileByTry(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String readFileByLambda(String filePath, Function<String, String> processor) {
        return processor.apply(filePath);
    }

}
