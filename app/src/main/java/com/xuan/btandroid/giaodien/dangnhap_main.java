package com.xuan.btandroid.giaodien;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.xuan.btandroid.DAO.nhanvienDAO;
        import com.xuan.btandroid.Database.database;
        import com.xuan.btandroid.R;

public class dangnhap_main extends AppCompatActivity {

    Button btndangnhap,btndangki;
    EditText edttendangnhap,edtmatkhau;
    nhanvienDAO nvdao;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap_main);
        nvdao=new nhanvienDAO(dangnhap_main.this);
        database da=new database(dangnhap_main.this);
        da.ketnoidatabase();
        edttendangnhap=(EditText)findViewById(R.id.edttendangnhap);
        edtmatkhau=(EditText)findViewById(R.id.edtmatkhau);
        btndangki=(Button)findViewById(R.id.btndangki);
        btndangnhap=(Button)findViewById(R.id.btndangnhap);
        btndangnhap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tendangnhap=edttendangnhap.getText().toString();
                String matkhau=edtmatkhau.getText().toString();
                if(tendangnhap==null ||tendangnhap.equals(""))
                {
                    Toast.makeText(dangnhap_main.this,"Bạn chưa nhập tên đăng nhập",Toast.LENGTH_SHORT).show();
                }
                else if(matkhau==null || matkhau.equals(""))
                {
                    Toast.makeText(dangnhap_main.this,"Bạn chưa nhập mật khẩu",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(nvdao.kiemtranhanvien(edttendangnhap.getText().toString(),edtmatkhau.getText().toString())==true)
                    {
                        Intent intent=new Intent(dangnhap_main.this,trangchu.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(dangnhap_main.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                        edttendangnhap.setText("");
                        edttendangnhap.requestFocus();
                        edtmatkhau.setText("");
                    }
                }

            }
        });
        btndangki.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(dangnhap_main.this,dangki.class);
                startActivity(intent);
            }
        });

    }
}
