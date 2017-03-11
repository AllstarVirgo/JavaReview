package com.potato.test;

import java.util.Objects;

/**
 * Created by AllstarVirgo on 2017/3/9.
 */
public class EqualsTest {
    private Person person;

    private Student student;

    public EqualsTest(){
        student=new Student("Jasmine","女","1604");
        person=new Person("Jasmine","女");
    }

    private boolean equalsFather_Son(){
        return person.equals(student);
    }

    public static void main(String[] args) {
        EqualsTest equalsTest=new EqualsTest();

        System.out.println(equalsTest.equalsFather_Son());
    }
}

class Person{
    private String name;

    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return 7* Objects.hashCode(name)+11*Objects.hashCode(sex);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)return false;

        if(this==obj)return true;

//        if(this.getClass()!=obj.getClass())return false;
        if(!(obj instanceof Person))return false;

        Person otherPerson=(Person)obj;

        return  name.equals(otherPerson.name)&&sex.equals(otherPerson.sex);
    }
}

class Student extends Person{
    private String classId;

    public Student(String name, String sex, String classId) {
        super(name, sex);
        this.classId = classId;
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj))return false;

        Student otherStudent=(Student)obj;

        return classId.equals(otherStudent.classId);
    }

    @Override
    public int hashCode(){
        return super.hashCode()+17*Objects.hashCode(classId);
    }

}
