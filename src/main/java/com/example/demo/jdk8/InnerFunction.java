package com.example.demo.jdk8;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName InnerFunction
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/12/3 19:47
 * @Version 1.0
 **/
public class InnerFunction {

    public static void main(String[] args) {

        //Predicate 是一个布尔类型的函数， 改函数只有一个输入参数， Predicate接口包含了多种默认的方法， 用于处理复杂的逻辑动词（and or, negate)
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean foo = predicate.test("foo");
        System.out.println(foo);
        predicate.negate().test("foo");//false
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(nonNull.test(true));

        //Functions :接口接受一个参数，并返回单一的结果，默认方法可以将多个函数串在一起（compose, andThen)
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        //Suppliers 接口产生一个给定类型的结果，与Function不同的是，Supplier没有输入参数，
        Supplier<Converter.Person> personSupplier = Converter.Person::new;
        Converter.Person person = personSupplier.get(); //new Person

        // Consumers 代表了一个输入参数上需要进行操作
        Consumer<Converter.Person> greeter = (p) -> System.out.println("Hello " + p.firstName);
        greeter.accept(new Converter.Person("Luke", "Skywalker"));

        //Comparators
        Comparator<Converter.Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Converter.Person p1 = new Converter.Person("John", "Doe");
        Converter.Person p2 = new Converter.Person("Alice", "WonderLand");
        comparator.compare(p1, p2);//  > 0
        comparator.reversed().compare(p1, p2); // <0

        // Optionals 不是一个函数式接口，而是一个精巧的工具接口用来防止NullPointerException产生
        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); //true
        optional.get(); // "bam"
        optional.orElse("fallback");//"bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
