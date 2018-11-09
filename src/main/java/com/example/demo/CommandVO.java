package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName CommandVO
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/8 19:42
 * @Version 1.0
 **/
public class CommandVO {
    //定义参数名与参数的分割符号，一般是空格
    public final static String DIVIDE_FLAG = " ";
    //定义参数前的符号，Unix一般是-， 如 ls -la
    public final static String PREFIX = "-";
    //命令名，如 ls、du
    private String commandName = "";
    //参数列表
    private ArrayList<String> paramList = new ArrayList<>();

    //操作数
    private ArrayList<String> dataList = new ArrayList<>();


    //通过构造函数传递进来命令
    public CommandVO(String commandStr) {
        //常规判断
        if (commandStr != null && commandStr.length() != 0) {
            //根据分割符号拆分出执行符号
            String[] complexStr = commandStr.split(CommandVO.DIVIDE_FLAG);
            //第一个参数是执行符号
            this.commandName = complexStr[0];

            //把参数放到List 中
            for (int i = 1; i < complexStr.length; i++) {
                String str = complexStr[i];
                //包括前缀符号、认为是参数
                if (str.indexOf(CommandVO.PREFIX) == 0) {
                    this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
                } else {
                    this.dataList.add(str.trim());
                }
            }
        } else {
            //传递的命令错误
            System.out.println("命令解析失败，必须传递一个命令才能执行！");
        }
    }

    //得到命令名
    public String getCommandName() {
        return commandName;
    }

    //获取参数
    public ArrayList<String> getParamList() {
        //为了方便处理空参数
        if (this.paramList.size() == 0) {
            this.paramList.add("");
        }
        return new ArrayList<>(new HashSet<>(this.paramList));
    }

    //获取操作数
    public ArrayList<String> getDataList() {
        return this.dataList;
    }

    public String formatData() {

        return "";
    }
}
