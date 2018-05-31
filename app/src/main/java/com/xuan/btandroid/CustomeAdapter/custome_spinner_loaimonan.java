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

import com.xuan.btandroid.DTO.loaimonanDTO;
import com.xuan.btandroid.R;

import java.util.List;

/**
 * Created by HP on 19-Apr-18.
 */

public class custome_spinner_loaimonan extends ArrayAdapter<loaimonanDTO> {
    Context thamso1;
    int thamso2;
    List<loaimonanDTO> thamso3;
    viewholder holder;

    public custome_spinner_loaimonan(@NonNull Context context, int resource, @NonNull List<loaimonanDTO> objects) {
        super(context, resource, objects);
        thamso1 = context;
        thamso2 = resource;
        thamso3 = objects;
    }

    public class viewholder {
        TextView tvtenloaimonan;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) thamso1).getLayoutInflater();
        View view = convertView;
        if (view == null) {
            holder = new viewholder();
            view = inflater.inflate(thamso2, parent, false);
            holder.tvtenloaimonan = (TextView) view.findViewById(R.id.tvtenloaimonan);
            view.setTag(holder);
        }
        else
        {
            viewholder holder = (viewholder) view.getTag();
        }
        loaimonanDTO lmadto=thamso3.get(position);
        holder.tvtenloaimonan.setText(lmadto.getTenLoaiMonAn());
        holder.tvtenloaimonan.setTag(thamso3.get(position).getMaLoaiMonAn());

        return view;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) thamso1).getLayoutInflater();
        View view = convertView;
        if (view == null) {
            holder = new viewholder();
            view = inflater.inflate(thamso2, parent, false);
            holder.tvtenloaimonan = (TextView) view.findViewById(R.id.tvtenloaimonan);

            view.setTag(holder);

        } else {
            viewholder holder = (viewholder) view.getTag();
        }
        holder.tvtenloaimonan.setText(thamso3.get(position).getTenLoaiMonAn());
        holder.tvtenloaimonan.setTag(thamso3.get(position).getMaLoaiMonAn());

        return view;

    }
}
