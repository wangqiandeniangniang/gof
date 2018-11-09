package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public enum CommandEnum {
    ls("com.example.demo.LSCommand");
    private String value = "";

    //定义构造函数， 目的是Data(value)类型的详匹配
    private CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    //返回所有对象
    public static List<String> getNames() {
        CommandEnum[] commandEnums = CommandEnum.values();
        List<String> names = new ArrayList<>();
        for (CommandEnum c : commandEnums) {
            names.add(c.name());
        }
        return names;
    }

}
