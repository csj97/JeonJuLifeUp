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

public class ToiletCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String result, rname, rmanb, rmans, rwomanb, rtime, rwe, rke;   // D
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toiletcategoryclick);


        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.toiletlistview);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 화장실명 from Toilet order by 화장실명 ASC", null);
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
                        Intent intent = new Intent(getApplicationContext(), ToiletInformationActivity.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 화장실명,남성용장애인용대변기수,남성용장애인용소변기수,여성용장애인용대변기수,개방시간,위도,경도 from Toilet WHERE replace(화장실명,' ', '')='" + a + "' ", null);
                        result = "";
                        rname = "";
                        rmanb = "";
                        rmans = "";
                        rwomanb = "";
                        rtime = "";
                        rwe = "";
                        rke = "";

                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String manb = cursor.getString(1);
                            String mans = cursor.getString(2);
                            String womanb = cursor.getString(3);
                            String time = cursor.getString(4);
                            String we = cursor.getString(5);
                            String ke = cursor.getString(6);

                            rname += name;
                            rmanb += manb;
                            rmans += mans;
                            rwomanb += womanb;
                            rtime += time;
                            rwe += we;
                            rke += ke;

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
                    Intent intent = new Intent(getApplicationContext(), ToiletInformationActivity.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 화장실명,남성용장애인용대변기수,남성용장애인용소변기수,여성용장애인용대변기수,개방시간,위도,경도 from Toilet WHERE replace(화장실명,' ', '')='" + a + "' ", null);
                    result = "";
                    rname = "";
                    rmanb = "";
                    rmans = "";
                    rwomanb = "";
                    rtime = "";
                    rwe = "";
                    rke = "";

                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String manb = cursor.getString(1);
                        String mans = cursor.getString(2);
                        String womanb = cursor.getString(3);
                        String time = cursor.getString(4);
                        String we = cursor.getString(5);
                        String ke = cursor.getString(6);

                        rname += name;
                        rmanb += manb;
                        rmans += mans;
                        rwomanb += womanb;
                        rtime += time;
                        rwe += we;
                        rke += ke;

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
                Intent it = new Intent(getApplicationContext(), ToiletInformationActivity.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 화장실명,남성용장애인용대변기수,남성용장애인용소변기수,여성용장애인용대변기수,개방시간,위도,경도 from Toilet WHERE 화장실명='" + ob + "' ", null);
                result = "";
                rname = "";
                rmanb = "";
                rmans = "";
                rwomanb = "";
                rtime = "";
                rwe = "";
                rke = "";

                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String manb = cursor.getString(1);
                    String mans = cursor.getString(2);
                    String womanb = cursor.getString(3);
                    String time = cursor.getString(4);
                    String we = cursor.getString(5);
                    String ke = cursor.getString(6);

                    rname += name;                       // 증가하며 출력
                    rmanb += manb;
                    rmans += mans;
                    rwomanb += womanb;
                    rtime += time;
                    rwe += we;
                    rke += ke;

                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}



