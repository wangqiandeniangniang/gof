package com.example.demo;

/**
 * @ClassName DF_G
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:09
 * @Version 1.0
 **/
public class DF_G extends  AbstractDF {

    @Override
    protected String getOperateParam() {
        return super.G_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df_g();
    }
}
