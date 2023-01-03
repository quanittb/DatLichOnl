package com.phq.datlichonl.lichkham;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.Database.HoSoModify;
import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.LichKham;
import com.phq.datlichonl.Database.LichKhamModify;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Them;
import com.phq.datlichonl.Trunggian;
import com.phq.datlichonl.hoso.ThongtinTaiKhoan;
import com.phq.datlichonl.trangchu.TrangChu;

import java.util.ArrayList;

public class DSLichKham extends AppCompatActivity {
    LichKhamAdapter lichKhamAdapter;
    LichKhamModify lichKhamModify = new LichKhamModify(this); ;
    ListView listView;
    ArrayList<LichKham> list;
    Button btnLoc ;
    RadioButton rbtPhusan , rbtHoisuc;
    String tenkhoa ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lichkham);
        listView = findViewById(R.id.listLichKham);
        list = new ArrayList<>();
        //HoSoModify hoSoModify = new HoSoModify(this);
        //HoSo hoSo = hoSoModify.getData(Trunggian.id);
        Cursor cursor = lichKhamModify.getAllData();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LichKham lichKham = new LichKham(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5) ,cursor.getString(6) );
            //if(lichKham.getTenbenhnhan().equals(hoSo.getTen()))
                list.add(lichKham);
            cursor.moveToNext();
        }
        lichKhamAdapter = new LichKhamAdapter(this,list);
        listView.setAdapter(lichKhamAdapter);
    }
    public void trangchu(View view){
        finish();
        Intent intent = new Intent(this, TrangChu.class);
        startActivity(intent);
    }
    public void hoso(View view){
        finish();
        Intent intent = new Intent(this, ThongtinTaiKhoan.class);
        startActivity(intent);
    }
    public void them(View view){
        finish();
        Intent intent = new Intent(this, Them.class);
        startActivity(intent);

    }
}
