package com.example.demo.jdk8;

import java.lang.annotation.Repeatable;

/**
 * @ClassName Annotations
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/12/4 9:47
 * @Version 1.0
 **/
public class Annotations {

    public static void main(String[] args) {
        Hint hi = Person.class.getAnnotation(Hint.class);
        System.out.println(hi);
        Hints annotation = Person.class.getAnnotation(Hints.class);
        System.out.println(annotation.value().length); // 2
        Hint[] annotationsByType = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(annotationsByType.length); // 2
    }
}
@interface Hints{
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint{
    String value();
}

@Hints({@Hint("hint1"),@Hint("hint2")})
class Person {}
