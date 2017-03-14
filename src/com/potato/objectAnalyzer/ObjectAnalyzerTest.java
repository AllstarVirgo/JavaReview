package com.potato.objectAnalyzer;


import java.util.ArrayList;

/**
 * Created by AllstarVirgo on 2017/3/11.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer>suqares=new ArrayList<>();
        for(int i=1;i<5;i++){
            suqares.add(i*i);
            System.out.println(new ObjectAnalyzer().toString(suqares));
        }
    }
}
