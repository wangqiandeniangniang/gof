package com.example.demo;

/**
 * @ClassName Invoker
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 20:02
 * @Version 1.0
 **/
public class Invoker {
    //执行命令
    public String exec(String commandStr) {
        //定义返回值
        String result = "";
        //首先解析命令
        CommandVO commandVO = new CommandVO(commandStr);
        //检查是否支持改命令
        if (CommandEnum.getNames().contains(commandVO.getCommandName())) {
            //产生对象
            String className = CommandEnum.valueOf(commandVO.getCommandName()).getValue();
            Command command;
            try {
                command = (Command) Class.forName(className).newInstance();
                result = command.execute(commandVO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            result = "无法执行命令，请检查命令格式";
        }
        return result;
    }
}
