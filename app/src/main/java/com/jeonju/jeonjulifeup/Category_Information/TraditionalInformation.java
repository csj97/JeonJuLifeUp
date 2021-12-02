package com.jeonju.jeonjulifeup.Category_Information;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jeonju.jeonjulifeup.R;

public class TraditionalInformation extends Activity {

    TextView traditionalname,traditionaltype,traditionaladdress,traditionalhomepage,traditionalopen,traditionallocation,traditioncount,traditionalbook,traditioalgiftcard,traditioalpage,traditionaltoilet,traditionalparking,
            traditionalyear,traditionalcall;
    ImageView img;
    ImageButton imgmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traditional_information);

        //img = (ImageView) findViewById(R.id.MapImage);

//        imgmap = (ImageButton) findViewById(R.id.Imageweke);

        traditionalname=(TextView)findViewById(R.id.traditionalnametxt);
        traditionaltype=(TextView)findViewById(R.id.traditionaltypetxt);
        traditionaladdress=(TextView)findViewById(R.id.traditionaladdresstxt);
        traditionalopen=(TextView)findViewById(R.id.traditionalopentimetxt);
        //traditionallocation=(TextView)findViewById(R.id.trweke);
        traditioncount=(TextView)findViewById(R.id.traditionalstoretxt);
        traditionalbook=(TextView)findViewById(R.id.traditionalitemtxt);
        traditioalgiftcard=(TextView)findViewById(R.id.traditionalgiftcardtxt);
        traditionalhomepage=(TextView)findViewById(R.id.traditionalhomepagetxt);
        traditionaltoilet=(TextView)findViewById(R.id.traditionaltoilettxt);
        traditionalparking=(TextView)findViewById(R.id.traditionalparkingtxt);
        traditionalyear=(TextView)findViewById(R.id.traditionalopenyeartxt);
        traditionalcall=(TextView)findViewById(R.id.traditionalteltxt);


        traditionalname.setText(TraditionalCategoryClick.rname);
        traditionaltype.setText(TraditionalCategoryClick.rtype);
        traditionaladdress.setText(TraditionalCategoryClick.radd+","+ TraditionalCategoryClick.radd2);
        traditionalopen.setText(TraditionalCategoryClick.ropen);
        //traditionallocation.setText(TraditionalCategoryClick.rwe+","+TraditionalCategoryClick.rke);
        traditioncount.setText(TraditionalCategoryClick.rcount);
        traditionalbook.setText(TraditionalCategoryClick.rbook);
        traditioalgiftcard.setText(TraditionalCategoryClick.rgiftcard);
        traditionalhomepage.setText(TraditionalCategoryClick.rpage);
        traditionaltoilet.setText(TraditionalCategoryClick.rtoilet);
        traditionalparking.setText(TraditionalCategoryClick.rparking);
        traditionalyear.setText(TraditionalCategoryClick.ropen2);
        traditionalcall.setText(TraditionalCategoryClick.rcall);

        //



    }
}