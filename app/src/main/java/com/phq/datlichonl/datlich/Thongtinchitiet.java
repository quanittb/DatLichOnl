package com.phq.datlichonl.datlich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.BacSi;
import com.phq.datlichonl.Database.BacSiModify;
import com.phq.datlichonl.R;

public class Thongtinchitiet extends AppCompatActivity {
    TextView txtThongtin , txtTen;
    Button btndatkham;
    BacSiModify bacSiModify = new BacSiModify(this);
    BacSi bacSi ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtinbacsi);
        txtThongtin = findViewById(R.id.txtThongtin);
        txtTen = findViewById(R.id.txtTen);
        btndatkham = findViewById(R.id.btndatkham);
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        bacSi = bacSiModify.getData(id);
        txtThongtin.setText(bacSi.getThongtin());
        txtTen.setText(bacSi.getTen());
        btndatkham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(Thongtinchitiet.this,DatLich.class);
                intent1.putExtra("id",String.valueOf(intent.getStringExtra("id")));
                startActivity(intent1);
                finish();
            }
        });

    }
}
