package com.phq.datlichonl.dangki;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.Database.TaiKhoanModify;
import com.phq.datlichonl.R;
import com.phq.datlichonl.TaiKhoan;

public class Dangki extends AppCompatActivity  {
    EditText edTaiKhoan , edMatKhau , edReMK;
    Button btndangki ;
    TextView tvthongbao ;
    TaiKhoanModify taiKhoanModify =new TaiKhoanModify(Dangki.this);;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangki);
        edTaiKhoan = (EditText) findViewById(R.id.txtTK);
        edMatKhau = (EditText) findViewById(R.id.txtMK);
        edReMK = (EditText) findViewById(R.id.txtReMK);
        btndangki = (Button) findViewById(R.id.btndangky);
        tvthongbao = findViewById(R.id.tvthongbao);
        edTaiKhoan.requestFocus();

    }
    public void dangki (View view){

        if(edMatKhau.getText().toString().trim().equals("")||edTaiKhoan.getText().toString().trim().equals("") )
        {
            tvthongbao.setText("Tài khoản và mật khẩu không đươc để trống!");
            return;
        }
        if(edMatKhau.getText().toString().equals(edTaiKhoan.getText().toString()))
        {
            tvthongbao.setText("Tài khoản và mật khẩu không được trùng!");
            return;
        }
        if(!edMatKhau.getText().toString().equals(edReMK.getText().toString()) ){
            tvthongbao.setText("Mật khẩu không khớp!");
            edReMK.setText("");
            edReMK.requestFocus();
            return;
        }
        Cursor cursor = taiKhoanModify.getAllData();
        if(cursor != null){
            while (!cursor.isAfterLast()){
                if(cursor.getString(0).equals(edTaiKhoan.getText().toString())){
                    tvthongbao.setText("Tài khoản đã tồn tại!");
                    edTaiKhoan.setText("");
                    edMatKhau.setText("");
                    edReMK.setText("");
                    edTaiKhoan.requestFocus();
                    return;
                }
                cursor.moveToNext();
            }
        }
        TaiKhoan taiKhoan= new TaiKhoan(edTaiKhoan.getText().toString(),edMatKhau.getText().toString());
        taiKhoanModify.insert(taiKhoan);
        Toast.makeText(this,"Đăng kí thành công!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DangKiHoSo.class);
        intent.putExtra("id",edTaiKhoan.getText().toString());
        startActivity(intent);
        finish();
        return;

    }

}
