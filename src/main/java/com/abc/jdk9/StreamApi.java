package com.abc.jdk9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        // takeWhile 方法使用一个断言作为参数，返回给定 Stream 的子集直到断言语句第一次返回 false。
        // dropWhile 方法和 takeWhile 作用相反的，使用一个断言作为参数，直到断言语句第一次返回 false 才返回给定 Stream 的子集。
        System.out.println("sorted");
        System.out.println("takeWhile");
        List.of(1, 2, 3, 4, 5, 6).stream().takeWhile(i -> i < 4).forEach(System.out::println);
        System.out.println("dropWhile");
        List.of(1, 2, 3, 4, 5, 6).stream().dropWhile(i -> i < 4).forEach(System.out::println);

        System.out.println("unsorted");
        System.out.println("takeWhile");
        Set.of(1, 2, 3, 4, 5, 6).stream().takeWhile(i -> i < 4).forEach(System.out::println);
        System.out.println("dropWhile");
        Set.of(1, 2, 3, 4, 5, 6).stream().dropWhile(i -> i < 4).forEach(System.out::println);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, null);
        map.put(4, "four");
        // Java8
        Set<String> nonNullValues8 = map.entrySet()
                .stream()
                .flatMap(e -> e.getValue() == null ? Stream.empty() : Stream.of(e.getValue()))
                .collect(Collectors.toSet());
        // Java9
        Set<String> nonNullValues9 = map.entrySet()
                .stream()
                .flatMap(e -> Stream.ofNullable(e.getValue()))
                .collect(Collectors.toSet());

        // Java8
        Stream.iterate(1, i -> ++i).limit(3).forEach(System.out::println);
        // Java9
        Stream.iterate(1, i -> i < 4, i -> ++i).forEach(System.out::println);
    }

}
