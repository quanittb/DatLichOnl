package com.phq.datlichonl.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 7;
    public static final String DB_Name = "BTLon";

    public static final String tblLichKham ="tblLichKham";
    public static final String Lichkham_id ="iID";
    public static final String Lichkham_benhnhan ="sBenhnhan";
    public static final String Lichkham_tenbs ="sTen";
    public static final String Lichkham_khoa ="sKhoa";
    public static final String Lichkham_gio ="sGio";
    public static final String Lichkham_ngay ="sNgay";
    public static final String Lichkham_taikhoan ="sTaikhoan";

    public static final String tblHoSo  = "tblHoSo";
    public static final String Hoso_id = "sID";
    public static final String Hoso_ten ="sTen";
    public static final String Hoso_sdt = "sSDT";
    public static final String Hoso_ngaysinh = "sNgaysinh";
    public static final String Hoso_gioitinh = "sGioitinh";
    public static final String Hoso_diachi ="sDiachi";
    public static final String Hoso_bhyt ="sBHYT";

    public static final String tblBacSi = "tblBacSi";
    public static final String bacsi_id ="iId" ;
    public static final String bacsi_ten ="sTen" ;
    public static final String bacsi_khoa ="sKhoa" ;
    public static final String bacsi_thongtin ="sThongtin" ;

    public static final String tblTaiKhoan = "tblTaiKhoan";
    public static final  String TK_taikhoan= "sTaikhoan" ;
    public static final  String TK_matkhau= "sMatkhau" ;

    public DBHelper(@Nullable Context context) {
        super(context, DB_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_tblTaiKhoan = "CREATE TABLE " + tblTaiKhoan + "("
                + TK_taikhoan + " TEXT PRIMARY KEY,"
                + TK_matkhau + " TEXT )";
        String CREATE_TABLE_tblBacSi = "CREATE TABLE " + tblBacSi + "("
                + bacsi_id + " INTEGER PRIMARY KEY ,"
                + bacsi_ten+ " TEXT ,"
                + bacsi_khoa+ " TEXT,"
                +bacsi_thongtin+" TEXT )";
        String CREATE_TABLE_tblLichKham = "CREATE TABLE " + tblLichKham + "("
                + Lichkham_id + " INTEGER  ,"
                + Lichkham_benhnhan+ " TEXT ,"
                + Lichkham_tenbs+ " TEXT ,"
                + Lichkham_khoa+ " TEXT,"
                + Lichkham_ngay+ " TEXT,"
                + Lichkham_gio+ " TEXT,"
                +Lichkham_taikhoan+" TEXT )";

        String CREATE_TABLE_tblHoSo = "CREATE TABLE " + tblHoSo + "("
                + Hoso_id + " TEXT PRIMARY KEY ,"
                + Hoso_ten+ " TEXT ,"
                + Hoso_sdt+ " TEXT,"
                + Hoso_ngaysinh+ " TEXT,"
                + Hoso_gioitinh+ " TEXT,"
                + Hoso_diachi+ " TEXT,"
                +Hoso_bhyt+" TEXT )";
        sqLiteDatabase.execSQL(CREATE_TABLE_tblBacSi);
        sqLiteDatabase.execSQL(CREATE_TABLE_tblTaiKhoan);
        sqLiteDatabase.execSQL(CREATE_TABLE_tblLichKham);
        sqLiteDatabase.execSQL(CREATE_TABLE_tblHoSo);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tblTaiKhoan);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tblBacSi);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tblLichKham);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tblHoSo);
        onCreate(sqLiteDatabase);
    }


}
