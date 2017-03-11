package com.potato.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by AllstarVirgo on 2017/3/11.
 */
public class ObjectAnalyzer {
    private ArrayList<Object>vistited=new ArrayList<>();


    public String toString(Object object){
        if(object==null)return "null";
        if(vistited.contains(object))return "...";
        vistited.add(object);
        Class cl=object.getClass();

        if(cl==String.class)return (String)object;

        if(cl.isArray()){
            String r=cl.getComponentType()+"[]{";

            for(int i=0;i< Array.getLength(object);i++){
                if(i>0)r+=",";
                Object val=Array.get(object,i);
//                getComponentType()返回表示数组组件类型的 Class。如果此类不表示数组类，则此方法返回 null。
//                isPrimitive()判定指定的 Class 对象是否表示一个基本类型。
                if(cl.getComponentType().isPrimitive())r+=val;
                else r+=toString(val);
            }
            return r+"}";
        }

        String r=cl.getName();
        do {
            r+="[";
            Field[] fields=cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);

            for(Field f:fields){
                if(!Modifier.isStatic(f.getModifiers())){
                    if(!r.endsWith("["))r+=",";
                    r+=f.getName()+"=";

                    try {
                        Class t=f.getType();
                        Object val=f.get(object);
                        if(t.isPrimitive())r+=val;
                        else r+=toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

            r+="]";
            cl=cl.getSuperclass();
        }
        while (cl!=null);
            return  r;
    }
}
