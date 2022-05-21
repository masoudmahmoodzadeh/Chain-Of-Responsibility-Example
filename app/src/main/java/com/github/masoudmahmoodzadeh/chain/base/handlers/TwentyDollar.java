package com.github.masoudmahmoodzadeh.chain.base.handlers;

import com.github.masoudmahmoodzadeh.chain.base.Money;
import com.github.masoudmahmoodzadeh.chain.base.OnWithdrawListener;
import com.github.masoudmahmoodzadeh.chain.base.WithdrawAble;

public class TwentyDollar extends Money {

    public TwentyDollar(int inventory, Money successor, OnWithdrawListener withdrawListener) {
        super(inventory, successor, withdrawListener);
    }

    @Override
    public void check(int withdraw) {

        int money = withdraw / getPrice();
        int remaining = withdraw % getPrice();

        if (money > 0 && inventory >= money) {
            withdrawListener.withdraw(new WithdrawAble(money, this));

            if (remaining > 0 && successor != null)
                successor.check(remaining);

        } else if (successor != null)
            successor.check(withdraw);


    }

    @Override
    public int getPrice() {
        return 20;
    }
}
