package com.jeonju.jeonjulifeup.Category_Information;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jeonju.jeonjulifeup.Database.MyDBHelper;
import com.jeonju.jeonjulifeup.R;

import java.util.ArrayList;
import java.util.List;

public class LibraryCategoryClick extends AppCompatActivity {

    static String tname;
    String a;
    static String rlibraryname, rlibrarytype, rlibraryholiday, rlibrarystart_weekday, rlibraryend_weekday, rlibrarystart_sat, rlibraryend_sat, rlibrarystart_sun, rlibraryend_sun, rlibraryseat, rlibrarybookcount, rlibraryaddress, rlibraryinstitution, rlibrarycall, rlibraryhomepage, rlibrarylatitude, rlibrarylongitude;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.librarycategoryclick);

        mHelper = new MyDBHelper(this,DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.librarylistview);

        //데이터를 저장하게 되는 리스트
        final List<String> list = new ArrayList<>();

        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 도서관명 from Library order by 도서관명 ASC", null);
        tname = "";

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);      //리스트에 프로그램명을 뿌려줌
            tname += name;
            list.add(tname);
            tname = "";
        }
        //리스트뷰의 어댑터를 지정해준다.
        listview.setAdapter(adapter);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        ArrayAdapter<String> searchList = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(searchList);

        list.toString().trim().replace(" ", "");

        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    a = autoCompleteTextView.getText().toString().trim().replace(" ", "");
                    autoCompleteTextView.setText("");

                    if (a.equals("")) {
                        Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    } else if (a.equals(" ")) {
                        Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    } else if (!list.toString().trim().replace(" ", "").contains(a)) {
                        Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        SQLiteDatabase db;
                        Intent intent = new Intent(getApplicationContext(), LibraryInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 도서관명,도서관유형,휴관일,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,열람좌석수,자료수,소재지도로명주소,운영기관명,도서관전화번호,홈페이지주소,위도,경도 from Library WHERE replace(도서관명,' ','')='" + a + "' ", null);
                        rlibraryname = "";
                        rlibrarytype = "";
                        rlibraryholiday = "";
                        rlibrarystart_weekday = "";
                        rlibraryend_weekday = "";
                        rlibrarystart_sat = "";
                        rlibraryend_sat = "";
                        rlibrarystart_sun = "";
                        rlibraryend_sun = "";
                        rlibraryseat = "";
                        rlibrarybookcount = "";
                        rlibraryaddress = "";
                        rlibraryinstitution = "";
                        rlibrarycall = "";
                        rlibraryhomepage = "";
                        rlibrarylatitude = "";
                        rlibrarylongitude = "";


                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String type = cursor.getString(1);
                            String holiday = cursor.getString(2);
                            String start_weekday = cursor.getString(3);
                            String end_weekday = cursor.getString(4);
                            String start_sat = cursor.getString(5);
                            String end_sat = cursor.getString(6);
                            String start_sun = cursor.getString(7);
                            String end_sun = cursor.getString(8);
                            String seat = cursor.getString(9);
                            String bookcount = cursor.getString(10);
                            String libraryaddress = cursor.getString(11);
                            String libraryinstitution = cursor.getString(12);
                            String librarycall = cursor.getString(13);
                            String homepage = cursor.getString(14);
                            String latitude = cursor.getString(15);
                            String longitude = cursor.getString(16);

                            rlibraryname += name;                       // 증가하며 출력
                            rlibrarytype += type;
                            rlibraryholiday += holiday;
                            rlibrarystart_weekday += start_weekday;
                            rlibraryend_weekday += end_weekday;
                            rlibrarystart_sat += start_sat;
                            rlibraryend_sat += end_sat;
                            rlibrarystart_sun += start_sun;
                            rlibraryend_sun += end_sun;
                            rlibraryseat += seat;
                            rlibrarybookcount += bookcount;
                            rlibraryaddress += libraryaddress;
                            rlibraryinstitution += libraryinstitution;
                            rlibrarycall += librarycall;
                            rlibraryhomepage += homepage;
                            rlibrarylatitude += latitude;
                            rlibrarylongitude += longitude;

                            cursor.close();
                            mHelper.close();
                        }
                    }
                    return true;
                }
                return false;
            }
        });

        btnSearch = (Button) findViewById(R.id.edtBtn);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = autoCompleteTextView.getText().toString().trim().replace(" ", "");
                autoCompleteTextView.setText("");

                if (a.equals("")) {
                    Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (a.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (!list.toString().trim().replace(" ", "").contains(a)) {
                    Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(getApplicationContext(), LibraryInformation.class);
                    startActivity(intent);
                    SQLiteDatabase db;
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 도서관명,도서관유형,휴관일,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,열람좌석수,자료수,소재지도로명주소,운영기관명,도서관전화번호,홈페이지주소,위도,경도 from Library WHERE replace(도서관명,' ','')='" + a + "' ", null);
                    rlibraryname = "";
                    rlibrarytype = "";
                    rlibraryholiday = "";
                    rlibrarystart_weekday = "";
                    rlibraryend_weekday = "";
                    rlibrarystart_sat = "";
                    rlibraryend_sat = "";
                    rlibrarystart_sun = "";
                    rlibraryend_sun = "";
                    rlibraryseat = "";
                    rlibrarybookcount = "";
                    rlibraryaddress = "";
                    rlibraryinstitution = "";
                    rlibrarycall = "";
                    rlibraryhomepage = "";
                    rlibrarylatitude = "";
                    rlibrarylongitude = "";


                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String type = cursor.getString(1);
                        String holiday = cursor.getString(2);
                        String start_weekday = cursor.getString(3);
                        String end_weekday = cursor.getString(4);
                        String start_sat = cursor.getString(5);
                        String end_sat = cursor.getString(6);
                        String start_sun = cursor.getString(7);
                        String end_sun = cursor.getString(8);
                        String seat = cursor.getString(9);
                        String bookcount = cursor.getString(10);
                        String libraryaddress = cursor.getString(11);
                        String libraryinstitution = cursor.getString(12);
                        String librarycall = cursor.getString(13);
                        String homepage = cursor.getString(14);
                        String latitude = cursor.getString(15);
                        String longitude = cursor.getString(16);

                        if (homepage == null) {
                            homepage = "확인불가";
                        }

                        rlibraryname += name;                       // 증가하며 출력
                        rlibrarytype += type;
                        rlibraryholiday += holiday;
                        rlibrarystart_weekday += start_weekday;
                        rlibraryend_weekday += end_weekday;
                        rlibrarystart_sat += start_sat;
                        rlibraryend_sat += end_sat;
                        rlibrarystart_sun += start_sun;
                        rlibraryend_sun += end_sun;
                        rlibraryseat += seat;
                        rlibrarybookcount += bookcount;
                        rlibraryaddress += libraryaddress;
                        rlibraryinstitution += libraryinstitution;
                        rlibrarycall += librarycall;
                        rlibraryhomepage += homepage;
                        rlibrarylatitude += latitude;
                        rlibrarylongitude += longitude;

                        cursor.close();
                        mHelper.close();
                    }
                }
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override   // position 으로 몇번째 것이 선택됐는지 값을 넘겨준다
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object ob = (Object) parent.getAdapter().getItem(position);
                Intent it = new Intent(LibraryCategoryClick.this, LibraryInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 도서관명,도서관유형,휴관일,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,열람좌석수,자료수,소재지도로명주소,운영기관명,도서관전화번호,홈페이지주소,위도,경도 from Library WHERE 도서관명='" + ob + "' ", null);
                rlibraryname = "";
                rlibrarytype = "";
                rlibraryholiday = "";
                rlibrarystart_weekday = "";
                rlibraryend_weekday = "";
                rlibrarystart_sat = "";
                rlibraryend_sat = "";
                rlibrarystart_sun = "";
                rlibraryend_sun = "";
                rlibraryseat = "";
                rlibrarybookcount = "";
                rlibraryaddress = "";
                rlibraryinstitution = "";
                rlibrarycall = "";
                rlibraryhomepage = "";
                rlibrarylatitude = "";
                rlibrarylongitude = "";


                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String type = cursor.getString(1);
                    String holiday = cursor.getString(2);
                    String start_weekday = cursor.getString(3);
                    String end_weekday = cursor.getString(4);
                    String start_sat = cursor.getString(5);
                    String end_sat = cursor.getString(6);
                    String start_sun = cursor.getString(7);
                    String end_sun = cursor.getString(8);
                    String seat = cursor.getString(9);
                    String bookcount = cursor.getString(10);
                    String libraryaddress = cursor.getString(11);
                    String libraryinstitution = cursor.getString(12);
                    String librarycall = cursor.getString(13);
                    String homepage = cursor.getString(14);
                    String latitude = cursor.getString(15);
                    String longitude = cursor.getString(16);

                    if (homepage == null) {
                        homepage = "확인불가";
                    }

                    rlibraryname += name;
                    rlibrarytype += type;
                    rlibraryholiday += holiday;
                    rlibrarystart_weekday += start_weekday;
                    rlibraryend_weekday += end_weekday;
                    rlibrarystart_sat += start_sat;
                    rlibraryend_sat += end_sat;
                    rlibrarystart_sun += start_sun;
                    rlibraryend_sun += end_sun;
                    rlibraryseat += seat;
                    rlibrarybookcount += bookcount;
                    rlibraryaddress += libraryaddress;
                    rlibraryinstitution += libraryinstitution;
                    rlibrarycall += librarycall;
                    rlibraryhomepage += homepage;
                    rlibrarylatitude += latitude;
                    rlibrarylongitude += longitude;

                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}
