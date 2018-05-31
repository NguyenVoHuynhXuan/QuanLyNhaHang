package com.xuan.btandroid.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;

import com.xuan.btandroid.CustomeAdapter.custome_adapter_hienthidanhsachmonan;
import com.xuan.btandroid.CustomeAdapter.custome_spinner_loaimonan;
import com.xuan.btandroid.DAO.loaimonanDAO;
import com.xuan.btandroid.DAO.monanDAO;
import com.xuan.btandroid.DTO.loaimonanDTO;
import com.xuan.btandroid.DTO.monanDTO;
import com.xuan.btandroid.DialogActivity.themloaimonan;
import com.xuan.btandroid.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 19-Apr-18.
 */

public class Fragment_thucdon extends Fragment
{
    monanDAO madao;
    Button btnthemloaimonan;
    Spinner sploaimonan;
    ListView lvhienthidanhsachmonan;
    loaimonanDAO lmadao;
    EditText edtgiatien,edttenmonan;
    Button btnthem,btnxoa,btnsua;
    int maloaimonan,mamonan;
    byte[] hinhanhmonan=null;
    List<loaimonanDTO> lstlmadto;
    List<loaimonanDTO> lstlmadto1;
    List<monanDTO> lstmadto;
    ImageView imghinhanhmonan;
    View row;
    custome_spinner_loaimonan adapter;
    custome_adapter_hienthidanhsachmonan adapterhienthidanhsachmonan;
    List<monanDTO>lstmadtohienthi;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.thucdon,container,false);
       //danh sach  mon an
        madao=new monanDAO(getActivity());
        lstmadto=new ArrayList<monanDTO>();
        lstmadto=madao.danhsachmonan();
        lmadao=new loaimonanDAO(getActivity());
        lstlmadto=new ArrayList<loaimonanDTO>();
        lstlmadto=lmadao.danhsachloaimonan();
        lstmadtohienthi=new ArrayList<monanDTO>();
        edtgiatien=(EditText)view.findViewById(R.id.edtgiatien);
        lvhienthidanhsachmonan=(ListView)view.findViewById(R.id.lvhienthimonan);
        edttenmonan=(EditText)view.findViewById(R.id.edttenmonan);
        btnthem=(Button)view.findViewById(R.id.btnthemmonan);
        imghinhanhmonan=(ImageView)view.findViewById(R.id.imghinhanhmonan);
        btnthemloaimonan=(Button)view.findViewById(R.id.btnthemloaimonan);
        btnxoa=(Button)view.findViewById(R.id.btnxoamonan);
        sploaimonan=(Spinner)view.findViewById(R.id.sploaimonan);
        adapterhienthidanhsachmonan =new custome_adapter_hienthidanhsachmonan(getActivity(),R.layout.custome_arrayadapter_hienthidanhsachmonan,lstmadto);
        lvhienthidanhsachmonan.setAdapter(adapterhienthidanhsachmonan);
        lvhienthidanhsachmonan.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                    if(row!=null)
                    {
                        row.setBackgroundResource(R.color.xam);
                    }
                    row=view;
                    view.setBackgroundResource(R.color.cam);
                monanDTO madto1= lstmadto.get(i);
                mamonan=madto1.getMaMonAn();
                edttenmonan.setText(madto1.getTenMonAn().toString());
                edtgiatien.setText(""+madto1.getGiaTien());

                monanDTO madto=lstmadto.get(i);

                for(loaimonanDTO lmadto:lstlmadto)
                {
                    if(lmadto.getMaLoaiMonAn()==madto.getMaLoaiMonAn())
                    {

                        //sploaimonan.setSelection();
                    }
                }



                if( !madto1.getHinhAnhMonAn().equals(""))
                {
                    byte[] duongdan=madto1.getHinhAnhMonAn();
                    imghinhanhmonan.setImageBitmap(hienthihinhanh(duongdan));
                }
                else if(madto1.getHinhAnhMonAn().equals(""))
                {
                    imghinhanhmonan.setImageResource(R.drawable.backgroundheader1);
                }
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //monanDTO madto2=new monanDTO();

                for(monanDTO madto3:lstmadto)
                {
                    if(madto3.getMaMonAn()==mamonan)
                    {
                        lstmadto.remove(madto3);
                        adapterhienthidanhsachmonan=new custome_adapter_hienthidanhsachmonan(getActivity(),R.layout.custome_arrayadapter_hienthidanhsachmonan,lstmadto);
                        lvhienthidanhsachmonan.setAdapter(adapterhienthidanhsachmonan);
                        adapterhienthidanhsachmonan.notifyDataSetChanged();

                    }
                }
                madao.xoamonan(mamonan);

            }
        });
        imghinhanhmonan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Chon hinh"),5);
            }
        });
        btnthemloaimonan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getActivity(), themloaimonan.class)  ;
                startActivityForResult(intent,3);
            }
        });

        adapter=new custome_spinner_loaimonan(getActivity(),R.layout.custome_spinner_loaimonan,lstlmadto);
        sploaimonan.setAdapter(adapter);
        sploaimonan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                loaimonanDTO lmadto=new loaimonanDTO();
                lmadto=lstlmadto.get(i);
                maloaimonan=lmadto.getMaLoaiMonAn();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tenmonan=edttenmonan.getText().toString();
                String giatien=edtgiatien.getText().toString();
                if(tenmonan.equals("")||tenmonan==null)
                {
                    Toast.makeText(getActivity(),"Bạn chưa nhập tên món ăn",Toast.LENGTH_SHORT).show();
                }
                else if(giatien.equals("")|| tenmonan==null)
                {
                    Toast.makeText(getActivity(),"Bạn chưa nhập giá tiền",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    monanDTO madto=new monanDTO();
                    madto.setTenMonAn(edttenmonan.getText().toString());
                    madto.setGiaTien(Double.parseDouble(edtgiatien.getText().toString()));
                    madto.setMaLoaiMonAn(maloaimonan);
                    madto.setHinhAnhMonAn(hinhanhmonan);
                    madao.themmonan(madto);
                    lstmadto.add(madto);
                    adapterhienthidanhsachmonan=new custome_adapter_hienthidanhsachmonan(getActivity(),R.layout.custome_arrayadapter_hienthidanhsachmonan,lstmadto);
                    lvhienthidanhsachmonan.setAdapter(adapterhienthidanhsachmonan);
                    adapterhienthidanhsachmonan.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==3)
        {
            if(resultCode==4)
            {
                loaimonanDAO lmadao1=new loaimonanDAO(getActivity());
                lstlmadto1=new ArrayList<loaimonanDTO>();
                lstlmadto1=lmadao1.danhsachloaimonan();
           custome_spinner_loaimonan adapter1=new custome_spinner_loaimonan(getActivity(),R.layout.custome_spinner_loaimonan,lstlmadto1);
                sploaimonan.setAdapter(adapter1);
                sploaimonan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
                    {
                        loaimonanDTO lmadto=new loaimonanDTO();
                        lmadto=lstlmadto1.get(i);
                        maloaimonan=lmadto.getMaLoaiMonAn();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView)
                    {
                    }
                });
            }
        }
        else if(requestCode==5)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                imghinhanhmonan.setImageURI(data.getData());
                Uri hinhanhuri=data.getData();
                try
                {
                    InputStream inputStream=getActivity().getContentResolver().openInputStream(hinhanhuri);
                    ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
                    int buffersize=1024;
                    byte[] buffer=new byte[buffersize];
                    int len=0;
                    try
                    {
                        while((len=inputStream.read(buffer))!=-1)
                        {
                            arrayOutputStream.write(buffer,0,len);
                        }
                        hinhanhmonan=arrayOutputStream.toByteArray();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public Bitmap hienthihinhanh(byte[] image)
    {
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }

}
