package com.potato.test;

import java.util.ArrayList;

/**
 * Created by allstarvirgo on 17-3-11.
 */
public class IsArray {
    ArrayList<String>list=new ArrayList<>();

    public static void main(String[] args) {
        IsArray isArray=new IsArray();

        if(isArray.list.getClass().isArray()) System.out.println("List is kind of array");

        else System.out.println("list is not array");
    }
}
