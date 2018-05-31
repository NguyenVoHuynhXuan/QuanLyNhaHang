package com.xuan.btandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xuan.btandroid.DTO.nhanvienDTO;
import com.xuan.btandroid.Database.database;

/**
 * Created by HP on 16-Apr-18.
 */

public class nhanvienDAO
{
    SQLiteDatabase sqLiteDatabase;
    public nhanvienDAO(Context context)
    {
         database da=new database(context);
         sqLiteDatabase=da.ketnoidatabase();
    }

    public boolean themnhanvien(nhanvienDTO nvdto)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.tbNhanVien_TenDN,nvdto.getTenDangNhap());
        contentValues.put(database.tbNhanVien_MatKhau,nvdto.getMatKhau());
        contentValues.put(database.tbNhanVien_NgaySinh,nvdto.getNgaySinh());
        contentValues.put(database.tbNhanVien_CMND,nvdto.getCMND());
        contentValues.put(database.tbNhanVien_GioiTinh,nvdto.getGioiTinh());
        long ktra=sqLiteDatabase.insert(database.tbNhanVien,null,contentValues);
        if(ktra!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public  boolean kiemtranhanvien(String tendangnhap,String matkhau)
    {
        String cautruyvan="select * from "+database.tbNhanVien+" where  "+database.tbNhanVien_TenDN
                +" = '"+tendangnhap +"' and "+database.tbNhanVien_MatKhau+" = '"+matkhau+"'";

        Cursor cursor=sqLiteDatabase.rawQuery(cautruyvan,null);
        if(cursor.getCount()!=0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
