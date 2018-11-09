package com.example.demo;

/**
 * @ClassName DFCommand
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 22:10
 * @Version 1.0
 **/
public class DFCommand extends  Command {

    @Override
    public String execute(CommandVO vo) {
        return super.buildChain(AbstractDF.class).get(0).handleMessage(vo);
    }
}
