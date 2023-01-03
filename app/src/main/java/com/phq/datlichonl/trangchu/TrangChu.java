package com.phq.datlichonl.trangchu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.phq.datlichonl.Login;
import com.phq.datlichonl.datlich.DSBacSi;

import com.phq.datlichonl.R;
import com.phq.datlichonl.Them;
import com.phq.datlichonl.hoso.ThongtinTaiKhoan;
import com.phq.datlichonl.lichkham.DSLichKham;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class TrangChu extends AppCompatActivity {
    private ImageView imgDatlich , imgTuVan , imgTrangchu , imgLichKham , imgHoSo , imgTaiKhoan ;
    private LinearLayout layout1 , layout2 , layout3 ;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private  PhotoAdapter photoAdapter;
    private Timer timer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        circleIndicator = (CircleIndicator) findViewById(R.id.circle);
        photoAdapter = new PhotoAdapter(this,getListPhoto());
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        imgDatlich = (ImageView) findViewById(R.id.imgDatKham);
        imgTuVan = (ImageView) findViewById(R.id.imgTuVan);
        imgTrangchu = (ImageView) findViewById(R.id.imgtrangchu);
        imgLichKham = (ImageView) findViewById(R.id.imglichkham);
        imgHoSo = (ImageView) findViewById(R.id.imghoso);
        imgTaiKhoan = (ImageView) findViewById(R.id.imgtaikhoan);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        autoSlide();
    }

    public void datlich(View view){
        Intent intent = new Intent(this, DSBacSi.class);
        startActivity(intent);
    }
    public void tuvan (View view ){
        Uri uri = Uri.parse("tel:18008198");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    public void tintuc ( View view) {
        Uri uri = Uri.parse("https://moh.gov.vn/tin-noi-bat/-/asset_publisher/3Yst7YhbkA5j/content/bo-truong-bo-y-te-ty-le-bao-phu-vaccine-phong-covid-19-cua-viet-nam-ve-ich-som-hon-so-voi-muc-tieu-khuyen-cao-cua-who");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void lichkham(View view){
        Intent intent = new Intent(this, DSLichKham.class);
        startActivity(intent);

    }
    public void hoso(View view){
        Intent intent = new Intent(this, ThongtinTaiKhoan.class);
        startActivity(intent);

    }
    public void them(View view){
        finish();
        Intent intent = new Intent(this, Them.class);
        startActivity(intent);

    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        finish();
//        Toast.makeText(this,"Phiên làm việc đã hết hạn",Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, Login.class);
//        startActivity(intent);
//    }

    private List<com.phq.datlichonl.trangchu.Photo> getListPhoto(){
        List<com.phq.datlichonl.trangchu.Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.anh1));
        list.add(new Photo(R.drawable.anh2));
        list.add(new Photo(R.drawable.anh3));
        list.add(new Photo(R.drawable.anh1));
        list.add(new Photo(R.drawable.anh2));
        return  list;
    }
    private  void autoSlide(){
        if(photoAdapter==null || viewPager==null)
            return;
        // Khởi tạo timer
        if(timer==null)
            timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int item_hientai  = viewPager.getCurrentItem();
                        int tong_item = getListPhoto().size()-1;
                        if(item_hientai<tong_item){
                            item_hientai ++;
                            viewPager.setCurrentItem(item_hientai);
                        }
                        else viewPager.setCurrentItem(0);
                    }
                });
            }
        },1000,3000);
    }


}