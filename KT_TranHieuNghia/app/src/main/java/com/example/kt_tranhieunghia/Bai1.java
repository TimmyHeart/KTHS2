package com.example.kt_tranhieunghia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Bai1 extends AppCompatActivity {
    Intent i;
    EditText edtCMND, edtPhone, edtDiaChi;
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        addControls();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("KT số 1");           // thiết lập tiêu đề nếu muón
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //mũi tên quay lại


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bai1.this,"Bạn nhấn Cập nhật",Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCMND.setText("");
                edtPhone.setText("");
                edtDiaChi.setText("");
                edtCMND.requestFocus();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });






    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                i=new Intent(Bai1.this,thongtin.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu2:
                Toast.makeText(this, "Ban vua bam vao menu2", Toast.LENGTH_SHORT).show();//code xử lý khi bấm menu2
                break;
            case R.id.menu3:
                i = new Intent(Bai1.this,MainActivity.class);//code xử lý khi bấm menu3
                startActivity(i);
                break;
            case R.id.menu4:
                Toast.makeText(this, "Ban vua bam vao menu4", Toast.LENGTH_SHORT).show();//code xử lý khi bấm menu3
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addControls(){        //kết nối biến java vơi xml
        btn1 = findViewById(R.id.btnhap);
        btn2 = findViewById(R.id.btnlai);
        btn3 = findViewById(R.id.btnthoat);

    }



}