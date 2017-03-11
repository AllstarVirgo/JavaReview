package com.potato.test;

/**
 * Created by AllstarVirgo on 2017/3/11.
 */
public enum Size {
    //SMALL ,MEDIUM...均是Size类的实例
    SMALL("s"),MEDIUM("m"),LARGE("l"),EXTRA_LARGE("xl");

    private String abbreviation;

    private Size(String abbreviation){
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

class SzieDemo{
    public static void main(String[] args) {
        //返回枚举常量名
        System.out.println(Size.SMALL.toString());
        Size s=Enum.valueOf(Size.class,"SMALL");
        s.setAbbreviation("ms");
        System.out.println(s.toString());
        System.out.println(Size.SMALL.getAbbreviation());
    }
}
