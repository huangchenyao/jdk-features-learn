package com.abc.jdk9;

public class Diamond {

    public static void main(String[] args) {
        Handler<Integer> intHandler1 = new Handler<Integer>(1) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler1.handle();

        Handler<Integer> intHandler2 = new Handler<>(2) {
            @Override
            public void handle() {
                System.out.println(content);
            }
        };
        intHandler2.handle();
    }

}

abstract class Handler<T> {
    public T content;

    public Handler(T content) {
        this.content = content;
    }

    abstract void handle();
}