package com.example.demo;

/**
 * @ClassName LSCommand
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 15:57
 * @Version 1.0
 **/
public class LSCommand extends Command {
    @Override
    public String execute(CommandVO vo) {
        //返回链表的首节点
        CommandName commandName = super.buildChain(AbstractLS.class).get(0);
        return  commandName.handleMessage(vo);
    }
}
