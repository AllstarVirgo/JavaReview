package com.potato.test;



/**
 * Created by AllstarVirgo on 2017/3/10.
 */
public class NullEqualsTest {
    private Object a=null;

    private Object b=null;
    public static void main(String[] args) {
        NullEqualsTest nullEqualsTest=new NullEqualsTest();

        System.out.println(nullEqualsTest.a.equals(nullEqualsTest.b));
    }


}
