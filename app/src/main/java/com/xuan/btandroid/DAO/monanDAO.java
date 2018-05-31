package com.xuan.btandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xuan.btandroid.DTO.monanDTO;
import com.xuan.btandroid.Database.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 19-Apr-18.
 */

public class monanDAO
{
    SQLiteDatabase sqLiteDatabase;
    List<monanDTO> lstmadto=new ArrayList<monanDTO>();
    public monanDAO(Context context)
    {
        database da=new database(context);
        sqLiteDatabase=da.ketnoidatabase();
    }
    public boolean themmonan(monanDTO madto)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.tbMonAn_TenMonAn,madto.getTenMonAn());
        contentValues.put(database.tbMonAn_GiaTien,madto.getGiaTien());
        contentValues.put(database.tbMonAn_MaLoaiMonAn,madto.getMaLoaiMonAn());
        contentValues.put(database.tbMonAn_HinhAnhMonAn,madto.getHinhAnhMonAn());
       long ktra= sqLiteDatabase.insert(database.tbMonAn,null,contentValues);
       if (ktra!=0)
       {
           return true;
       }
       else
       {
           return false;
       }
    }
    public List<monanDTO> danhsachmonan()
    {
        String truyvan="select * from "+database.tbMonAn;
        Cursor cursor= sqLiteDatabase.rawQuery(truyvan,null);
       cursor.moveToFirst();
       while(!cursor.isAfterLast())
       {
           monanDTO madto=new monanDTO();
           madto.setMaMonAn(cursor.getInt(cursor.getColumnIndex(database.tbMonAn_MaMonAn)));
           madto.setTenMonAn(cursor.getString(cursor.getColumnIndex(database.tbMonAn_TenMonAn)));
           madto.setGiaTien(cursor.getDouble(cursor.getColumnIndex(database.tbMonAn_GiaTien)));
      madto.setHinhAnhMonAn(cursor.getBlob(cursor.getColumnIndex(database.tbMonAn_HinhAnhMonAn)));
           lstmadto.add(madto);
           cursor.moveToNext();
       }
       return  lstmadto;

    }
    public String tenloaimonan(int maloaimonan)
    {
        String tenloaimonan="";
        String truyvan="select "+database.tbLoaiMonAn_TenLoai+" from " +database.tbLoaiMonAn+" where " +database.tbLoaiMonAn_MaLoaiMonAn
                +" = "+maloaimonan;
        Cursor cursor= sqLiteDatabase.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            tenloaimonan=cursor.getString(cursor.getColumnIndex(database.tbLoaiMonAn_TenLoai));
            cursor.moveToNext();
        }
        return tenloaimonan;

    }
    public void xoamonan(int mamonan)
    {
        sqLiteDatabase.delete(database.tbMonAn,database.tbMonAn_MaMonAn+" = "+mamonan,null);

    }
}
