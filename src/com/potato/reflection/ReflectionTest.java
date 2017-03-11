package com.potato.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by AllstarVirgo on 2017/3/11.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Class cl=java.util.Date.class;
        printConstructors(cl);
        printFields(cl);
        printMethods(cl);
    }
    public static void printConstructors(Class cl){
        Constructor[] constructors=cl.getDeclaredConstructors();

        for(Constructor c:constructors){
            String name= c.getName();
            System.out.println(" ");
            String modifiers= Modifier.toString(c.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name+"(");

            //print parameter types
            Class[] paramTypes=c.getParameterTypes();
            for(int j=0;j<paramTypes.length;j++){
                if(j>0) System.out.print(",");
                System.out.print(paramTypes[j].getName());
            }
            System.out.print(");");
        }
    }

    public static void printMethods(Class cl){
        Method[] methods=cl.getDeclaredMethods();

        for(Method method:methods){
            //return type
            Class returnType=method.getReturnType();
            String name=method.getName();
            System.out.print("  ");
            String modifiers=Modifier.toString(method.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(returnType.getName()+" "+name+" ");

            //print parameter types
            Class[] paramTypes=method.getParameterTypes();
            for(int i=0;i<paramTypes.length;i++){
                if(i>0) System.out.print(",");
                System.out.print(paramTypes[i].getName());
            }
        }
        System.out.print(")");
    }

    public static void printFields(Class cl){
        Field[] fields=cl.getDeclaredFields();

        for(Field field:fields){
            Class fieldType=field.getType();

            String name=field.getName();

            System.out.print(" ");
            String modifiers=Modifier.toString(field.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(fieldType.getName()+" "+name+" ");
        }
    }


}
