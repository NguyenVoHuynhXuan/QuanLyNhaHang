package com.xuan.btandroid.giaodien;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xuan.btandroid.DAO.nhanvienDAO;
import com.xuan.btandroid.DTO.nhanvienDTO;
import com.xuan.btandroid.Fragment.FragmentDateTime;
import com.xuan.btandroid.R;

/**
 * Created by HP on 16-Apr-18.
 */

public class dangki extends AppCompatActivity
{
    EditText edttendangnhap,edtmatkhau,edtngaysinh,edtcmnd;
    Button btndongy;
    RadioGroup radgioitinh;
    RadioButton radnam,radnu;
    nhanvienDAO nvdao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangki);
        nvdao=new nhanvienDAO(this);
        edttendangnhap=(EditText)findViewById(R.id.edttendangnhap);
        edtmatkhau=(EditText)findViewById(R.id.edtmatkhau);
        edtcmnd=(EditText)findViewById(R.id.edtcmnd);
        radgioitinh=(RadioGroup)findViewById(R.id.radgioitinh);
        radnam=(RadioButton)findViewById(R.id.radnam);
        radnu=(RadioButton)findViewById(R.id.radnu);
        btndongy=(Button)findViewById(R.id.btndongy);
        edtngaysinh=(EditText)findViewById(R.id.edtngaysinh);
        edtngaysinh.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                FragmentDateTime fragmentDateTime=new FragmentDateTime();
                fragmentDateTime.show(getSupportFragmentManager(),"Ngay sinh");
            }
        });
        btndongy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

              String  tendangnhap=edttendangnhap.getText().toString();
              String  matkhau=edtmatkhau.getText().toString();
                if(tendangnhap.equals("")||tendangnhap==null)
                {
                    Toast.makeText(dangki.this,"Ban chua nhap ten dang nhap",Toast.LENGTH_SHORT).show();
                }
                else if(matkhau.equals("")|| matkhau==null)
                {
                    Toast.makeText(dangki.this,"Ban chua nhap mat khau",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    nhanvienDTO nvdto = new nhanvienDTO();
                    nvdto.setTenDangNhap(edttendangnhap.getText().toString());
                    nvdto.setMatKhau(edtmatkhau.getText().toString());
                    nvdto.setCMND(edtcmnd.getText().toString());
                    nvdto.setNgaySinh(edtngaysinh.getText().toString());
                    String gioitinh = "";
                    switch (radgioitinh.getCheckedRadioButtonId()) {
                        case R.id.radnam:
                            gioitinh = "Nam";
                            break;
                        case R.id.radnu:
                            gioitinh = "Nu";
                            break;
                    }
                    nvdto.setGioiTinh(gioitinh);
                    if(nvdao.themnhanvien(nvdto)==true)
                    {
                        Toast.makeText(dangki.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}
