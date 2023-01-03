package com.phq.datlichonl.hoso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.Database.HoSoModify;
import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Them;
import com.phq.datlichonl.Trunggian;
import com.phq.datlichonl.lichkham.DSLichKham;
import com.phq.datlichonl.trangchu.TrangChu;

public class ThongtinTaiKhoan extends AppCompatActivity {
    HoSoModify hoSoModify;
    TextView ten , ngaysinh , sdt , gioitinh , diachi ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoso);
        ten = findViewById(R.id.tvTen);

        ngaysinh = findViewById(R.id.tvNgaySinh);
        sdt = findViewById(R.id.tvSDT);
        gioitinh = findViewById(R.id.tvGioiTinh);
        diachi = findViewById(R.id.tvDiaChi);
        hoSoModify = new HoSoModify(this);

        HoSo hoSo = hoSoModify.getData(Trunggian.id);
        ten.setText(hoSo.getTen());
        ngaysinh.setText(hoSo.getNgaysinh());
        sdt.setText(hoSo.getSdt());
        gioitinh.setText(hoSo.getGioitinh());
        diachi.setText(hoSo.getDiachi());
    }
    public void chinhsua(View view){
        Intent intent = new Intent(this, ChinhSuaHoSo.class);
        startActivity(intent);
        finish();
    }
    public void lichkham(View view){
        finish();
        Intent intent = new Intent(this, DSLichKham.class);
        startActivity(intent);
    }
    public void them(View view){
        finish();
        Intent intent = new Intent(this, Them.class);
        startActivity(intent);

    }
    public void trangchu(View view){
        finish();
        Intent intent = new Intent(this, TrangChu.class);
        startActivity(intent);

    }
}
