package com.xuan.btandroid.DTO;

/**
 * Created by HP on 19-Apr-18.
 */

public class monanDTO
{
    private int MaMonAn;


    private String TenMonAn;
    private double GiaTien;
    private int MaLoaiMonAn;

    public byte[] getHinhAnhMonAn()
    {
        return HinhAnhMonAn;
    }

    public void setHinhAnhMonAn(byte[] hinhAnhMonAn)
    {
        HinhAnhMonAn = hinhAnhMonAn;
    }

    private byte[] HinhAnhMonAn;









    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        TenMonAn = tenMonAn;
    }


    public int getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        MaMonAn = maMonAn;
    }



    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double giaTien) {
        GiaTien = giaTien;
    }

    public int getMaLoaiMonAn() {
        return MaLoaiMonAn;
    }

    public void setMaLoaiMonAn(int maLoaiMonAn) {
        MaLoaiMonAn = maLoaiMonAn;
    }

}
