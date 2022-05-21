package com.github.masoudmahmoodzadeh.chain.base;

public abstract class Money {

    protected int inventory;
    protected Money successor;
    protected OnWithdrawListener withdrawListener;

    public Money(int inventory, Money successor, OnWithdrawListener withdrawListener) {
        this.inventory = inventory;
        this.successor = successor;
        this.withdrawListener = withdrawListener;
    }

    public abstract void check(int withdraw);

    public abstract int getPrice();
}
