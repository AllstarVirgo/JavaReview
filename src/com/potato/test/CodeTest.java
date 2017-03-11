package com.potato.test;

import java.io.UnsupportedEncodingException;

/**
 * Created by AllstarVirgo on 2017/3/9.
 */
public class CodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="水";
        byte[] tmp=str.getBytes("gbk");

        System.out.println(new String(tmp,"gbk"));

        for(int i=0;i<tmp.length;i++){
            System.out.print(tmp[i]+"\b");
        }
    }
}
