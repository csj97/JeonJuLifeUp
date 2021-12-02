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

public class PhysicalCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String pname, pcurrent, ptime, ppay, pfee, paddress, pcall;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physicalcategoryclick);

        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor, cursor2;

        final ListView listview = (ListView) findViewById(R.id.physicallistview);

        final List<String> list = new ArrayList<>();
        final List<String> list2 = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 시설장명 from Physical order by 시설장명 ASC", null);
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
                        Intent intent = new Intent(getApplicationContext(), PhysicalInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 시설장명,시설현황,운영시간,전용사용료,시설입장료,주소,전화번호 from Physical WHERE replace(시설장명,' ','')='" + a + "' ", null);
                        pname = "";
                        pcurrent = "";
                        ptime = "";
                        ppay = "";
                        pfee = "";
                        paddress = "";
                        pcall = "";

                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String current = cursor.getString(1);
                            String time = cursor.getString(2);
                            String pay = cursor.getString(3);
                            String fee = cursor.getString(4);
                            String address = cursor.getString(5);
                            String call = cursor.getString(6);

                            if (pay == "#NAME?"){
                                pay = "확인불가";
                            }
                            if (pay == null || pay.length() == 0) {
                                pay = "확인불가";
                            }
                            if (current == null) {
                                current = "확인불가";
                            }
                            if (time == null) {
                                time= "확인불가";
                            }
                            if (address == null) {
                                address = "확인불가";
                            }
                            if (call == null) {
                                call = "확인불가";
                            }
                            if (fee == null) {
                                fee = "확인불가";
                            }

                            pname += name;
                            pcurrent += current;
                            ptime += time;
                            ppay += pay;
                            pfee += fee;
                            paddress += address;
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
                    Intent intent = new Intent(getApplicationContext(), PhysicalInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 시설장명,시설현황,운영시간,전용사용료,시설입장료,주소,전화번호 from Physical WHERE replace(시설장명,' ','')='" + a + "' ", null);
                    pname = "";
                    pcurrent = "";
                    ptime = "";
                    ppay = "";
                    pfee = "";
                    paddress = "";
                    pcall = "";

                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String current = cursor.getString(1);
                        String time = cursor.getString(2);
                        String pay = cursor.getString(3);
                        String fee = cursor.getString(4);
                        String address = cursor.getString(5);
                        String call = cursor.getString(6);

                        if (pay == "#NAME?"){
                            pay = "확인불가";
                        }
                        if (pay == null || pay.length() == 0) {
                            pay = "확인불가";
                        }
                        if (current == null) {
                            current = "확인불가";
                        }
                        if (time == null) {
                            time= "확인불가";
                        }
                        if (address == null) {
                            address = "확인불가";
                        }
                        if (call == null) {
                            call = "확인불가";
                        }

                        if (fee == null) {
                            fee = "확인불가";
                        }

                        pname += name;
                        pcurrent += current;
                        ptime += time;
                        ppay += pay;
                        pfee += fee;
                        paddress += address;
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
                Intent it = new Intent(getApplicationContext(), PhysicalInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 시설장명,시설현황,운영시간,전용사용료,시설입장료,주소,전화번호 from Physical WHERE 시설장명='" + ob + "' ", null);
                pname = "";
                pcurrent = "";
                ptime = "";
                ppay = "";
                pfee = "";
                paddress = "";
                pcall = "";

                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String current = cursor.getString(1);
                    String time = cursor.getString(2);
                    String pay = cursor.getString(3);
                    String fee = cursor.getString(4);
                    String address = cursor.getString(5);
                    String call = cursor.getString(6);

                    if (pay == "#NAME?") {
                        pay = "확인불가";
                    }
                    if (current == null) {
                        current = "확인불가";
                    }
                    if (time == null) {
                        time= "확인불가";
                    }
                    if (address == null) {
                        address = "확인불가";
                    }
                    if (call == null) {
                        call = "확인불가";
                    }

                    if (fee == null) {
                        fee = "확인불가";
                    }

                    pname += name;
                    pcurrent += current;
                    ptime += time;
                    ppay += pay;
                    pfee += fee;
                    paddress += address;
                    pcall += call;

                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}
