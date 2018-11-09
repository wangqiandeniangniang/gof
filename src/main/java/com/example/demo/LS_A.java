package com.example.demo;

/**
 * @ClassName LS_A
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 15:13
 * @Version 1.0
 **/
public class LS_A extends  AbstractLS {

    @Override
    protected String getOperateParam() {
        return super.A_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_a(vo.formatData());
    }
}
