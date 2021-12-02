package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.R;

public class WheelChairInformation extends AppCompatActivity {

    TextView wadd,wname,wtime,whome,wlocation,wair,wnum;
    ImageView img;
    ImageButton imgmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wheelchair_information);

        img = (ImageView) findViewById(R.id.MapImage);

        wadd=(TextView)findViewById(R.id.wheelchairaddresstxt);
        wname=(TextView)findViewById(R.id.wheelchairmanagementtxt);
        wtime=(TextView)findViewById(R.id.wheelchairtimetxt);
        whome=(TextView)findViewById(R.id.wheelchairinstalltxt);
        wair=(TextView)findViewById(R.id.wheelchairairtxt);
        wnum=(TextView)findViewById(R.id.wheelchairteltxt);

        wadd.setText(WheelChairCategoryClick.radd);
        wname.setText(WheelChairCategoryClick.rname);
        wtime.setText("평    일 :  "+ WheelChairCategoryClick.rsweekday+" ~ "+ WheelChairCategoryClick.reweekday+"\n토요일 :  "+ WheelChairCategoryClick.rssaturday+" ~ "+ WheelChairCategoryClick.resaturday);
        whome.setText(WheelChairCategoryClick.rplace);
        wair.setText(WheelChairCategoryClick.rair);
        wnum.setText(WheelChairCategoryClick.rnum);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsWheelChairActivity.class);
                startActivity(intent);
            }
        });
    }

}


