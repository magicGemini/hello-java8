package com.example.hellojava8.lambda;

/**
 * example - 2
 */
public class RunnableByLambda {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        Thread.currentThread().join();
    }
}
