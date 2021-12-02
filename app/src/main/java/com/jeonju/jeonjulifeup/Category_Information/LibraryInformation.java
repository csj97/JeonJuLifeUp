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

public class LibraryInformation extends AppCompatActivity {

    TextView tlibraryname, tlibrarytype, tlibraryholiday, tlibraryOpen_weekday,tlibraryOpen_sat,tlibraryOpen_sun
            ,tlibraryseat, tlibrarybookcount, tlibraryaddress, tlibraryinstitution, tlibrarycall, tlibraryhomepage;
    ImageView img_library;
    ImageButton libraryMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_information);

        img_library = (ImageView) findViewById(R.id.MapImage);

//        libraryMap = (ImageButton) findViewById(R.id.map_library);

        tlibraryname = (TextView) findViewById(R.id.librarynametxt);
        tlibrarytype = (TextView) findViewById(R.id.librarytypetxt);
        tlibraryholiday = (TextView) findViewById(R.id.libraryclosedtxt);
        tlibraryOpen_weekday = (TextView) findViewById(R.id.librarytimetxt);
        tlibraryseat = (TextView) findViewById(R.id.libraryseattxt);
        tlibrarybookcount = (TextView) findViewById(R.id.librarydocumenttxt);
        tlibraryaddress = (TextView) findViewById(R.id.libraryaddresstxt);
        tlibraryinstitution = (TextView) findViewById(R.id.libraryofficetxt);
        tlibrarycall = (TextView) findViewById(R.id.libraryteltxt);
        tlibraryhomepage = (TextView) findViewById(R.id.libraryhomepagetxt);

        tlibraryname.setText(LibraryCategoryClick.rlibraryname);
        tlibrarytype.setText(LibraryCategoryClick.rlibrarytype);
        tlibraryholiday.setText(LibraryCategoryClick.rlibraryholiday);
        tlibraryOpen_weekday.setText("평일: "+LibraryCategoryClick.rlibrarystart_weekday + " ~ "+LibraryCategoryClick.rlibraryend_weekday+" \n토요일: "+LibraryCategoryClick.rlibrarystart_sat+ " ~ " + LibraryCategoryClick.rlibraryend_sat+" \n공휴일: "+LibraryCategoryClick.rlibrarystart_sun+ " ~ " + LibraryCategoryClick.rlibraryend_sun);
        tlibraryseat.setText(LibraryCategoryClick.rlibraryseat);
        tlibrarybookcount.setText(LibraryCategoryClick.rlibrarybookcount);
        tlibraryaddress.setText(LibraryCategoryClick.rlibraryaddress);
        tlibraryinstitution.setText(LibraryCategoryClick.rlibraryinstitution);
        tlibrarycall.setText(LibraryCategoryClick.rlibrarycall);
        tlibraryhomepage.setText(LibraryCategoryClick.rlibraryhomepage);

        img_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsLibraryActivity.class);
                startActivity(intent);
            }
        });
    }
}
