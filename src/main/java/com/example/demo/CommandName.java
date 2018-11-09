package com.example.demo;

/**
 * @ClassName CommandName
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/8 19:41
 * @Version 1.0
 **/
public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo) {
        //处理结果
        String result = "";
        //判断是否自己处理参数
        if (vo.getParamList().size() == 0 || vo.getParamList().contains(this.getOperateParam())) {
            result = this.echo(vo);
        } else {
            if (this.nextOperator != null) {
                result = this.nextOperator.handleMessage(vo);
            } else {
                result = "命令无法执行";
            }
        }
        return  result;
    }

    //设置剩余参数由谁来处理
    public void setNext(CommandName commandName) {
        this.nextOperator = commandName;
    }

    //每个处理者都要处理一个后缀参数
    protected abstract String getOperateParam();

    //每个处理者都必须实现处理任务
    protected abstract String echo(CommandVO vo);

}
