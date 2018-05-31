package com.xuan.btandroid.CustomeAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xuan.btandroid.DAO.bananDAO;
import com.xuan.btandroid.DTO.bananDTO;
import com.xuan.btandroid.Fragment.Fragment_hienthibanan;
import com.xuan.btandroid.R;

import java.util.List;

/**
 * Created by HP on 18-Apr-18.
 */

public class custome_adapter_hienthibanan extends ArrayAdapter<bananDTO>
{

    Context thamso1;
    int thamso2;
    List<bananDTO> thamso3;
    List<bananDTO> lstbadto;
    bananDAO badao;
    bananDTO badto;
    int maban;
    int vitri=0;

    ImageView imgbanan;
    Button btngoimon,btnthanhtoan;
    TextView tvtenbanan;

    public custome_adapter_hienthibanan(@NonNull Context context, int resource, @NonNull List<bananDTO> objects)
    {

        super(context, resource, objects);
        thamso1=context;
        thamso2=resource;
        thamso3=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity) thamso1).getLayoutInflater();
        View v = layoutInflater.inflate(thamso2, parent, false);
        imgbanan = (ImageView) v.findViewById(R.id.imgbanan);
        btngoimon = (Button) v.findViewById(R.id.btngoimon);
        btnthanhtoan = (Button) v.findViewById(R.id.btnthanhtoan);
        tvtenbanan = (TextView) v.findViewById(R.id.tvtenbanan);

        badto=thamso3.get(position);
        tvtenbanan.setText(badto.getTenBanAn());
        final bananDTO  badto1 = thamso3.get(position);
        if (badto.getTinhTrang() == 1)
        {
            imgbanan.setImageResource(R.drawable.banan);
            btnthanhtoan.setVisibility(View.INVISIBLE);
            btngoimon.setVisibility(View.INVISIBLE);
        }
        else if (badto.getTinhTrang() == 2)
        {
            imgbanan.setImageResource(R.drawable.banantrue);
            btnthanhtoan.setVisibility(View.VISIBLE);
            btngoimon.setVisibility(View.VISIBLE);
        }
       imgbanan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
                Toast.makeText(getContext(),""+badto1.getMaBanAn(),Toast.LENGTH_SHORT).show();
           }
       });

        return v;
    }

}
