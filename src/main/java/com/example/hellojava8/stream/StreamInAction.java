package com.example.hellojava8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInAction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /**
         * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
         * **/
        List<Transaction> result1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result1);
        /**
         * (2) 交易员都在哪些不同的城市工作过？
         * **/
        List<String> result2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        System.out.println(result2);
        /**
         * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
         * **/
        List<Trader> result3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result3);
        /**
         * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
         * **/
        String result4 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + ", " + n2);
        System.out.println(result4);
        /**
         * (5) 有没有交易员是在米兰工作的？
         * **/
        Boolean liveInMilan1 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(liveInMilan1);
        Boolean liveInMilan2 = transactions.stream()
                .map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println(liveInMilan2);

        /**
         * (6) 打印生活在剑桥的交易员的所有交易额。
         * */
        List<Integer> result6 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .collect(Collectors.toList());
        System.out.println(result6);

        /**
         * (7) 所有交易中，最高的交易额是多少？
         * */
        transactions.stream()
                .map(Transaction::getValue)
                .reduce((i, j) -> i > j ? i : j)
                .ifPresent(System.out::println);

        /**
         * (8) 找到交易额最小的交易。
         * */
        transactions.stream()
                .map(Transaction::getValue)
                .reduce((i, j) -> i < j ? i : j)
                .ifPresent(System.out::println);
    }
}
