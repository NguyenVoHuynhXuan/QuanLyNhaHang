package com.xuan.btandroid.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.xuan.btandroid.CustomeAdapter.custome_adapter_hienthibanan;
import com.xuan.btandroid.DAO.bananDAO;
import com.xuan.btandroid.DTO.bananDTO;
import com.xuan.btandroid.DialogActivity.thembanan;
import com.xuan.btandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 17-Apr-18.
 */

public class Fragment_hienthibanan extends Fragment
{
    GridView gvhienthibanan;
    custome_adapter_hienthibanan adater;
    bananDAO badao;
    List<bananDTO> lstbanandto=new ArrayList<bananDTO>();
   public static int mabanan;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view=inflater.inflate(R.layout.hienthibanan,container,false);
        badao=new bananDAO(getActivity());
        lstbanandto=badao.hienthidanhsachbanan();
        adater=new custome_adapter_hienthibanan(getActivity(),R.layout.custome_arrayadapter_hienthibanan,lstbanandto);
        gvhienthibanan=(GridView)view.findViewById(R.id.gvhienthibanan);
        gvhienthibanan.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                bananDTO badto=  lstbanandto.get(i);
                mabanan=badto.getMaBanAn();
            }
        });

        gvhienthibanan.setAdapter(adater);
       return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menuthembanan,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.menuthembanan:
                Intent intent=new Intent(getActivity(),thembanan.class);
                startActivityForResult(intent,1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==1)
        {
            if (resultCode==2)
            {
                bananDAO badao1=new bananDAO(getActivity());
              List<bananDTO> lstbanandto1=new ArrayList<bananDTO>();
              lstbanandto1=badao1.hienthidanhsachbanan();
              custome_adapter_hienthibanan  adater=new custome_adapter_hienthibanan(getActivity(),R.layout.custome_arrayadapter_hienthibanan,lstbanandto1);
              gvhienthibanan.setAdapter(adater);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
