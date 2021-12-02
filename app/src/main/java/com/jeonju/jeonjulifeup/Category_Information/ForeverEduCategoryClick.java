package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.Internet.Agency_Internet;
import com.jeonju.jeonjulifeup.Internet.Circle_Internet;
import com.jeonju.jeonjulifeup.Internet.Document_Internet;
import com.jeonju.jeonjulifeup.Internet.Education_Internet;
import com.jeonju.jeonjulifeup.Internet.News_Internet;
import com.jeonju.jeonjulifeup.Internet.Office_Internet;
import com.jeonju.jeonjulifeup.Internet.Teacher_Internet;
import com.jeonju.jeonjulifeup.R;

public class ForeverEduCategoryClick extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forevereducategoryclick);

        ImageView office = (ImageView) findViewById(R.id.office);
        ImageView teacher = (ImageView) findViewById(R.id.teacher);
        ImageView circle = (ImageView) findViewById(R.id.circles);
        ImageView education = (ImageView) findViewById(R.id.education);
        ImageView document = (ImageView) findViewById(R.id.document);
        ImageView news = (ImageView) findViewById(R.id.news);
        ImageView agency = (ImageView) findViewById(R.id.agency);


        TextView officetxt = (TextView) findViewById(R.id.officetxt);
        TextView teachertxt = (TextView) findViewById(R.id.teachertxt);
        TextView circletxt = (TextView) findViewById(R.id.circlestxt);
        TextView educationtxt = (TextView) findViewById(R.id.educationtxt);
        TextView documenttxt = (TextView) findViewById(R.id.documenttxt);
        TextView newstxt = (TextView) findViewById(R.id.newstxt);
        TextView agencytxt = (TextView) findViewById(R.id.agencytxt);

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Office_Internet.class);
                startActivity(intent);
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Teacher_Internet.class);
                startActivity(intent);
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Circle_Internet.class);
                startActivity(intent);
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Education_Internet.class);
                startActivity(intent);
            }
        });
        document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Document_Internet.class);
                startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), News_Internet.class);
                startActivity(intent);
            }
        });
        agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Agency_Internet.class);
                startActivity(intent);
            }
        });
        //-------------------------------------------------------------------------------
        officetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Office_Internet.class);
                startActivity(intent);
            }
        });
        teachertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Teacher_Internet.class);
                startActivity(intent);
            }
        });
        circletxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Circle_Internet.class);
                startActivity(intent);
            }
        });
        educationtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Education_Internet.class);
                startActivity(intent);
            }
        });
        documenttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Document_Internet.class);
                startActivity(intent);
            }
        });
        newstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), News_Internet.class);
                startActivity(intent);
            }
        });
        agencytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Agency_Internet.class);
                startActivity(intent);
            }
        });

    }
}