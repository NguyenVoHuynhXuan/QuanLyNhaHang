package com.xuan.btandroid.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 16-Apr-18.
 */

public class database extends SQLiteOpenHelper
{
    public static String tbNhanVien="NhanVien";
    public static String tbNhanVien_MaNV="MaNhanVien";
    public static String tbNhanVien_TenDN="TenDangNhap";
    public static String tbNhanVien_MatKhau="MatKhau";
    public static String tbNhanVien_NgaySinh="NgaySinh";
    public static String tbNhanVien_GioiTinh="GioiTinh";
    public static String tbNhanVien_CMND="CMND";

    public static String tbMonAn="MonAn";
    public static String tbMonAn_MaMonAn="MaMonAn";
    public static String tbMonAn_TenMonAn="TenMonAn";
    public static String tbMonAn_GiaTien="GiaTien";
    public static String tbMonAn_MaLoaiMonAn="MaLoaiMonAn";
    public static String tbMonAn_HinhAnhMonAn="HinhAnhMonAn";

    public static String tbLoaiMonAn="LoaiMonAn";
    public static String tbLoaiMonAn_MaLoaiMonAn="MaLoaiMonAn";
    public static String tbLoaiMonAn_TenLoai="TenLoai";

    public static String tbBanAn="BanAn";
    public static String tbBanAn_MaBanAn="MaBanAn";
    public static String tbBanAn_TenBanAn="TenBanAn";
    public static String tbBanAn_TinhTrang="TinhTrang";

    public static String tbGoiMon="GoiMon";
    public static String tbGoiMon_MaGoiMon="MaGoiMon";
    public static String tbGoiMon_NgayGoiMon="NgayGoiMon";
    public static String tbGoiMon_TinhTrang="TinhTrang";
    public static String tbGoiMon_MaBanAn="MaBanAn";

    public static String tbChiTietGoiMon="ChitietGoiMon";
    public static String tbChiTietGoiMon_MaGoimon="MaGoiMon";
    public static String tbChiTietGoiMon_MaMonAn="MaMonAn";
    public static String tbChiTietGoiMon_SoLuong="SoLuong";

    public database(Context context)
    {
        super(context, "AppOrderFood", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String taobangNhanVien="Create table "+tbNhanVien+" ( "+tbNhanVien_MaNV +" integer primary key autoincrement "+" , "+tbNhanVien_TenDN
                +" text "+" , "+tbNhanVien_MatKhau+" text, "+tbNhanVien_NgaySinh+" text " + " , "+ tbNhanVien_GioiTinh +" text " +" , "+
                tbNhanVien_CMND+" text )";
        String taobangLoaiMonAn="Create table "+tbLoaiMonAn+" ( " +tbLoaiMonAn_MaLoaiMonAn+" integer primary key autoincrement " +" , "+
                tbLoaiMonAn_TenLoai+" text " +" ) ";
        String taobangMonAn="Create table " +tbMonAn+" ( "+tbMonAn_MaMonAn +" integer primary key autoincrement "+" , "+tbMonAn_TenMonAn +
                " text " +" , " + tbMonAn_GiaTien +" real " +" , " +tbMonAn_MaLoaiMonAn +" integer ," +tbMonAn_HinhAnhMonAn+" blob ,"+
                "foreign key ( "+ tbMonAn_MaLoaiMonAn +" )"+" references "+tbLoaiMonAn+" ( "+ tbLoaiMonAn_MaLoaiMonAn+" ) )";
        String taobangBanAn="create table "+tbBanAn+" ( "+tbBanAn_MaBanAn+" integer primary key autoincrement  ," +tbBanAn_TenBanAn+" text , "
                +tbBanAn_TinhTrang+" integer ) ";
        String taobangGoiMon="Create table "+tbGoiMon+" ( "+ tbGoiMon_MaGoiMon +" integer primary key autoincrement , "+tbGoiMon_NgayGoiMon +
                " text , " +tbGoiMon_TinhTrang+" text , "+tbGoiMon_MaBanAn +" integer , foreign key ( "+ tbGoiMon_MaBanAn
                + " ) references "+tbBanAn+" ( "+tbBanAn_MaBanAn+" ) )" ;
        String taobangChiTietGoiMon="Create table "+tbChiTietGoiMon+" ( "+tbChiTietGoiMon_MaGoimon+" integer ,"+tbChiTietGoiMon_MaMonAn
                +" integer , "+tbChiTietGoiMon_SoLuong+" integer , foreign key ("+tbChiTietGoiMon_MaGoimon+" ) references "+
                tbGoiMon+" ( "+tbGoiMon_MaGoiMon+" ) ,foreign key ("+tbChiTietGoiMon_MaMonAn+") references "+
                tbMonAn+" ( "+tbMonAn_MaMonAn+ " ) )";
        sqLiteDatabase.execSQL(taobangNhanVien);
        sqLiteDatabase.execSQL(taobangLoaiMonAn);
        sqLiteDatabase.execSQL(taobangMonAn);
        sqLiteDatabase.execSQL(taobangBanAn);
        sqLiteDatabase.execSQL(taobangGoiMon);
        sqLiteDatabase.execSQL(taobangChiTietGoiMon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public SQLiteDatabase ketnoidatabase()
    {


        return this.getWritableDatabase();
    }
}
