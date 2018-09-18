package com.example.rohit_pc.tipcalci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etBillAmount)
    EditText etBillAmount;
    @BindView(R.id.tippercent)
    TextView tippercent;
    @BindView(R.id.tippercent1)
    TextView tippercent1;
    @BindView(R.id.resultbill)
    TextView resultbill;

    float percentage = 0;
    float num;
    float tiptotal = 0;
    float finalBillAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTipValue();
    }

    public void setTipValue() {
        tippercent.setText(getString(R.string.main_msg_tipprcent, percentage));
        tippercent1.setText(getString(R.string.main_msg_tiptotal, tiptotal));
        resultbill.setText(getString(R.string.main_msg_billtataolresult, finalBillAmount));
    }

    @OnClick({R.id.imageButton, R.id.imageButton1, R.id.imageButton2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageButton:
                percentage = 10;
                break;
            case R.id.imageButton1:
                percentage = 15;
                break;
            case R.id.imageButton2:
                percentage = 20;
                break;
        }
        calculatebill();
        setTipValue();
    }

    @OnTextChanged(R.id.etBillAmount)
    public void onTextChanged() {
        calculatebill();
        setTipValue();
    }

    private void calculatebill() {
        if(percentage == 0)
            percentage=15;
        if(!etBillAmount.getText().toString().equals("") && !etBillAmount.getText().toString().equals(".") )
            num=Float.valueOf(etBillAmount.getText().toString());
        else
           num =0;

        tiptotal=(num*percentage)/100;
        finalBillAmount=num+tiptotal;
    }
}
