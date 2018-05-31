package com.xuan.btandroid.DialogActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xuan.btandroid.DAO.bananDAO;
import com.xuan.btandroid.DTO.bananDTO;
import com.xuan.btandroid.Fragment.Fragment_hienthibanan;
import com.xuan.btandroid.R;

/**
 * Created by HP on 18-Apr-18.
 */

public class thembanan extends AppCompatActivity
{
    Button btndongy,btnhuy;
    EditText edttenbanan;
    bananDAO badao;
    bananDTO badto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thembanan);
        badao=new bananDAO(thembanan.this);
        edttenbanan=(EditText)findViewById(R.id.edttenbanan);
        btndongy=(Button)findViewById(R.id.btndongy);
        btndongy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tenbanan=edttenbanan.getText().toString();
                if(tenbanan.equals("")|| tenbanan==null)
                {
                    Toast.makeText(thembanan.this,"Bạn chưa nhập tên bàn ăn",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    badto=new bananDTO();
                    badto.setTinhTrang(1);
                    badto.setTenBanAn(edttenbanan.getText().toString());
                    badao.thembanan(badto);
                    Intent intent=new Intent(thembanan.this, Fragment_hienthibanan.class);
                    setResult(2,intent);
                    finish();
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
