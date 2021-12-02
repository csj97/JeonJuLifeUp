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

public class WheelChairCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String radd, rname, rsweekday, reweekday, rssaturday, resaturday, rsholi, reholi, rwe, rke, rplace, rair, rnum;   // D
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wheelchaircategoryclick);

        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.wheelchairlistview);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 기관명 from WheelChair order by 기관명 ASC", null);
        tname = "";

        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            tname += name;
            list.add(tname);
            tname = "";
        }

        listview.setAdapter(adapter);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        ArrayAdapter<String> searchList = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        autoCompleteTextView.setAdapter(searchList);

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
                        Intent intent = new Intent(getApplicationContext(), WheelChairCategoryClick.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 소재지도로명주소,관리기관명,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,위도,경도,설치장소설명,공기주입가능여부,관리기관전화번호,기관명 from WheelChair WHERE replace(기관명,' ','')='" + a + "' ", null);
                        radd = "";
                        rname = "";
                        rsweekday = "";
                        reweekday = "";
                        rssaturday = "";
                        resaturday = "";
                        rsholi = "";
                        reholi = "";
                        rwe = "";
                        rke = "";
                        rplace = "";
                        rair = "";
                        rnum = "";

                        while (cursor.moveToNext()) {
                            String add = cursor.getString(0);
                            String name = cursor.getString(1);
                            String sweek = cursor.getString(2);
                            String eweek = cursor.getString(3);
                            String ssatur = cursor.getString(4);
                            String esatur = cursor.getString(5);
                            String sholi = cursor.getString(6);
                            String ehoil = cursor.getString(7);
                            String we = cursor.getString(8);
                            String ke = cursor.getString(9);
                            String place = cursor.getString(10);
                            String air = cursor.getString(11);
                            String num = cursor.getString(12);

                            rname += name;
                            radd += add;
                            rname += name;
                            rsweekday += sweek;
                            reweekday += eweek;
                            rssaturday += ssatur;
                            resaturday += esatur;
                            rsholi += sholi;
                            reholi += ehoil;
                            rwe += we;
                            rke += ke;
                            rplace += place;
                            rair += air;
                            rnum += num;

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
                    SQLiteDatabase db;
                    Intent intent = new Intent(getApplicationContext(), WheelChairInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 소재지도로명주소,관리기관명,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,위도,경도,설치장소설명,공기주입가능여부,관리기관전화번호,기관명 from WheelChair WHERE replace(기관명,' ','')='" + a + "' ", null);
                    radd = "";
                    rname = "";
                    rsweekday = "";
                    reweekday = "";
                    rssaturday = "";
                    resaturday = "";
                    rsholi = "";
                    reholi = "";
                    rwe = "";
                    rke = "";
                    rplace = "";
                    rair = "";
                    rnum = "";

                    while (cursor.moveToNext()) {
                        String add = cursor.getString(0);
                        String name = cursor.getString(1);
                        String sweek = cursor.getString(2);
                        String eweek = cursor.getString(3);
                        String ssatur = cursor.getString(4);
                        String esatur = cursor.getString(5);
                        String sholi = cursor.getString(6);
                        String ehoil = cursor.getString(7);
                        String we = cursor.getString(8);
                        String ke = cursor.getString(9);
                        String place = cursor.getString(10);
                        String air = cursor.getString(11);
                        String num = cursor.getString(12);

                        radd += add;
                        rname += name;
                        rsweekday += sweek;
                        reweekday += eweek;
                        rssaturday += ssatur;
                        resaturday += esatur;
                        rsholi += sholi;
                        reholi += ehoil;
                        rwe += we;
                        rke += ke;
                        rplace += place;
                        rair += air;
                        rnum += num;

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
                Intent it = new Intent(getApplicationContext(), WheelChairInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 소재지도로명주소,관리기관명,평일운영시작시각,평일운영종료시각,토요일운영시작시각,토요일운영종료시각,공휴일운영시작시각,공휴일운영종료시각,위도,경도,설치장소설명,공기주입가능여부,관리기관전화번호,기관명 from WheelChair WHERE 기관명='" + ob + "' ", null);
                radd = "";
                rname = "";
                rsweekday = "";
                reweekday = "";
                rssaturday = "";
                resaturday = "";
                rsholi = "";
                reholi = "";
                rwe = "";
                rke = "";
                rplace = "";
                rair = "";
                rnum = "";

                while (cursor.moveToNext()) {
                    String add = cursor.getString(0);
                    String name = cursor.getString(1);
                    String sweek = cursor.getString(2);
                    String eweek = cursor.getString(3);
                    String ssatur = cursor.getString(4);
                    String esatur = cursor.getString(5);
                    String sholi = cursor.getString(6);
                    String ehoil = cursor.getString(7);
                    String we = cursor.getString(8);
                    String ke = cursor.getString(9);
                    String place = cursor.getString(10);
                    String air = cursor.getString(11);
                    String num = cursor.getString(12);

                    rname += name;
                    radd += add;
                    rname += name;
                    rsweekday += sweek;
                    reweekday += eweek;
                    rssaturday += ssatur;
                    resaturday += esatur;
                    rsholi += sholi;
                    reholi += ehoil;
                    rwe += we;
                    rke += ke;
                    rplace += place;
                    rair += air;
                    rnum += num;
                }
                if (radd.length() == 0) {
                } else {
                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }

}


