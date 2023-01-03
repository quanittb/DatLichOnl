package com.phq.datlichonl.dangki;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.Database.HoSoModify;
import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.Login;
import com.phq.datlichonl.R;
import com.phq.datlichonl.Trunggian;

public class DangKiHoSo extends AppCompatActivity {
    int i =1;
    DatePickerDialog callDate;
    HoSo hoSo;
    HoSoModify hoSoModify = new HoSoModify(this);
    EditText ten , sdt, diachi  , bhyt ;
    TextView ngaysinh;
    String gioitinh ;
    RadioButton nam , nu ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangkihoso);
        getView();
        ngaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDate();
            }
        });
    }
    private  void getView(){
        ten = (EditText) findViewById(R.id.edten);
        sdt = (EditText) findViewById(R.id.edsdt);
        diachi = (EditText) findViewById(R.id.eddiachi);
        ngaysinh = (TextView) findViewById(R.id.edngaysinh);
        bhyt = (EditText) findViewById(R.id.edbhyt);
        nam= (RadioButton) findViewById(R.id.rdnam);
        nu = (RadioButton) findViewById(R.id.rdnu);
        Intent intent = getIntent();
        Trunggian.id = intent.getStringExtra("id");;

    }
    String a , b;
    private void setDate(){
        final Calendar calendar = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH);
        int ngay = calendar.get(Calendar.DAY_OF_MONTH);
        callDate = new DatePickerDialog(DangKiHoSo.this, new DatePickerDialog.OnDateSetListener() {
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
    public  void dangki(View view){
        if(nam.isChecked()) gioitinh="Nam";
        else
            gioitinh="Nữ";
        hoSo = new HoSo(Trunggian.id,ten.getText().toString(),sdt.getText().toString(),ngaysinh.getText().toString(),gioitinh,diachi.getText().toString(),bhyt.getText().toString());
        hoSoModify.insert(hoSo);
            //HoSo hs = new HoSo(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            //Toast.makeText(this,"Tên :"+hs.id,Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Tên :"+hs.getTen(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"SĐT :"+hs.getSdt(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Ngày sinh :"+hs.getNgaysinh(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Giới tính :"+hs.getGioitinh(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Địa chỉ :"+hs.getDiachi(),Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"BHYT :"+hs.getBhyt(),Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Hoàn tất đăng kí",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
