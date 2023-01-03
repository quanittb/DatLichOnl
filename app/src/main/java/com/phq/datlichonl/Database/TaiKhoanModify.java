package com.phq.datlichonl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phq.datlichonl.TaiKhoan;

public class TaiKhoanModify {
    private DBHelper dbHelper ;
    public TaiKhoanModify(Context context) {
        this.dbHelper = new DBHelper(context);
    }
    public void insert(TaiKhoan taiKhoan){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.TK_taikhoan,taiKhoan.getTaikhoan());
        values.put(DBHelper.TK_matkhau, taiKhoan.getMatkhau());
        db.insert(DBHelper.tblTaiKhoan,null,values);
        db.close();
    }
    public Cursor getAllData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.tblTaiKhoan,new String[]{DBHelper.TK_taikhoan,DBHelper.TK_matkhau},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public TaiKhoan getData(String taikhoan){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.tblTaiKhoan,new String[]{DBHelper.TK_taikhoan,DBHelper.TK_matkhau},DBHelper.TK_taikhoan +"=?",new String[]{String.valueOf(taikhoan)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new TaiKhoan(cursor.getString(0),cursor.getString(1));
    }
}
