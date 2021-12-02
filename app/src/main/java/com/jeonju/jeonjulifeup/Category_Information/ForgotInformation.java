package com.jeonju.jeonjulifeup.Category_Information;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jeonju.jeonjulifeup.R;

public class ForgotInformation extends Activity {

    TextView hname,hlocation,hadd,hcall,helse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_information);

        hname=(TextView)findViewById(R.id.forgothospitaltxt);
        hlocation=(TextView)findViewById(R.id.forgotcitytxt);
        hadd=(TextView)findViewById(R.id.forgotaddresstxt);
        hcall=(TextView)findViewById(R.id.forgotteltxt);
        helse=(TextView)findViewById(R.id.forgotuniquenesstxt);

        hname.setText(ForgotCategoryClick.hname);
        hlocation.setText(ForgotCategoryClick.hlocation);
        hadd.setText(ForgotCategoryClick.hadd);
        hcall.setText(ForgotCategoryClick.hcall);
        helse.setText(ForgotCategoryClick.helse);

    }
}