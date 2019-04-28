package com.example.hellojava8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * example - 3
 */
public class LambdaFunctions {

    @FunctionalInterface
    private interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public static void main(String[] args) {
        try {
            String result = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(result);

            result = processFile((BufferedReader br) -> {
                String text = "", line;
                while ((line = br.readLine()) != null) {
                    text += line;
                }
                return text;
            });
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("README.md"))) {
            return p.process(br);
        }

    }


}
