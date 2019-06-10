package com.abc.jdk10;

import java.util.ArrayList;

public class LocalVariable {

    public static void main(String[] args) {
        // 局部变量初始化
        var a = 1;
        var list = new ArrayList<>();

        //for循环内部索引变量
        for (var s : list) {
            System.out.println(s);
        }

        //传统的for循环声明变量
        for (var i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
    }

}
