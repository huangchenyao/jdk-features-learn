package com.abc.jdk11;

public class StringImprove {

    public static void main(String[] args) {
        // 判断字符串是否为空白  
        System.out.println("      ".isBlank());

        // 去除首尾空格
        System.out.println(" Java ".strip() + "11");

        // 去除尾部空格   
        System.out.println(" Java ".stripTrailing() + "11");

        // 去除首部空格   
        System.out.println(" Java ".stripLeading() + "11");

        // 复制字符串  
        System.out.println("Java".repeat(3));

        // 行数统计  
        System.out.println("J\nA\nV\nA".lines().count());
    }

}
