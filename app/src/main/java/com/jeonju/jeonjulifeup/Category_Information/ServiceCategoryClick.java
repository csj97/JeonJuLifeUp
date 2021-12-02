package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.Internet.Child_Internet;
import com.jeonju.jeonjulifeup.Internet.Corona_Internet;
import com.jeonju.jeonjulifeup.Internet.Handicapp_Internet;
import com.jeonju.jeonjulifeup.Internet.Information_Internet;
import com.jeonju.jeonjulifeup.Internet.Location_Internet;
import com.jeonju.jeonjulifeup.Internet.Medical_Internet;
import com.jeonju.jeonjulifeup.Internet.Old_Internet;
import com.jeonju.jeonjulifeup.Internet.Women_Famliy_Internet;
import com.jeonju.jeonjulifeup.R;

public class ServiceCategoryClick extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicecategoryclick);

        ImageView old = (ImageView) findViewById(R.id.OldPNG);
        ImageView child = (ImageView) findViewById(R.id.ChildPNG);
        ImageView womanfamily = (ImageView) findViewById(R.id.WomanFamilyPNG);
        ImageView hadicapp = (ImageView) findViewById(R.id.HandicappPNG);
        ImageView info = (ImageView) findViewById(R.id.IniformationPNG);
        ImageView medical = (ImageView) findViewById(R.id.MedicalPNG);
        ImageView location = (ImageView) findViewById(R.id.locationPNG);
        ImageView corona = (ImageView) findViewById(R.id.CoronaPNG);

        TextView oldtxt = (TextView) findViewById(R.id.oldtext);
        TextView childtxt = (TextView) findViewById(R.id.childtext);
        TextView womanfamilytxt = (TextView) findViewById(R.id.womanfamilytext);
        TextView hadicapptxt = (TextView) findViewById(R.id.handicapptext);
        TextView infotxt = (TextView) findViewById(R.id.informationtext);
        TextView medicaltxt = (TextView) findViewById(R.id.medicaltext);
        TextView locationtxt = (TextView) findViewById(R.id.locationtext);
        TextView coronatxt = (TextView) findViewById(R.id.coronatext);


        old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Old_Internet.class);
                startActivity(intent);
            }
        });

        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Child_Internet.class);
                startActivity(intent);
            }
        });
        womanfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Women_Famliy_Internet.class);
                startActivity(intent);
            }
        });
        hadicapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Handicapp_Internet.class);
                startActivity(intent);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_Internet.class);
                startActivity(intent);
            }
        });
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Medical_Internet.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Location_Internet.class);
                startActivity(intent);
            }
        });
        corona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Corona_Internet.class);
                startActivity(intent);
            }
        });

//        ----------------------------------------------------------------------------------
        oldtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Old_Internet.class);
                startActivity(intent);
            }
        });
        childtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Child_Internet.class);
                startActivity(intent);
            }
        });
        womanfamilytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Women_Famliy_Internet.class);
                startActivity(intent);
            }
        });
        hadicapptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Handicapp_Internet.class);
                startActivity(intent);
            }
        });
        infotxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Information_Internet.class);
                startActivity(intent);
            }
        });
        medicaltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Medical_Internet.class);
                startActivity(intent);
            }
        });
        locationtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Location_Internet.class);
                startActivity(intent);
            }
        });
        coronatxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Corona_Internet.class);
                startActivity(intent);
            }
        });

    }
}