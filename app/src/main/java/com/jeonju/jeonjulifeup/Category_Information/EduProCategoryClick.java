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

public class EduProCategoryClick extends AppCompatActivity {

    static String tname;
    String a;
    static String result, rinstitution, rpalce, rprogramname, rcontext, rfield, rduration, rday, rform, rtime, rtarget, rpersoncount, rpay, rmanager, rcall, raddress;
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eduprocategotyclick);

        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.educationlist);

        //데이터를 저장하게 되는 리스트
        final List<String> list = new ArrayList<>();

        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 프로그램명 from EducationProgram order by 프로그램명 ASC", null);
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
                    } else if (!list.toString().toLowerCase().trim().replace(" ", "").contains(a.toLowerCase())) {
                        Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                    }else {
                        SQLiteDatabase db;
                        Intent intent = new Intent(getApplicationContext(), EduProInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 프로그램운영기관,프로그램운영장소,프로그램명,프로그램내용,분야,운영기간,운영요일,운영형태,운영시간,참여대상,참여인원,수강료,담당자,연락처,운영기관주소 from EducationProgram WHERE UPPER(replace(프로그램명,' ',''))= '" + a.toUpperCase() + "' ", null);
                        result = "";
                        rinstitution = "";
                        rpalce = "";
                        rprogramname = "";
                        rcontext = "";
                        rfield = "";
                        rduration = "";
                        rday = "";
                        rform = "";
                        rtime = "";
                        rtarget = "";
                        rpersoncount = "";
                        rpay = "";
                        rmanager = "";
                        rcall = "";
                        raddress = "";


                        while (cursor.moveToNext()) {
                            String institution = cursor.getString(0);
                            String place = cursor.getString(1);
                            String programname = cursor.getString(2);
                            String context = cursor.getString(3);
                            String field = cursor.getString(4);
                            String duration = cursor.getString(5);
                            String day = cursor.getString(6);
                            String form = cursor.getString(7);
                            String time = cursor.getString(8);
                            String target = cursor.getString(9);
                            String personcount = cursor.getString(10);
                            String pay = cursor.getString(11);
                            String manager = cursor.getString(12);
                            String call = cursor.getString(13);
                            String address = cursor.getString(14);


                            rinstitution += institution;
                            rpalce += place;
                            rprogramname += programname;
                            rcontext += context;
                            rfield += field;
                            rduration += duration;
                            rday += day;
                            rform += form;
                            rtime += time;
                            rtarget += target;
                            rpersoncount += personcount;
                            rpay += pay;
                            rmanager += manager;
                            rcall += call;
                            raddress += address;

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
                a = autoCompleteTextView.getText().toString().trim().replace(" ", "").toUpperCase();
                autoCompleteTextView.setText("");

                if (a.equals("")) {
                    Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (a.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (!list.toString().toUpperCase().trim().replace(" ", "").contains(a.toUpperCase())) {
                    Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase db;
                    Intent intent = new Intent(getApplicationContext(), EduProInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 프로그램운영기관,프로그램운영장소,프로그램명,프로그램내용,분야,운영기간,운영요일,운영형태,운영시간,참여대상,참여인원,수강료,담당자,연락처,운영기관주소 from EducationProgram WHERE UPPER(replace(프로그램명,' ',''))='" + a.toUpperCase() + "' ", null);
                    result = "";
                    rinstitution = "";
                    rpalce = "";
                    rprogramname = "";
                    rcontext = "";
                    rfield = "";
                    rduration = "";
                    rday = "";
                    rform = "";
                    rtime = "";
                    rtarget = "";
                    rpersoncount = "";
                    rpay = "";
                    rmanager = "";
                    rcall = "";
                    raddress = "";


                    while (cursor.moveToNext()) {
                        String institution = cursor.getString(0);
                        String place = cursor.getString(1);
                        String programname = cursor.getString(2);
                        String context = cursor.getString(3);
                        String field = cursor.getString(4);
                        String duration = cursor.getString(5);
                        String day = cursor.getString(6);
                        String form = cursor.getString(7);
                        String time = cursor.getString(8);
                        String target = cursor.getString(9);
                        String personcount = cursor.getString(10);
                        String pay = cursor.getString(11);
                        String manager = cursor.getString(12);
                        String call = cursor.getString(13);
                        String address = cursor.getString(14);


                        rinstitution += institution;
                        rpalce += place;
                        rprogramname += programname;
                        rcontext += context;
                        rfield += field;
                        rduration += duration;
                        rday += day;
                        rform += form;
                        rtime += time;
                        rtarget += target;
                        rpersoncount += personcount;
                        rpay += pay;
                        rmanager += manager;
                        rcall += call;
                        raddress += address;

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
                Intent it = new Intent(EduProCategoryClick.this, EduProInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 프로그램운영기관,프로그램운영장소,프로그램명,프로그램내용,분야,운영기간,운영요일,운영형태,운영시간,참여대상,참여인원,수강료,담당자,연락처,운영기관주소 from EducationProgram WHERE 프로그램명='" + ob + "' ", null);
                result = "";
                rinstitution = "";
                rpalce = "";
                rprogramname = "";
                rcontext = "";
                rfield = "";
                rduration = "";
                rday = "";
                rform = "";
                rtime = "";
                rtarget = "";
                rpersoncount = "";
                rpay = "";
                rmanager = "";
                rcall = "";
                raddress = "";

                while (cursor.moveToNext()) {
                    String institution = cursor.getString(0);
                    String place = cursor.getString(1);
                    String programname = cursor.getString(2);
                    String context = cursor.getString(3);
                    String field = cursor.getString(4);
                    String duration = cursor.getString(5);
                    String day = cursor.getString(6);
                    String form = cursor.getString(7);
                    String time = cursor.getString(8);
                    String target = cursor.getString(9);
                    String personcount = cursor.getString(10);
                    String pay = cursor.getString(11);
                    String manager = cursor.getString(12);
                    String call = cursor.getString(13);
                    String address = cursor.getString(14);

                    rinstitution += institution;                       // 증가하며 출력
                    rpalce += place;
                    rprogramname += programname;
                    rcontext += context;
                    rfield += field;
                    rduration += duration;
                    rday += day;
                    rform += form;
                    rtime += time;
                    rtarget += target;
                    rpersoncount += personcount;
                    rpay += pay;
                    rmanager += manager;
                    rcall += call;
                    raddress += address;

                    cursor.close();
                    mHelper.close();
                }

            }
        });

    }
}
