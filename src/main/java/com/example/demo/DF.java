package com.example.demo;

/**
 * @ClassName DF
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:05
 * @Version 1.0
 **/
public class DF extends AbstractDF {

    //定义一个自己能处理什么参数
    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df();
    }
}
