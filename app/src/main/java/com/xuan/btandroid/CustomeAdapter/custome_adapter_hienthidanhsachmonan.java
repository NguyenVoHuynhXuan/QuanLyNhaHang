package com.xuan.btandroid.CustomeAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.xuan.btandroid.DAO.loaimonanDAO;
import com.xuan.btandroid.DAO.monanDAO;
import com.xuan.btandroid.DTO.monanDTO;
import com.xuan.btandroid.R;

import java.util.List;

/**
 * Created by HP on 21-Apr-18.
 */

public class custome_adapter_hienthidanhsachmonan extends ArrayAdapter<monanDTO>
{
    Context thamso1;
    int thamso2;
    List<monanDTO> thamso3;
    monanDAO madao;

    public custome_adapter_hienthidanhsachmonan(@NonNull Context context, int resource, @NonNull List<monanDTO> objects)
    {
        super(context, resource, objects);
        thamso1=context;
        thamso2=resource;
        thamso3=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater=((Activity)thamso1).getLayoutInflater();
        View view= inflater.inflate(thamso2,parent,false);
        madao=new monanDAO(getContext());
        TextView tvtenmonan=(TextView)view.findViewById(R.id.tvtenmonan);
        TextView tvgiatien=(TextView)view.findViewById(R.id.tvgiatien);
        TextView tvtenloaimonan=(TextView)view.findViewById(R.id.tvloaimonan);
        tvtenmonan.setText(thamso3.get(position).getTenMonAn().toString());
        tvgiatien.setText(""+thamso3.get(position).getGiaTien());
        String tenloaimonan=madao.tenloaimonan(thamso3.get(position).getMaLoaiMonAn());
        tvtenloaimonan.setText(tenloaimonan);
        return view;
    }
}
