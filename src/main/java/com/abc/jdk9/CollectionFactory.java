package com.abc.jdk9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 集合工厂方法
public class CollectionFactory {

    public static void main(String[] args) {
        // 在Java8版本以前，创建一个只读不可变的集合，先要初始化，然后塞数据，然后置为只读
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1 = Collections.unmodifiableSet(set1);

        // 简化一点
        Set<String> set2 = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));
        Set<String> set3 = Collections.unmodifiableSet(new HashSet<String>() {{
            add("a");
            add("b");
            add("c");
        }});

        // Java8使用流的方式创建
        Set<String> set4 = Collections.unmodifiableSet(Stream.of("a", "b", "c").collect(Collectors.toSet()));

        // Java9中引入了很多方便的API，Convenience Factory Methods for Collections，集合工厂方法
        Set<String> set5 = Set.of("a", "b", "c");
        List<String> list = List.of("a", "b", "c");
        Map<String, Object> map1 = Map.of("a", 1, "b", 2, "c", 3);
        Map<String, Object> map2 = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 3)
        );
    }

}
