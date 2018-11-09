package com.example.demo;

/**
 * @ClassName FileManager
 * @Description TODO
 * @Author chen.liang
 * @Date 2018/11/9 14:54
 * @Version 1.0
 **/
public class FileManager {

    //ls命令
    public static String ls(String path) {
        return "files\nfile2\nfile3\nfile4";
    }

    // ls -l命令
    public static String ls_l(String path) {
        String str = "drw-rw-rw root system 1024 2018-09-20 10:23 file1 \n";
        str = str + "drw-rw-rw root system 1024 2018-09-20 10:23 file2 \n";
        str = str + "drw-rw-rw root system 1024 2018-09-20 10:23 file3 \n";
        return str;
    }

    //ls -a 命令

    public static String ls_a(String path) {
        String str = ".\n..\nfile1\nfile2\nfile3";
        return str;
    }
}
