package com.example.demo;

/**
 * @ClassName DF_K
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:08
 * @Version 1.0
 **/
public class DF_K extends AbstractDF {
    @Override
    protected String getOperateParam() {
        return super.K_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return DiskManager.df_k();
    }
}
