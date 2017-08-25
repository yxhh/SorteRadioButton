package com.yw.my.sorteradiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    SortButton all, rate, limit, price;
    int rateIndex = 0, limitIndex = 0, priceIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all = (SortButton) findViewById(R.id.sort_all);
        rate = (SortButton) findViewById(R.id.sort_rate);
        limit = (SortButton) findViewById(R.id.sort_limit);
        price = (SortButton) findViewById(R.id.sort_price);


        all.setOnClickListener(this);
        rate.setOnClickListener(this);
        limit.setOnClickListener(this);
        price.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        clearState();
        switch (v.getId()) {
            case R.id.sort_all:
                setState(0, all);
                break;
            case R.id.sort_rate:
                setState(rateIndex, rate);
                rateIndex++;
                limitIndex = 0;
                priceIndex = 0;
                break;
            case R.id.sort_limit:
                setState(limitIndex, limit);
                limitIndex++;
                rateIndex = 0;
                priceIndex = 0;
                break;
            case R.id.sort_price:
                setState(priceIndex, price);
                priceIndex++;
                rateIndex = 0;
                limitIndex = 0;
                break;
        }
    }

    private void setState(int Index, SortButton button) {
        if (Index % 2 == 0) {
            button.setStateUp();
        } else {
            button.setStateDown();
        }
    }

    private void clearState() {
        all.clearState();
        rate.clearState();
        price.clearState();
        limit.clearState();
    }
}
