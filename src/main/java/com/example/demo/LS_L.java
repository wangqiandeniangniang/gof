package com.example.demo;

/**
 * @ClassName LS_L
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 15:12
 * @Version 1.0
 **/
public class LS_L extends  AbstractLS {


    @Override
    protected String getOperateParam() {
        return super.L_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_l(vo.formatData());
    }
}
