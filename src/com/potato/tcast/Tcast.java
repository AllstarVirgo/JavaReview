package com.potato.tcast;

import java.io.File;

/**
 * Created by AllstarVirgo on 2017/3/14.
 */
public class Tcast {
    public static void main(String[] args) {
        Manager ceo=new Manager("jasmine",85555,1515);
        Manager cfo=new Manager("potato",88888,8888);

        Pair<Manager> managerPair = new Pair<>(ceo, cfo);
        //cast to original
        Pair rawBuddies=managerPair;

        rawBuddies.setFirst(new File("test.txt"));

        System.out.println(rawBuddies.getFirst());
    }
}

class Pair<T>{
    private T first;

    private T second;

    public Pair(){}

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}

class Employee{
    private String name;

    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class PairTest3{
    public static void main(String[] args) {
        Manager ceo=new Manager("Jasmine",8898,456);
        Manager cfo=new Manager("potato",909,2323);
        Pair<Manager>buddies=new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000000);
        cfo.setBonus(50000);

        Manager[] managers={ceo,cfo};

        Pair<Employee>result=new Pair<>();
        minmaxBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName()+" second: "+result.getSecond().getName());

        maxminBonus(managers,result);
        System.out.println("first: "+result.getFirst().getName()+",second: "+result.getSecond().getName());
    }
    public static void printBuddies(Pair<? extends Employee> pair){
        Employee first=pair.getFirst();
        Employee second=pair.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies");
    }

    public static void minmaxBonus(Manager[] managers,Pair<? super Manager>result){
        if(managers==null||managers.length==0)return;

        Manager min=managers[0];

        Manager max=managers[0];
        for(int i=1;i<managers.length;i++){
            if(min.getBonus()>managers[i].getBonus())min=managers[i];
            if(max.getBonus()<managers[i].getBonus())max=managers[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] managers,Pair<? super Manager>result){
        minmaxBonus(managers,result);
        PairAlg.swap(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?>pair){
        return pair.getFirst()==null||pair.getSecond()==null;
    }
    //不能用？作为存储类型。编译器必须能够确信通配符表达的是单个的，确定的类型
    public static void swap(Pair<?>pair){swapHelper(pair);}

    public static <T>void swapHelper(Pair<T>pair){
        T t=pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }
}
