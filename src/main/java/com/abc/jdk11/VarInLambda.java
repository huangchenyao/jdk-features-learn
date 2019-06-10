package com.abc.jdk11;

import java.util.stream.IntStream;

public class VarInLambda {

    public static void main(String[] args) {
        IntStream.of(1, 2, 3, 5, 6, 7)
                .filter(i -> i % 3 == 0)
                .forEach(System.out::println);

        IntStream.of(1, 2, 3, 5, 6, 7)
                .filter((@Nonnull var i) -> i % 3 == 0)
                .forEach(System.out::println);

        @Nonnull var a = 1;
    }

}

@interface Nonnull {
}
