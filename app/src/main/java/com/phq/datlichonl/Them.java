package com.phq.datlichonl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.phq.datlichonl.hoso.ThongtinTaiKhoan;
import com.phq.datlichonl.lichkham.DSLichKham;
import com.phq.datlichonl.trangchu.TrangChu;

import java.util.Date;

public class Them extends AppCompatActivity {
    WebView webView ;
    private LinearLayout congdong ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them);
        congdong = (LinearLayout)  findViewById(R.id.congdong);
    }
    public  void congdong (View view ){
        Uri uri = Uri.parse("https://www.facebook.com/QuanITTB/");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public  void datlich (View view ){
//        setContentView(R.layout.a);
//        webView = findViewById(R.id.web);
//        webView.loadUrl("https://phongkhamphapanh.com/quy-trinh-dang-ky-kham-online/");
//        webView.getSettings().setJavaScriptEnabled(true);
        Uri uri = Uri.parse("http://phongkhamphukhoahn.vn/phong-kham-phu-khoa-xa-dan-lot-top-10-dia-chi-chua-benh-phu-khoa-uy-tin-nhat-tai-ha-noi/?b1pkcampaignid=16232732822&adgroupid=132145569766&feeditemid=&targetid=kwd-298247747726&loc_physical_ms=1028580&device=c&devicemodel=&creative=582263116933&adposition=&matchtype=b&network=g&mtk=search&gclid=Cj0KCQjw29CRBhCUARIsAOboZbJ4kQKCUFyC8WLQlciU4z3sMhA_N5dOjjDOhMxBY-ep924gAwceh4UaAgtmEALw_wcB");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void dangxuat(View view ){
        Intent intent = new Intent(this,Login.class);

        startActivity(intent);
        Toast.makeText(this,"Đã đăng xuất!" ,Toast.LENGTH_SHORT).show();
        finish();


    }
    public void trangchu(View view){
        finish();
        Intent intent = new Intent(this, TrangChu.class);
        startActivity(intent);
    }
    public void lichkham(View view){
        finish();
        Intent intent = new Intent(this, DSLichKham.class);
        startActivity(intent);
    }
    public void hoso(View view){
        finish();
        Intent intent = new Intent(this, ThongtinTaiKhoan.class);
        startActivity(intent);
    }
}
