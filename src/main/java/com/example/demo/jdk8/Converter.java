package com.example.demo.jdk8;

/**
 * @InterfaceName Converter
 * @Description 函数式接口必须要有且仅有一个抽象方法声明
 * @Author chen.liang
 * @Date 2018/12/3 14:57
 * @Version 1.0
 **/
 interface Converter<F,T> {

    T convert(F from);

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from); //类似自己可以写多个默认实现
        Converter<String, String> converter1 = (from) -> from+"dddddd";
        Integer convert = converter.convert("123");
         String dd = converter1.convert("123");
        System.out.println(convert);
        System.out.println(dd);

        //::引用
        Converter<String, Integer> sss = Integer::valueOf;
        Integer convert1 = sss.convert("123");
        System.out.println(convert1);
        //方法引用
        Something something = new Something();
        Converter<String, String> startWith = something::startWith;
        String java = startWith.convert("java");
        System.out.println(java);

        //:: 确定合适构造方法
        PersonFactory<Person> personFactory =   Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);

    }
    class Something{
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    class Person{
        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public Person(String firstNam ) {
            this.firstName = firstName;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
    interface  PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }
}
