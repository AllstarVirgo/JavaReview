package com.potato.threadlearn;

/**
 * Created by AllstarVirgo on 2017/3/24.
 */
public class RaceCondition {
}

class Bank{
    private int accountNum;

    private Account[] accounts;

    public Bank(int accountNum) {
        this.accountNum=accountNum;
        this.accounts = new Account[accountNum];
        for(int i=0;i<accountNum;i++){
            accounts[i].setMoney((int)Math.random()*1000);
            accounts[i].setName("Jasmine"+i);
        }
    }

    public void transfer(Account from,Account to){
        int transerMoney=(int)Math.random()*1000;

        from.setMoney(from.getMoney()-transerMoney);

        to.setMoney(to.getMoney()+transerMoney);
    }
}

class Account{
    private int money;

    private String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }
}
