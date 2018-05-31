package com.xuan.btandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xuan.btandroid.DTO.loaimonanDTO;
import com.xuan.btandroid.Database.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 19-Apr-18.
 */

public class loaimonanDAO {
    SQLiteDatabase sqLiteDatabase;
    List<loaimonanDTO> lstloaimonan=new ArrayList<loaimonanDTO>();

    public loaimonanDAO(Context context) {
        database da = new database(context);
        sqLiteDatabase = da.ketnoidatabase();
    }

    public boolean themloaimonan(loaimonanDTO lmadto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(database.tbLoaiMonAn_TenLoai, lmadto.getTenLoaiMonAn());
        long ktra = sqLiteDatabase.insert(database.tbLoaiMonAn, null, contentValues);
        if (ktra != 0) {
            return true;
        } else {
            return false;
        }
    }
    public List<loaimonanDTO> danhsachloaimonan()
    {
        String truyvan = "select * from " + database.tbLoaiMonAn;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            loaimonanDTO lmadto = new loaimonanDTO();
            lmadto.setMaLoaiMonAn(cursor.getInt(cursor.getColumnIndex(database.tbLoaiMonAn_MaLoaiMonAn)));
            lmadto.setTenLoaiMonAn(cursor.getString(cursor.getColumnIndex(database.tbLoaiMonAn_TenLoai)));
            lstloaimonan.add(lmadto);
            cursor.moveToNext();
        }
        return lstloaimonan;
    }


}
