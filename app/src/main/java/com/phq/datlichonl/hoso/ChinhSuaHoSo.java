package com.phq.datlichonl.hoso;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.Database.HoSoModify;
import com.phq.datlichonl.Database.LichKhamModify;
import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.LichKham;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Trunggian;
import com.phq.datlichonl.dangki.DangKiHoSo;

public class ChinhSuaHoSo extends AppCompatActivity {
    DatePickerDialog callDate;
    HoSo hoSo;
    HoSoModify hoSoModify = new HoSoModify(this);
    LichKhamModify lichKhamModify = new LichKhamModify(this);
    EditText ten , sdt, diachi  , bhyt ;
    TextView ngaysinh;
    String gioitinh ;
    RadioButton nam , nu ;
    Button luu ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinhsuahoso);
        getView();
        ngaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nam.isChecked()) gioitinh = "Nam";
                else  gioitinh = "Nữ";
                hoSo = new HoSo(Trunggian.id,ten.getText().toString(),sdt.getText().toString(),ngaysinh.getText().toString(),gioitinh,diachi.getText().toString(),bhyt.getText().toString());
                hoSoModify.onUpgrade(hoSo);
                lichKhamModify.onUpgrade(ten.getText().toString());
                Toast.makeText(ChinhSuaHoSo.this,"Sửa thành công!  ",Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(ChinhSuaHoSo.this,ThongtinTaiKhoan.class);
                startActivity(intent);
            }
        });
    }
    private  void getView(){
        ten = (EditText) findViewById(R.id.edTen);
        sdt = (EditText) findViewById(R.id.edSDT);
        diachi = (EditText) findViewById(R.id.edDiaChi);
        ngaysinh = (TextView) findViewById(R.id.edNgaySinh);
        bhyt = (EditText) findViewById(R.id.edBHYT);
        nam= (RadioButton) findViewById(R.id.rdNam);
        nu = (RadioButton) findViewById(R.id.rdNu);
        luu = findViewById(R.id.btnLuu);
        hoSoModify = new HoSoModify(this);
        HoSo hoSo = hoSoModify.getData(Trunggian.id);
        ten.setText(hoSo.getTen());
        ngaysinh.setText(hoSo.getNgaysinh());
        sdt.setText(hoSo.getSdt());
        diachi.setText(hoSo.getDiachi());
        bhyt.setText(hoSo.getBhyt());

    }
    String a , b;
    private void setDate(){
        final Calendar calendar = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH);
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        callDate = new DatePickerDialog(ChinhSuaHoSo.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                b = String.valueOf(day);
                a = String.valueOf(month+1);
                if(month<9) a = String.valueOf("0"+ (month+1));
                if(day<10) b = String.valueOf("0"+day);
                ngaysinh.setText(b +"/"+a+"/"+year);
            }
        },nam ,thang,ngay);
        callDate.show();
    }
}
