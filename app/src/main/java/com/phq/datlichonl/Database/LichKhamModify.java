package com.phq.datlichonl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.LichKham;
import com.phq.datlichonl.Trunggian;

public class LichKhamModify {
    private DBHelper dbHelper ;
    public LichKhamModify(Context context) {
        this.dbHelper = new DBHelper(context);
    }
    public void insert(LichKham lichKham){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.Lichkham_id,lichKham.getId());
        values.put(DBHelper.Lichkham_benhnhan, lichKham.getTenbenhnhan());
        values.put(DBHelper.Lichkham_tenbs, lichKham.getTenbs());
        values.put(DBHelper.Lichkham_khoa,lichKham.getKhoa());
        values.put(DBHelper.Lichkham_ngay,lichKham.getNgay());
        values.put(DBHelper.Lichkham_gio,lichKham.getGio());
        values.put(DBHelper.Lichkham_taikhoan,lichKham.getTaikhoan());
        db.insert(DBHelper.tblLichKham,null,values);
        db.close();
    }
    public void delete(String taikhoan , String ngaygio , String bacsi){
        String [] mangtg = ngaygio.split("-");
        String gio = mangtg[0].toString().trim();
        String ngay = mangtg[1].toString().trim();
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.delete(DBHelper.tblLichKham,DBHelper.Lichkham_taikhoan +"=? AND "+DBHelper.Lichkham_gio+"=? AND "+DBHelper.Lichkham_ngay +"=? AND "+DBHelper.Lichkham_tenbs+"=?",new String[]{taikhoan,gio,ngay,bacsi});
    }
    public Cursor getAllData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.tblLichKham,new String[]{DBHelper.Lichkham_id,DBHelper.Lichkham_benhnhan,DBHelper.Lichkham_tenbs,DBHelper.Lichkham_khoa,DBHelper.Lichkham_ngay,DBHelper.Lichkham_gio,DBHelper.Lichkham_taikhoan},DBHelper.Lichkham_taikhoan +"=?",new String[]{String.valueOf(Trunggian.id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor getDataKhoa(String tenkhoa){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.tblLichKham,new String[]{DBHelper.Lichkham_id,DBHelper.Lichkham_benhnhan,DBHelper.Lichkham_tenbs,DBHelper.Lichkham_khoa,DBHelper.Lichkham_ngay,DBHelper.Lichkham_gio,DBHelper.Lichkham_taikhoan},DBHelper.Lichkham_taikhoan +"=? AND "+DBHelper.Lichkham_khoa+"=?" ,new String[]{Trunggian.id,tenkhoa},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public LichKham getData(String taikhoan){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.tblLichKham,new String[]{DBHelper.Lichkham_id,DBHelper.Lichkham_benhnhan,DBHelper.Lichkham_tenbs,DBHelper.Lichkham_khoa,DBHelper.Lichkham_ngay,DBHelper.Lichkham_gio,DBHelper.Lichkham_taikhoan},DBHelper.Lichkham_taikhoan +"=?",new String[]{String.valueOf(taikhoan)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new LichKham(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5), cursor.getString(6));
    }
    public void onUpgrade(String ten){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.Lichkham_benhnhan,ten);
        db.update(DBHelper.tblLichKham,values,DBHelper.Lichkham_taikhoan +"=?",new String[]{Trunggian.id});
        db.close();
    }
}
