package com.phq.datlichonl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phq.datlichonl.HoSo;
import com.phq.datlichonl.Trunggian;

public class HoSoModify {
    private DBHelper dbHelper ;
    public HoSoModify(Context context) {
        this.dbHelper = new DBHelper(context);
    }
    public void insert(HoSo hoSo){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.Hoso_id,hoSo.id);
        values.put(DBHelper.Hoso_ten, hoSo.getTen());
        values.put(DBHelper.Hoso_sdt,hoSo.getSdt());
        values.put(DBHelper.Hoso_gioitinh,hoSo.getGioitinh());
        values.put(DBHelper.Hoso_ngaysinh,hoSo.getNgaysinh());

        values.put(DBHelper.Hoso_diachi,hoSo.getDiachi());
        values.put(DBHelper.Hoso_bhyt,hoSo.getBhyt());
        db.insert(DBHelper.tblHoSo,null,values);
        db.close();
    }
    public Cursor getAllData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.tblHoSo,new String[]{DBHelper.Hoso_id,DBHelper.Hoso_ten,DBHelper.Hoso_sdt,DBHelper.Hoso_ngaysinh,DBHelper.Hoso_gioitinh,DBHelper.Hoso_diachi,DBHelper.Hoso_bhyt},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public HoSo getData(String id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.tblHoSo,new String[]{DBHelper.Hoso_id,DBHelper.Hoso_ten,DBHelper.Hoso_sdt,DBHelper.Hoso_ngaysinh,DBHelper.Hoso_gioitinh,DBHelper.Hoso_diachi,DBHelper.Hoso_bhyt},DBHelper.Hoso_id +"=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new HoSo(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
    }
    public void onUpgrade(HoSo hoSo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.Hoso_id, Trunggian.id);
        values.put(DBHelper.Hoso_ten, hoSo.getTen());
        values.put(DBHelper.Hoso_gioitinh,hoSo.getGioitinh());
        values.put(DBHelper.Hoso_ngaysinh,hoSo.getNgaysinh());
        values.put(DBHelper.Hoso_sdt,hoSo.getSdt());
        values.put(DBHelper.Hoso_diachi,hoSo.getDiachi());
        values.put(DBHelper.Hoso_bhyt,hoSo.getBhyt());
        db.update(DBHelper.tblHoSo,values,DBHelper.Hoso_id +"=?",new String[]{String.valueOf(hoSo.id)});
        db.close();
    }
}
