package myapplication.t.example.com.demo2048.clss;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by T on 2016/9/27.
 */

public class Card extends FrameLayout {
    private int num = 0;
    private TextView label;

    public Card(Context context) {
        super(context);
        label = new TextView(getContext());
        setNum(0);
        label.setTextSize(32);
        label.setBackgroundColor(0x33ffffff);
//        label.setBackgroundColor(0xffbbada0);
        label.setGravity(Gravity.CENTER);

        LayoutParams lp = new LayoutParams(-1, -1);
        lp.setMargins(20, 20, 0, 0);
        addView(label, lp);
    }

    public TextView getLabel() {
        return label;
    }


    public int getNum() {

        return num;
    }

    public void setNum(int num) {
        this.num = num;
        if (num <= 0) {
            label.setText("");
            label.setBackgroundColor(0x33ffffff);
        } else {
            if (num == 2) {
                label.setBackgroundColor(0x333946F5);
            } else if (num == 4) {
                label.setBackgroundColor(0x33F2FA00);
            } else if (num == 8) {
                label.setBackgroundColor(0x3317F205);
            } else if (num == 16) {
                label.setBackgroundColor(0x33E81F8B);
            } else if (num == 32) {
                label.setBackgroundColor(0x330F71F0);
            } else if (num == 64) {
                label.setBackgroundColor(0x331C0FF0);
            } else if (num == 128) {
                label.setBackgroundColor(0x3305F517);
            } else if (num == 256) {
                label.setBackgroundColor(0x33EA1F43);
            } else {
                label.setBackgroundColor(0x33ffffff);
            }
            label.setText(num + "");
        }
    }

    public boolean equals(Card o) {
        return getNum() == o.getNum();
    }


}
