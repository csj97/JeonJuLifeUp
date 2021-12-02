package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.Database.MyDBHelper;
import com.jeonju.jeonjulifeup.R;

public class MainActivity extends AppCompatActivity {

    static String result,rname,rmanb,rmans,rwomanb,rtime,rwe,rke;   // DB에 있는 문자열 가져오는 값
    private MyDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전주라이프업");


        //--------------------------------------------------------------메인화면
        ImageView toilet = (ImageView) findViewById(R.id.Toiletpng);
        ImageView edupro = (ImageView) findViewById(R.id.EduPropng);
        ImageView park = (ImageView) findViewById(R.id.Parkpng);
        ImageView library = (ImageView) findViewById(R.id.Librarypng);
        ImageView traditional = (ImageView) findViewById(R.id.Traditionalpng);
        ImageView physical = (ImageView) findViewById(R.id.Physicalpng);
        ImageView wheelchair = (ImageView) findViewById(R.id.WheelChairpng);
        ImageView forgot = (ImageView) findViewById(R.id.Forgotpng);
        ImageView foreveredu = (ImageView) findViewById(R.id.foreveredupng);
        ImageView service = (ImageView) findViewById(R.id.Servicepng);
        ImageView announcement = (ImageView) findViewById(R.id.announcement);

        TextView toilettxt = (TextView) findViewById(R.id.toilettext);
        TextView eduprotxt = (TextView) findViewById(R.id.edutext);
        TextView parktxt = (TextView) findViewById(R.id.parktext);
        TextView librarytxt = (TextView) findViewById(R.id.librarytext);
        TextView traditionaltxt = (TextView) findViewById(R.id.traditionaltext);
        TextView physicaltxt = (TextView) findViewById(R.id.physicaltext);
        TextView wheelchairtxt = (TextView) findViewById(R.id.wheelchairtext);
        TextView forgottxt = (TextView) findViewById(R.id.forgottext);
        TextView servicetxt = (TextView) findViewById(R.id.servicetext);
        TextView foreveredutxt = (TextView) findViewById(R.id.foreveredutext);
        TextView announcementtxt = (TextView) findViewById(R.id.announcementtxt);

        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ToiletCategoryClick.class);
                startActivity(intent);
            }
        });
        edupro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EduProCategoryClick.class);
                startActivity(intent);
            }
        });
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParkCategoryClick.class);
                startActivity(intent);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LibraryCategoryClick.class);
                startActivity(intent);
            }
        });
        traditional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TraditionalCategoryClick.class);
                startActivity(intent);
            }
        });
        physical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicalCategoryClick.class);
                startActivity(intent);
            }
        });
        wheelchair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WheelChairCategoryClick.class);
                startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotCategoryClick.class);
                startActivity(intent);
            }
        });
        foreveredu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForeverEduCategoryClick.class);
                startActivity(intent);
            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceCategoryClick.class);
                startActivity(intent);
            }
        });
        announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Announcement_Internet.class);
                startActivity(intent);
            }
        });


        toilettxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ToiletCategoryClick.class);
                startActivity(intent);
            }
        });
        eduprotxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EduProCategoryClick.class);
                startActivity(intent);
            }
        });
        parktxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParkCategoryClick.class);
                startActivity(intent);
            }
        });
        librarytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LibraryCategoryClick.class);
                startActivity(intent);
            }
        });
        traditionaltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TraditionalCategoryClick.class);
                startActivity(intent);
            }
        });
        physicaltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicalCategoryClick.class);
                startActivity(intent);
            }
        });
        wheelchairtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WheelChairCategoryClick.class);
                startActivity(intent);
            }
        });
        forgottxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForgotCategoryClick.class);
                startActivity(intent);
            }
        });
        foreveredutxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ForeverEduCategoryClick.class);
                startActivity(intent);
            }
        });
        servicetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceCategoryClick.class);
                startActivity(intent);
            }
        });
        announcementtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Announcement_Internet.class);
                startActivity(intent);
            }
        });

//        --------------------------------------------------------------복지서비스 카테고리



    }
}