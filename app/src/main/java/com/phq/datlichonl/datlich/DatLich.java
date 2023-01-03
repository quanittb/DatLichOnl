package com.phq.datlichonl.datlich;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.BacSi;
import com.phq.datlichonl.Database.BacSiModify;
import com.phq.datlichonl.Database.HoSoModify;
import com.phq.datlichonl.Database.LichKhamModify;
import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.LichKham;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Trunggian;
import com.phq.datlichonl.trangchu.TrangChu;

public class DatLich extends AppCompatActivity  {
    TimePickerDialog calltime ;
    DatePickerDialog callDate ;
    TextView tvtime , tvdate , tenbs;
    Button btnDat;
    BacSiModify bacSiModify= new BacSiModify(this);
    LichKhamModify lichKhamModify = new LichKhamModify(this);
    HoSoModify hoSoModify = new HoSoModify(this);
    HoSo hoSo ;
    int checkngay , checkgio ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datlich);
        getView();
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        BacSi bacSi = bacSiModify.getData(id);
        tenbs.setText(bacSi.getTen());
        hoSo= hoSoModify.getData(Trunggian.id);
        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LichKham lichKham = new LichKham(bacSi.getId(),hoSo.getTen(),bacSi.getTen(),bacSi.getKhoa(),tvdate.getText().toString(),tvtime.getText().toString(),Trunggian.id);
                lichKhamModify.insert(lichKham);
                Toast.makeText(DatLich.this,"Đặt thành công!",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(DatLich.this, TrangChu.class);
                startActivity(intent1);
                finish();
            }
        });
        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime();
            }
        });
    }
        private void getView(){
            tvdate = findViewById(R.id.tvDate);
            tvtime = findViewById(R.id.tvTime);
            btnDat = findViewById(R.id.btnDatLich);
            tenbs = (TextView) findViewById(R.id.tenBS);
        }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        btnDat.setClickable(false);
//        btnDat.setAlpha(0.2f);
//    }

    String a , b;
        private void setDate(){
            final Calendar calendar = Calendar.getInstance();
            int nam = calendar.get(Calendar.YEAR);
            int thang = calendar.get(Calendar.MONTH);
            int ngay = calendar.get(Calendar.DAY_OF_MONTH);
            callDate = new DatePickerDialog(DatLich.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    b = String.valueOf(day);
                    a = String.valueOf(month+1);
//                    if(checkgio==0){
//                        if(month<9) a = String.valueOf("0"+ (month+1));
//                        if(day<10) b = String.valueOf("0"+day);
//                        tvdate.setText(b +"/"+a+"/"+year);
//                        return;
//                    }
//
//                    if((day>=ngay&&month>=thang &&year>=nam)) {
//                        btnDat.setClickable(true);
//                        btnDat.setAlpha(1);
//                        checkngay = 1;
//                    }
//                    else {
//                        btnDat.setClickable(false);
//                        btnDat.setAlpha(0.2f);
//                        checkngay = 0;
//                    }
                    if(month<9) a = String.valueOf("0"+ (month+1));
                    if(day<10) b = String.valueOf("0"+day);
                    tvdate.setText(b +"/"+a+"/"+year);
                 }
            },nam ,thang,ngay);
            callDate.show();
        }
        private void setTime(){
            Calendar calendar = Calendar.getInstance();
            int phut = calendar.get(Calendar.MINUTE);
            int gio = calendar.get(Calendar.HOUR_OF_DAY);
            calltime = new TimePickerDialog(DatLich.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    a =String.valueOf(hour);
                    b = String.valueOf(minute);
//                    if((hour<8) || hour==12|| hour>=17){
//                        btnDat.setClickable(false);
//                        btnDat.setAlpha(0.2f);
//                        checkgio =0;
//                    }else checkgio =1;
//                    if(checkgio==1&& checkngay==1){
//                        btnDat.setClickable(true);
//                        btnDat.setAlpha(1);
//                    }
                    if(hour<10) a ="0"+hour;
                    if(minute<10) b ="0"+minute;
                    tvtime.setText(a+":"+b);
                }
            },gio,phut,true);
            calltime.show();
        }
}
