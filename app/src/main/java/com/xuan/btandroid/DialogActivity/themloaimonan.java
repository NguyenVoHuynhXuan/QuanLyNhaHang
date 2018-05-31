package com.xuan.btandroid.DialogActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xuan.btandroid.DAO.loaimonanDAO;
import com.xuan.btandroid.DTO.loaimonanDTO;
import com.xuan.btandroid.Fragment.Fragment_thucdon;
import com.xuan.btandroid.R;

/**
 * Created by HP on 19-Apr-18.
 */

public class themloaimonan extends AppCompatActivity
{
    Button btndongy,btnhuy;
    EditText edtthemloaimonan;
    loaimonanDAO lmadao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themloaimonan);
        lmadao=new loaimonanDAO(themloaimonan.this);
        edtthemloaimonan=(EditText)findViewById(R.id.edtloaimonan);
        btndongy=(Button)findViewById(R.id.btndongy);
        btndongy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String loaimonan=edtthemloaimonan.getText().toString();
                if(loaimonan.equals("")||loaimonan==null)
                {
                    Toast.makeText(themloaimonan.this,"Bạn chưa nhập loại thức ăn",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loaimonanDTO lmadto=new loaimonanDTO();
                    lmadto.setTenLoaiMonAn(edtthemloaimonan.getText().toString());
                  if ( lmadao.themloaimonan(lmadto)==true)
                  {
                      Toast.makeText(themloaimonan.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                      Intent intent=new Intent(themloaimonan.this, Fragment_thucdon.class);
                      setResult(4);
                      finish();
                  }
                }
            }
        });


        btnhuy=(Button)findViewById(R.id.btnhuy);
        btnhuy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}
