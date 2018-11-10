package com.example.demo.unit;

/**
 * @ClassName UserByNameLike
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/10 14:37
 * @Version 1.0
 **/
public class UserByNameLike implements IUserSpecification {
    //like的标记
    private final static String LIKE_FLAG = "%";

    //基准的like字符串
    private String likeStr;

    //构造函数传递基准名字
    public UserByNameLike(String likeStr) {
        this.likeStr = likeStr;
    }

    //检验用户是否满足条件
    @Override
    public boolean isSatisfiedBy(User user) {
        boolean result = false;
        String name = user.getName();
        //替换%后的干净字符串
        String str = likeStr.replace("%", "");
        //是以名称开头，如 国庆%
        if (likeStr.endsWith(LIKE_FLAG) && !likeStr.startsWith(LIKE_FLAG)) {
            result = name.startsWith(str);
        } else if (likeStr.startsWith(LIKE_FLAG) && !likeStr.endsWith(LIKE_FLAG)) {
            result = name.endsWith(str);
        } else {
            result = name.contains(str);
        }
        return result;
    }
}
