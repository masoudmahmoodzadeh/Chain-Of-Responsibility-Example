package com.github.masoudmahmoodzadeh.chain.base;

public class WithdrawAble {

    private final int count;
    private final Money money;

    public WithdrawAble(int count, Money money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public Money getMoney() {
        return money;
    }
}
