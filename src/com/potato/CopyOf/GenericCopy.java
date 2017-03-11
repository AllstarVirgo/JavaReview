package com.potato.CopyOf;

import java.lang.reflect.Array;

/**
 * Created by allstarvirgo on 17-3-11.
 */
public class GenericCopy {
    public static Object goodCopyOf(Object a,int newLength){
        //a是任意类型的数组对象
        Class cl=a.getClass();

        if(!cl.isArray())return null;
        int length=Array.getLength(a);
        //返回一个数组的class对象
        Class classType=cl.getComponentType();
        //重新构造数组，两个参数，一个是数组的元素类型，一个是数组的长度
        Object newArray= Array.newInstance(classType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
