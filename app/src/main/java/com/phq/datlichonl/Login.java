package com.phq.datlichonl;

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

import com.phq.datlichonl.dangki.Dangki;
import com.phq.datlichonl.Database.TaiKhoanModify;
import com.phq.datlichonl.trangchu.TrangChu;

public class Login extends AppCompatActivity {
    Button btndangnhap ;
    EditText edTaiKhoan , edMatKhau ;
    TextView txtDangKi;
    TaiKhoanModify taiKhoanModify=new TaiKhoanModify(Login.this); ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        btndangnhap = findViewById(R.id.btnDangnhap);
        edTaiKhoan = (EditText) findViewById(R.id.txtTaiKhoan);
        edMatKhau = (EditText) findViewById(R.id.txtMatKhau);
        txtDangKi = (TextView) findViewById(R.id.tvDangki);
        edTaiKhoan.setText(Trunggian.id);
    }
    public void dangki(View view){
        Intent intent= new Intent(this, Dangki.class);

        startActivity(intent);

    }
    public void dangnhap(View view){
        Cursor cursor = taiKhoanModify.getAllData();
        if(cursor==null) {
            Toast.makeText(this,"Đăng nhập thất bạii!",Toast.LENGTH_SHORT).show();
            return;
        }
        while(!cursor.isAfterLast()){
            if(cursor.getString(0).equals(edTaiKhoan.getText().toString())){
                if(taiKhoanModify.getData(edTaiKhoan.getText().toString()).getMatkhau().equals(edMatKhau.getText().toString())){
                    Toast.makeText(this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                    Trunggian.id= edTaiKhoan.getText().toString();
                    finish();
                    Intent intent= new Intent(this, TrangChu.class);
                    startActivity(intent);
                    return;
                }
                else {
                    Toast.makeText(this,"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            cursor.moveToNext();
        }
        Toast.makeText(this,"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();

    }
}
