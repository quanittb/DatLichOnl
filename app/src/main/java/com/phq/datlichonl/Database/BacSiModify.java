package com.phq.datlichonl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phq.datlichonl.BacSi;

public class BacSiModify  {
    private DBHelper dbHelper;
    public BacSiModify(Context context) { this.dbHelper = new DBHelper(context); }
    public void insert(BacSi bacSi){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.bacsi_id, bacSi.getId());
        values.put(DBHelper.bacsi_ten, bacSi.getTen());
        values.put(DBHelper.bacsi_khoa, bacSi.getKhoa());
        values.put(DBHelper.bacsi_thongtin, bacSi.getThongtin());
        db.insert(DBHelper.tblBacSi,null,values);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.tblBacSi,DBHelper.bacsi_id + "=?" ,new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(BacSi bacSi){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.bacsi_id, bacSi.getId());
        values.put(DBHelper.bacsi_ten, bacSi.getTen());
        values.put(DBHelper.bacsi_khoa, bacSi.getKhoa());
        values.put(DBHelper.bacsi_thongtin, bacSi.getThongtin());
        db.update(DBHelper.tblBacSi,values,DBHelper.bacsi_id + "=?" ,new String[]{String.valueOf(bacSi.getId())});
    }

    public Cursor getAllData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.tblBacSi,new String[]{DBHelper.bacsi_id,DBHelper.bacsi_ten,DBHelper.bacsi_khoa,DBHelper.bacsi_thongtin},null,null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public BacSi getData(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.tblBacSi,new String[]{DBHelper.bacsi_id,DBHelper.bacsi_ten,DBHelper.bacsi_khoa,DBHelper.bacsi_thongtin},DBHelper.bacsi_id+"=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new BacSi(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3));
    }
}
