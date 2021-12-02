package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.R;


public class ToiletInformationActivity extends AppCompatActivity {
    TextView tname, tmanb, tmans, twomanb, ttime;
    ImageView img;
    ImageButton imgmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toilet_information);

        tname = (TextView) findViewById(R.id.Toiletnametxt);
        tmanb = (TextView) findViewById(R.id.Toiletmanbigtxt);
        ttime = (TextView) findViewById(R.id.ToiletTimetxt);

        img = (ImageView) findViewById(R.id.MapImage);

        tname.setText(ToiletCategoryClick.rname);
        tmanb.setText("남자 대변기: "+ ToiletCategoryClick.rmanb+"\n남자 소변기: "+ ToiletCategoryClick.rmans+"\n여자 대변기: "+ ToiletCategoryClick.rwomanb);
        ttime.setText(ToiletCategoryClick.rtime);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsToiletActivity.class);
                startActivity(intent);
            }
        });
    }
}
