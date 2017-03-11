package com.potato.test;

import java.io.*;

/**
 * Created by AllstarVirgo on 2017/3/9.
 */
public class CharCode {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("test.txt")));

        String readline=null;

        while((readline=bufferedReader.readLine())!=null)
        {
            byte[] contentBytes=readline.getBytes();
            //使用utf-8编码，可正常读取...
//            String strContent=new String(contentBytes,"utf-8");
            //使用gbk.乱码,说明平台使用的码为utf-8
            String strContent=new String(contentBytes,"gbk");
            System.out.println(strContent);
        }


    }
}
