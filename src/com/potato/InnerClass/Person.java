package com.potato.InnerClass;

/**
 * Created by allstarvirgo on 17-3-12.
 */
public class Person {
    private int age;

    private String sex;

    public Person(){
        age=18;
        sex="girl";
    }

    class body{
        private String heart;

        private String lung;

        public boolean isMature(){
            if(Person.this.age>=18){
                System.out.println("Adult");
                return true;
            }else return false;
        }
    }

    public static void main(String[] args) {
        Person person=new Person();

        Person.body body=person.new body();

        System.out.println(body.isMature());
    }
}
