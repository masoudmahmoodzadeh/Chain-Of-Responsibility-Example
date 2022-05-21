package com.github.masoudmahmoodzadeh.chain;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.masoudmahmoodzadeh.chain.base.Money;
import com.github.masoudmahmoodzadeh.chain.base.OnWithdrawListener;
import com.github.masoudmahmoodzadeh.chain.base.WithdrawAble;
import com.github.masoudmahmoodzadeh.chain.base.handlers.FiftyDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.FiveDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.OneDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.OneHundredDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.TenDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.TwentyDollar;
import com.github.masoudmahmoodzadeh.chain.base.handlers.TwoDollar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnWithdrawListener {

    private final List<WithdrawAble> withdrawAbleMoney = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Money> chain = createChain();

        EditText etPrice = findViewById(R.id.et_price);
        Button btnWithdraw = findViewById(R.id.btn_withdraw);

        btnWithdraw.setOnClickListener(view -> {
            withdrawAbleMoney.clear();
            int price = Integer.parseInt(etPrice.getText().toString());
            chain.get(0).check(price);
            if (withdrawAbleMoney.isEmpty()) {
                Toast.makeText(MainActivity.this, "موجودی کافی نیست", Toast.LENGTH_LONG).show();
            } else {

                String withdraw = "";

                for (WithdrawAble item : withdrawAbleMoney) {
                    withdraw = item.getCount() + "=" + item.getMoney().getPrice() + "\n" + withdraw;

                }

                Toast.makeText(MainActivity.this, withdraw, Toast.LENGTH_LONG).show();

            }
        });
    }

    private List<Money> createChain() {
        List<Money> chain = new ArrayList<>();

        Money one = new OneDollar(7, null, this);
        Money two = new TwoDollar(8, one, this);
        Money five = new FiveDollar(9, two, this);
        Money ten = new TenDollar(10, five, this);
        Money twenty = new TwentyDollar(11, ten, this);
        Money fifty = new FiftyDollar(12, twenty, this);
        Money oneHundred = new OneHundredDollar(13, fifty, this);

        chain.add(oneHundred);
        chain.add(fifty);
        chain.add(twenty);
        chain.add(ten);
        chain.add(five);
        chain.add(two);
        chain.add(one);

        return chain;
    }

    @Override
    public void withdraw(WithdrawAble withdrawable) {
        withdrawAbleMoney.add(withdrawable);
    }
}