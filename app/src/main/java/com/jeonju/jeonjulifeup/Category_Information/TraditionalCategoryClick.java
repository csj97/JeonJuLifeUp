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

public class TraditionalCategoryClick extends AppCompatActivity {
    static String tname;
    String a;
    static String rname, rtype, radd, radd2, ropen, rwe, rke, rcount, rbook, rgiftcard, rpage, rtoilet, rparking, ropen2, rcall;   // D
    private MyDBHelper mHelper;
    private final static int DATABASE_VERSION = 1;
    private Button btnSearch;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traditionalcategoryclick);


        mHelper = new MyDBHelper(this, DATABASE_VERSION);
        SQLiteDatabase db;
        db = mHelper.getWritableDatabase();
        Cursor cursor;

        final ListView listview = (ListView) findViewById(R.id.traditionallistview);

        final List<String> list = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        cursor = db.rawQuery("select 시장명 from Traditional order by 시장명 ASC", null);
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
                    a.toLowerCase();
                    autoCompleteTextView.setText("");

                    if (a.equals("")) {
                        Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    } else if (a.equals(" ")) {
                        Toast.makeText(getApplicationContext(), "검색 할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    } else if (!list.toString().trim().replace(" ", "").contains(a)) {
                        Toast.makeText(getApplicationContext(), "검색 결과가 없습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        SQLiteDatabase db;
                        Intent intent = new Intent(getApplicationContext(), TraditionalInformation.class);
                        startActivity(intent);
                        db = mHelper.getWritableDatabase();
                        Cursor cursor;
                        cursor = db.rawQuery("select 시장명,시장유형,소재지도로명주소,소재지지번주소,시장개설주기,위도,경도,점포수,취급품목,사용가능상품권,홈페이지주소,공중화장실보유여부,주차장보유여부,개설년도,전화번호 from Traditional WHERE replcae(시장명,' ','')='" + a + "' ", null);
                        rname = "";
                        rtype = "";
                        radd = "";
                        radd2 = "";
                        ropen = "";
                        rwe = "";
                        rke = "";
                        rcount = "";
                        rbook = "";
                        rgiftcard = "";
                        rpage = "";
                        rtoilet = "";
                        rparking = "";
                        ropen2 = "";
                        rcall = "";

                        while (cursor.moveToNext()) {
                            String name = cursor.getString(0);
                            String type = cursor.getString(1);
                            String add = cursor.getString(2);
                            String add2 = cursor.getString(3);
                            String open = cursor.getString(4);
                            String we = cursor.getString(5);
                            String ke = cursor.getString(6);
                            String count = cursor.getString(7);
                            String book = cursor.getString(8);
                            String giftcard = cursor.getString(9);
                            String page = cursor.getString(10);
                            String toilet = cursor.getString(11);
                            String parking = cursor.getString(12);
                            String open2 = cursor.getString(13);
                            String call = cursor.getString(14);

                            rname += name;
                            rtype += type;
                            radd += add;
                            radd2 += add2;
                            ropen += open;
                            rwe += we;
                            rke += ke;
                            rcount += count;
                            rbook += book;
                            rgiftcard += giftcard;
                            rpage += page;
                            rtoilet += toilet;
                            rparking += parking;
                            ropen2 += open2;
                            rcall += call;

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
                    Intent intent = new Intent(getApplicationContext(), TraditionalInformation.class);
                    startActivity(intent);
                    db = mHelper.getWritableDatabase();
                    Cursor cursor;
                    cursor = db.rawQuery("select 시장명,시장유형,소재지도로명주소,소재지지번주소,시장개설주기,위도,경도,점포수,취급품목,사용가능상품권,홈페이지주소,공중화장실보유여부,주차장보유여부,개설년도,전화번호 from Traditional WHERE replcae(시장명,' ','')='" + a + "' ", null);
                    rname = "";
                    rtype = "";
                    radd = "";
                    radd2 = "";
                    ropen = "";
                    rwe = "";
                    rke = "";
                    rcount = "";
                    rbook = "";
                    rgiftcard = "";
                    rpage = "";
                    rtoilet = "";
                    rparking = "";
                    ropen2 = "";
                    rcall = "";

                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String type = cursor.getString(1);
                        String add = cursor.getString(2);
                        String add2 = cursor.getString(3);
                        String open = cursor.getString(4);
                        String we = cursor.getString(5);
                        String ke = cursor.getString(6);
                        String count = cursor.getString(7);
                        String book = cursor.getString(8);
                        String giftcard = cursor.getString(9);
                        String page = cursor.getString(10);
                        String toilet = cursor.getString(11);
                        String parking = cursor.getString(12);
                        String open2 = cursor.getString(13);
                        String call = cursor.getString(14);

                        rname += name;
                        rtype += type;
                        radd += add;
                        radd2 += add2;
                        ropen += open;
                        rwe += we;
                        rke += ke;
                        rcount += count;
                        rbook += book;
                        rgiftcard += giftcard;
                        rpage += page;
                        rtoilet += toilet;
                        rparking += parking;
                        ropen2 += open2;
                        rcall += call;

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
                Intent it = new Intent(getApplicationContext(), TraditionalInformation.class);   // 인텐트 처리
                it.putExtra("list", list.get(position));
                startActivity(it);
                SQLiteDatabase db;
                db = mHelper.getWritableDatabase();
                Cursor cursor;
                cursor = db.rawQuery("select 시장명,시장유형,소재지도로명주소,소재지지번주소,시장개설주기,위도,경도,점포수,취급품목,사용가능상품권,홈페이지주소,공중화장실보유여부,주차장보유여부,개설년도,전화번호 from Traditional WHERE 시장명='" + ob + "' ", null);


                while (cursor.moveToNext()) {
                    String name = cursor.getString(0);
                    String type = cursor.getString(1);
                    String add = cursor.getString(2);
                    String add2 = cursor.getString(3);
                    String open = cursor.getString(4);
                    String we = cursor.getString(5);
                    String ke = cursor.getString(6);
                    String count = cursor.getString(7);
                    String book = cursor.getString(8);
                    String giftcard = cursor.getString(9);
                    String page = cursor.getString(10);
                    String toilet = cursor.getString(11);
                    String parking = cursor.getString(12);
                    String open2 = cursor.getString(13);
                    String call = cursor.getString(14);
                    rname = "";
                    rtype = "";
                    radd = "";
                    radd2 = "";
                    ropen = "";
                    rwe = "";
                    rke = "";
                    rcount = "";
                    rbook = "";
                    rgiftcard = "";
                    rpage = "";
                    rtoilet = "";
                    rparking = "";
                    ropen2 = "";
                    rcall = "";
                    rname += name;
                    rtype += type;
                    radd += add;
                    radd2 += add2;
                    ropen += open;
                    rwe += we;
                    rke += ke;
                    rcount += count;
                    rbook += book;
                    rgiftcard += giftcard;
                    rpage += page;
                    rtoilet += toilet;
                    rparking += parking;
                    ropen2 += open2;
                    rcall += call;

                    cursor.close();
                    mHelper.close();
                }
            }
        });
    }
}


