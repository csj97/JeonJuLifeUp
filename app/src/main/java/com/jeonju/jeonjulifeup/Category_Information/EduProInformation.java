package com.jeonju.jeonjulifeup.Category_Information;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.R;

public class EduProInformation extends AppCompatActivity {

    TextView tinstitution, tplace, tprogramname, tcontext, tfield, tduration, tday, tform, ttime, ttarget, tpersoncount, tpay, tmanager, tcall, taddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edupro_information);

        tinstitution = (TextView) findViewById(R.id.educationprogramofficetxt);
        tplace = (TextView) findViewById(R.id.educationprogramplacetxt);
        tprogramname = (TextView) findViewById(R.id.educationprogramnametxt);
        tcontext = (TextView) findViewById(R.id.educationprogramcontenttxt);
        tfield = (TextView) findViewById(R.id.educationprogramfieldtxt);
        tduration = (TextView) findViewById(R.id.educationprogramtermtxt);
        tday = (TextView) findViewById(R.id.educationprogramdaytxt);
        tform = (TextView) findViewById(R.id.educationprogramformtxt);
        ttime = (TextView) findViewById(R.id.educationprogramtimetxt);
        ttarget = (TextView) findViewById(R.id.educationprogramobjecttxt);
        tpersoncount = (TextView) findViewById(R.id.educationprogrampersontxt);
        tpay = (TextView) findViewById(R.id.educationprogramtutiontxt);
        tmanager = (TextView) findViewById(R.id.educationprogrammanagertxt);
        tcall = (TextView) findViewById(R.id.educationprogramcalltxt);
        taddress = (TextView) findViewById(R.id.educationprogramaddresstxt);

        tinstitution.setText(EduProCategoryClick.rinstitution);
        tplace.setText(EduProCategoryClick.rpalce);
        tprogramname.setText(EduProCategoryClick.rprogramname);
        tcontext.setText(EduProCategoryClick.rcontext);
        tfield.setText(EduProCategoryClick.rfield);
        tduration.setText(EduProCategoryClick.rduration);
        tday.setText(EduProCategoryClick.rday);
        tform.setText(EduProCategoryClick.rform);
        ttime.setText(EduProCategoryClick.rtime);
        ttarget.setText(EduProCategoryClick.rtarget);
        tpersoncount.setText(EduProCategoryClick.rpersoncount);
        tpay.setText(EduProCategoryClick.rpay);
        tmanager.setText(EduProCategoryClick.rmanager);
        tcall.setText(EduProCategoryClick.rcall);
        taddress.setText(EduProCategoryClick.raddress);

    }
}
