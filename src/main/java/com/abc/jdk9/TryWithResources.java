package com.abc.jdk9;

import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResources {

    public static void main(String[] args) {
        // Java9中try更加灵活强大，支持在try子语句外部定义resource
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            // 如果放在try子语句中，那么reader默认是final的，不可以重新赋值，如果重新赋值，那么编译会报错
//            reader = new InputStreamReader(System.in);
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
