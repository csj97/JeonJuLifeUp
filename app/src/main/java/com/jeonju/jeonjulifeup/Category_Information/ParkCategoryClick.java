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

public class ParkCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String pname, ptype, padd, pwe, pke, pwidth, phave1, phave2, phave3, phave4, phave5, pcall;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parkcategoryclick);

        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.parklistview);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 공원명 from Park order by 공원명 ASC", null);
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
                        Intent intent = new Intent(getApplicationContext(), ParkInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 공원명,공원구분,소재지지번주소,위도,경도,공원면적,공원보유시설1,공원보유시설2,공원보유시설3,공원보유시설4,공원보유시설5,전화번호 from Park WHERE replace(공원명,' ','')='" + a + "' ", null);
                        pname = "";
                        ptype = "";
                        padd = "";
                        pwe = "";
                        pke = "";
                        pwidth = "";
                        phave1 = "";
                        phave2 = "";
                        phave3 = "";
                        phave4 = "";
                        phave5 = "";
                        pcall = "";

                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String type = cursor.getString(1);
                            String add = cursor.getString(2);
                            String we = cursor.getString(3);
                            String ke = cursor.getString(4);
                            String width = cursor.getString(5);
                            String have1 = cursor.getString(6);
                            String have2 = cursor.getString(7);
                            String have3 = cursor.getString(8);
                            String have4 = cursor.getString(9);
                            String have5 = cursor.getString(10);
                            String call = cursor.getString(11);
                            if (have1 == null) {
                                have1 = "";
                            }
                            if (have2 == null) {
                                have2 = "";
                            }
                            if (have3 == null) {
                                have3 = "";
                            }
                            if (have4 == null) {
                                have4 = "";
                            }
                            if (have5 == null) {
                                have5 = "";
                            }

                            pname += name.trim().replace(" ", "");
                            ptype += type;
                            padd += add;
                            pwe += we;
                            pke += ke;
                            pwidth += width;
                            phave1 += have1;
                            phave2 += have2;
                            phave3 += have3;
                            phave4 += have4;
                            phave5 += have5;
                            pcall += call;

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
                    Intent intent = new Intent(getApplicationContext(), ParkInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor, cursor2;
                    cursor = db.rawQuery("select 공원명,공원구분,소재지지번주소,위도,경도,공원면적,공원보유시설1,공원보유시설2,공원보유시설3,공원보유시설4,공원보유시설5,전화번호 from Park WHERE replace(공원명,' ','')='" + a + "' ", null);
                    pname = "";
                    ptype = "";
                    padd = "";
                    pwe = "";
                    pke = "";
                    pwidth = "";
                    phave1 = "";
                    phave2 = "";
                    phave3 = "";
                    phave4 = "";
                    phave5 = "";
                    pcall = "";

                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String type = cursor.getString(1);
                        String add = cursor.getString(2);
                        String we = cursor.getString(3);
                        String ke = cursor.getString(4);
                        String width = cursor.getString(5);
                        String have1 = cursor.getString(6);
                        String have2 = cursor.getString(7);
                        String have3 = cursor.getString(8);
                        String have4 = cursor.getString(9);
                        String have5 = cursor.getString(10);
                        String call = cursor.getString(11);
                        if (have1 == null) {
                            have1 = "";
                        }
                        if (have2 == null) {
                            have2 = "";
                        }
                        if (have3 == null) {
                            have3 = "";
                        }
                        if (have4 == null) {
                            have4 = "";
                        }
                        if (have5 == null) {
                            have5 = "";
                        }

                        pname += name.trim().replace(" ", "");
                        ptype += type;
                        padd += add;
                        pwe += we;
                        pke += ke;
                        pwidth += width;
                        phave1 += have1;
                        phave2 += have2;
                        phave3 += have3;
                        phave4 += have4;
                        phave5 += have5;
                        pcall += call;

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
                Intent it = new Intent(getApplicationContext(), ParkInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 공원명,공원구분,소재지지번주소,위도,경도,공원면적,공원보유시설1,공원보유시설2,공원보유시설3,공원보유시설4,공원보유시설5,전화번호 from Park WHERE 공원명='" + ob + "' ", null);
                pname = "";
                ptype = "";
                padd = "";
                pwe = "";
                pke = "";
                pwidth = "";
                phave1 = "";
                phave2 = "";
                phave3 = "";
                phave4 = "";
                phave5 = "";
                pcall = "";

                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String type = cursor.getString(1);
                    String add = cursor.getString(2);
                    String we = cursor.getString(3);
                    String ke = cursor.getString(4);
                    String width = cursor.getString(5);
                    String have1 = cursor.getString(6);
                    String have2 = cursor.getString(7);
                    String have3 = cursor.getString(8);
                    String have4 = cursor.getString(9);
                    String have5 = cursor.getString(10);
                    String call = cursor.getString(11);

                    if (have1 == null) {
                        have1 = "";
                    }
                    if (have2 == null) {
                        have2 = "";
                    }
                    if (have3 == null) {
                        have3 = "";
                    }
                    if (have4 == null) {
                        have4 = "";
                    }
                    if (have5 == null) {
                        have5 = "";
                    }

                    pname += name;
                    ptype += type;
                    padd += add;
                    pwe += we;
                    pke += ke;
                    pwidth += width;
                    phave1 += have1;
                    phave2 += have2;
                    phave3 += have3;
                    phave4 += have4;
                    phave5 += have5;
                    pcall += call;

                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}


