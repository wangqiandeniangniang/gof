package com.example.demo.jdk8;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Streams
 * @Description    http://www.importnew.com/10360.html
 * @Author chen.liang
 * @Date 2018/12/3 20:32
 * @Version 1.0
 **/
public class Streams {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        /**
         * Filter 接受一个predicate 接口类型的变量，并将所有流对象中的元素进行过滤。改操作是一个中间操作，因此
         * 他允许我们在返回结果的基础上再进行其他的刘操作（forEach) ,ForEach接受一个function接口类型的变量，用来执行对每一
         * 元素的操作，ForEach是一个中止操作。他不返回流， 所以我们不能再调用其他的操作
         */
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        /**
         * Sorted 是一个中间操作，能够返回一个排过序的流对象的视图，流对象中的元素会默认按照自然顺序进行排序，除非自己制定一个Comparator接口
         * 来改变排序规则,一定要记住，sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序，原来string集合中的元素
         * 顺序是没有改变的
         */
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        /**
         * Map
         * map 是一个对于流对象的中间操作，通过给定的方法，他能够把流对象中的每一个元素对应的到另外一个对象上。
         *
         */
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        /**
         * Match 匹配操作多个不同类型，都是用来判断某一种规则是否与流对象相互吻合的所有的匹配操作都是终结操作，只返回boolean类型的结果
         *
         */
        boolean an = stringCollection
                .stream()
                .anyMatch((s) -> s.startsWith("a"));
        System.out.println(an); //true

        boolean all = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(all);//false

        boolean z = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
        System.out.println(z); // true

        /**
         * Count 一个终结操作，他的作用是返回一个数值，用来标识当前流对象中包含的元素数量
         */
        long b = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(b); // 3

        /**
         * Reduce
         * 该操作是终结操作,他能够通过某一个方法，对元素进行消减操作，改操作的结果会放在一个Optional变量返回
         *
         */
        Optional<String> reduce = stringCollection
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);
        reduce.ifPresent(System.out::println);


        //Parallel Streams


        int max = 100000000;
        List<String> values = new ArrayList<>(max);
        for (int i= 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //顺序排序
        long t0 = System.nanoTime();
       // long count = values.stream().sorted().count();//顺序排序
        long count = values.parallelStream().sorted().count(); //并行排序
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);

        System.out.println(String.format("sequential sort took : %d ms", millis));

        // Map
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id,val) -> System.out.println(values));

        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3);

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);

        map.remove(3, "val3");
        map.get(3);

        map.remove(3, "val33");
        map.get(3);
        //如果没有值就取当前默认值
        map.getOrDefault(42, "not found");

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));

    }
}