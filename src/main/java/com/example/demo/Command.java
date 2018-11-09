package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Command
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 15:16
 * @Version 1.0
 **/
public abstract class Command {
    public abstract String execute(CommandVO vo);

    //建立链表
    protected final List<? extends CommandName> buildChain(Class<? extends CommandName> abstractClass) {
        //取出所有的命令下子类
        List<Class> classes = ClassUtils.getSonClass(abstractClass);
        //存放命令的实例，并建立链表关系
        List<CommandName> commandNames = new ArrayList<>();
        for (Class c : classes) {
            CommandName commandName = null;
            //产生实例
            try {
                commandName = (CommandName) Class.forName(c.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //建立链表
            if (commandNames.size() > 0) {
                commandNames.get(commandNames.size() -1).setNext(commandName);
            }
            commandNames.add(commandName);
        }
        return  commandNames;
    }
}
