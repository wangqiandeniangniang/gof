package com.example.demo;

/**
 * @ClassName LS
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/8 20:07
 * @Version 1.0
 **/
public class LS extends  AbstractLS {

    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }
}
