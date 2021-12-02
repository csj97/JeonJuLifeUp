package com.jeonju.jeonjulifeup.Category_Information;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.R;

public class PhysicalInformation extends AppCompatActivity {

    TextView pname,pcurrent,ptime, ppay, pfee,paddress,pcall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physical_information);
        pname = (TextView) findViewById(R.id.physicaltxt);
        pcurrent = (TextView) findViewById(R.id.physicalstatustxt);
        ptime = (TextView) findViewById(R.id.physicaltimetxt);
        ppay = (TextView) findViewById(R.id.physicalfeetxt);
        pfee = (TextView) findViewById(R.id.physicalfacilityfeetxt);
        paddress = (TextView) findViewById(R.id.physicaladdresstxt);
        pcall = (TextView) findViewById(R.id.physicalteltxt);

        pname.setText(PhysicalCategoryClick.pname);
        pcurrent.setText(PhysicalCategoryClick.pcurrent);
        ptime.setText(PhysicalCategoryClick.ptime);
        ppay.setText(PhysicalCategoryClick.ppay);
        pfee.setText(PhysicalCategoryClick.pfee);
        paddress.setText(PhysicalCategoryClick.paddress);
        pcall.setText(PhysicalCategoryClick.pcall);
    }
}
