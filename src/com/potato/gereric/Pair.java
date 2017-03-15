package com.potato.gereric;


import java.util.Date;

/**
 * Created by allstarvirgo on 17-3-13.
 */
public class Pair <T>{
    private T first;

    private T second;



    public Pair(){
        first=null;second=null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}

class ArrayAlg
{
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a==null||a.length==0)return null;
        T min=a[0];
        T max=a[0];
        for(int i=1;i<a.length;i++){
            if(min.compareTo(a[i])>0)min=a[i];
            if(min.compareTo(a[i])<0)max=a[i];
        }
        return new Pair<T>(min,max);
    }

}

class DateInterval extends Pair<Date>
{
    @Override
    public void setSecond(Date second) {
        if(second.compareTo(getFirst())>=0)
        super.setSecond(second);
    }

    public DateInterval() {
        super();
    }

    public DateInterval(Date first, Date second) {
        super(first, second);
    }

    public Date getSecond(){
        return (Date)super.getSecond().clone();
    }


    public static void main(String[] args) {
        Date earlier=new Date(2009,1,1);

        Date later=new Date(2012,12,12);

        Date latest=new Date(2016,1,1);

        DateInterval dateInterval=new DateInterval(earlier,earlier);
        Pair<Date>pair=dateInterval;
        dateInterval.setSecond(later);
        System.out.println(dateInterval.getSecond());
    }



    public static <T extends Comparable>T[] minmax(T a){
        Object[] mm=new Object[2];

        return (T[])mm;
    }
}