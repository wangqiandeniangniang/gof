package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @ClassName ClassUtils
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 15:21
 * @Version 1.0
 **/
public class ClassUtils {
    //根据父类查询到所有的子类， 默认情况下子类和父类都在同一包名下
    public static List<Class> getSonClass(Class fatherClass) {
        //定义一个返回值
        List<Class> returnClassList = new ArrayList<>();
        //获取包名
        String packageName = fatherClass.getPackage().getName();
        //获取包中的所有类
        List<Class> packageClasses = getClasses(packageName);
        //判断是是否子类
        for (Class c : packageClasses) {
            if (fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)) {
                returnClassList.add(c);
            }
        }
        return  returnClassList;
    }

    private static List<Class> getClasses(String packageName) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = null;
        try {
            resources = contextClassLoader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return  classes;
    }

    private static List<Class> findClasses(File directory, String packageName) {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return classes;
    }
}
