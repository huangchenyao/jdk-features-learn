package com.abc.jdk7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 类型推断增强
 * 只要编译器可以根据上下文推断出类型参数，就可以用一对空的尖角号(<>)替换调用泛型类的构造函数所需的类型参数。
 * 这个符号有个非官方名称：diamond
 */
public class TypeInference {
    // 例如
    Map<String, List<String>> myMap1 = new HashMap<String, List<String>>();
    // 在Java 7中, 可以这样省略
    Map<String, List<String>> myMap2 = new HashMap<>();

    // 如果想要自动进行类型推断，需要显式地加上<>符号，否则会产生unchecked conversion warning
    // HashMap() constructor refers to the HashMap raw type, not the Map<String, List<String>> type:
    Map<String, List<String>> myMap3 = new HashMap(); // unchecked conversion warning

    // Java 7中对类型推断的支持有限，只有在上下文很明显地知道类型时，才能使用类型推断
    List<String> list = new ArrayList<>();

    {
        list.add("A");
        // The following statement should fail since addAll expects Collection<? extends String>
//        list.addAll(new ArrayList<>()); // invalid
        list.addAll(new ArrayList<String>()); // valid
    }

    // 注意，<>符号通常用在方法调用，但建议主要还是使用在变量声明上
    // 作为对比
    List<? extends String> list2 = new ArrayList<>();

    {
        list.addAll(list2);
    }

    // 类型推断与泛型和非泛型类的通用构造函数
    // 构造函数在泛型和非泛型类中都可以是泛型的，例子如下
    class MyClass<X> {
        X x;

        <T> MyClass(T t) {
            // ...
        }
    }

    // 下面的实例化在Java 7和之前的版本都是有效的
    {
        // 该语句创建了一个类型为MyClass<Integer>的实例，该语句显式指定了泛型类MyClass<X>的形式类型参数X为Integer。
        // 请注意，此泛型类的构造函数包含一个正式的类型参数T。编译器推断出此泛型类的构造函数的形式类型参数T的类型String
        // （因为此构造函数的实际参数是String对象）。
        new MyClass<Integer>("");
    }


    // Java 7之前版本的编译器能够推断通用构造函数的实际类型参数，类似于泛型方法。
    // 但是，如果使用<>，Java 7中的编译器可以推断正在实例化的泛型类的实际类型参数。
    // 在此示例中，编译器为通用类MyClass <X>的形式类型参数X推断类型Integer，推断出此泛型类的构造函数的形式类型参数T的类型String。
    MyClass<Integer> myObject = new MyClass<>("");

}
