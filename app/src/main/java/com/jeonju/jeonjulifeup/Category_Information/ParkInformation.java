package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.R;

public class ParkInformation extends AppCompatActivity {

    TextView pname,ptype,padd,pweke,pwidth,phave,pcall;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.park_information);
        pname=(TextView)findViewById(R.id.parknametxt);
        ptype=(TextView)findViewById(R.id.parkcategorytxt);
        padd=(TextView)findViewById(R.id.parkaddresstxt);
        pwidth=(TextView)findViewById(R.id.parkareatxt);
        phave=(TextView)findViewById(R.id.parkfacilitytxt);
        pcall=(TextView)findViewById(R.id.parkteltxt);

        img = (ImageView) findViewById(R.id.MapImage);

        pname.setText(ParkCategoryClick.pname);
        ptype.setText(ParkCategoryClick.ptype);
        padd.setText(ParkCategoryClick.padd);
        pwidth.setText(ParkCategoryClick.pwidth+"m");
        phave.setText(ParkCategoryClick.phave1+" "+ ParkCategoryClick.phave2+" "+ ParkCategoryClick.phave3+" "+ ParkCategoryClick.phave4+" "+ ParkCategoryClick.phave5+" ");
        pcall.setText(ParkCategoryClick.pcall);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsParkActivity.class);
                startActivity(intent);
            }
        });
    }
}