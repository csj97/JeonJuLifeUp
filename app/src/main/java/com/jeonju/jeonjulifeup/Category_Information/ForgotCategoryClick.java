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

public class ForgotCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String hname, hlocation, hadd, hcall, helse;   // D
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotcategoryclick);


        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.forgotlistview);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 병의원 from Forgot order by 병의원 ASC", null);
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
                        Intent intent = new Intent(getApplicationContext(), ForgotInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 병의원,시군명,도로명주소,전화번호,특이사항 from Forgot WHERE replace(병의원,' ','')='" + a + "' ", null);
                        hname = "";
                        hlocation = "";
                        hadd = "";
                        hcall = "";
                        helse = "";

                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String location = cursor.getString(1);
                            String add = cursor.getString(2);
                            String call = cursor.getString(3);
                            String elseh = cursor.getString(4);

                            if (elseh == ""){
                                elseh = "없음";
                            }

                            hname += name;
                            hlocation += location;
                            hadd += add;
                            hcall += call;
                            helse += elseh;

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
                    Intent intent = new Intent(getApplicationContext(), ForgotInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 병의원,시군명,도로명주소,전화번호,특이사항 from Forgot WHERE replace(병의원,' ','')='" + a + "' ", null);
                    hname = "";
                    hlocation = "";
                    hadd = "";
                    hcall = "";
                    helse = "";

                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String location = cursor.getString(1);
                        String add = cursor.getString(2);
                        String call = cursor.getString(3);
                        String elseh = cursor.getString(4);

                        if (elseh == null) {
                            elseh = " ";
                        }
                        hname += name;
                        hlocation += location;
                        hadd += add;
                        hcall += call;
                        helse += elseh;

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
                Intent it = new Intent(getApplicationContext(), ForgotInformation.class);
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 병의원,시군명,도로명주소,전화번호,특이사항 from Forgot WHERE 병의원='" + ob + "' ", null);

                hname = "";
                hlocation = "";
                hadd = "";
                hcall = "";
                helse = "";
                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String location = cursor.getString(1);
                    String add = cursor.getString(2);
                    String call = cursor.getString(3);
                    String elseh = cursor.getString(4);

                    if (elseh == null) {
                        elseh = " ";
                    }

                    hname += name;                       // 증가하며 출력
                    hlocation += location;
                    hadd += add;
                    hcall += call;
                    helse += elseh;

                }
                if (hname.length() == 0) {
                    autoCompleteTextView.setHint("검색할 항목을 입력하십시오.");
                } else {
                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}


