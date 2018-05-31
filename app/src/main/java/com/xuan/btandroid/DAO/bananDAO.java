package com.xuan.btandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xuan.btandroid.DTO.bananDTO;
import com.xuan.btandroid.DTO.nhanvienDTO;
import com.xuan.btandroid.Database.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 18-Apr-18.
 */

public class bananDAO
{
    List<bananDTO> lstbanan=new ArrayList<bananDTO>();
    SQLiteDatabase sqLiteDatabase;
    public bananDAO(Context context)
    {
        database da=new database(context);
        sqLiteDatabase=da.ketnoidatabase();
    }
    public void thembanan(bananDTO badto)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.tbBanAn_TenBanAn,badto.getTenBanAn());
        contentValues.put(database.tbBanAn_TinhTrang,badto.getTinhTrang());
        sqLiteDatabase.insert(database.tbBanAn,null,contentValues);
    }
    public List<bananDTO> hienthidanhsachbanan()
    {
        String cautruyvan="select * from "+database.tbBanAn;
        Cursor cursor=sqLiteDatabase.rawQuery(cautruyvan,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            bananDTO badto=new bananDTO();
            badto.setMaBanAn(cursor.getInt(cursor.getColumnIndex(database.tbBanAn_MaBanAn)));
            badto.setTenBanAn(cursor.getString(cursor.getColumnIndex(database.tbBanAn_TenBanAn)));
            badto.setTinhTrang(cursor.getInt(cursor.getColumnIndex(database.tbBanAn_TinhTrang)));
            lstbanan.add(badto);
            cursor.moveToNext();
        }
        return lstbanan;
    }
    public void capnhattinhtrangbanan(int mabanan,int tinhtrang)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.tbBanAn_TinhTrang,tinhtrang);
        sqLiteDatabase.update(database.tbBanAn,contentValues,""+database.tbBanAn_MaBanAn+" = "+mabanan,null);
    }
    public void xoabanan(int mabanan)
    {
        sqLiteDatabase.delete(database.tbBanAn,database.tbBanAn_MaBanAn+" = "+mabanan,null);
    }
}
