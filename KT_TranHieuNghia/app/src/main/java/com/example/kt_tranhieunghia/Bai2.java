package com.example.kt_tranhieunghia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Bai2 extends AppCompatActivity {
    Intent i;
    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        button=findViewById(R.id.chuyendoi);
        textView=findViewById(R.id.amlich);
        editText=findViewById(R.id.duonglich);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String can []={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bỉnh","Đinh","Mậu","Kỷ"};
                String chi[]={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
                String di = editText.getText().toString();
                int m = Integer.parseInt(di);
                String am= can[m%10] + " " +chi[m%12];
                textView.setText(am);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("KT SỐ 2");
        actionBar.setDisplayHomeAsUpEnabled(true);
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
                i=new Intent(Bai2.this,thongtin.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu2:
                Toast.makeText(this, "Ban vua bam vao menu2", Toast.LENGTH_SHORT).show();//code xử lý khi bấm menu2
                break;
            case R.id.menu3:
                i = new Intent(Bai2.this,MainActivity.class);//code xử lý khi bấm menu3
                startActivity(i);
                break;
            case R.id.menu4:
                Toast.makeText(this, "Ban vua bam vao menu4", Toast.LENGTH_SHORT).show();//code xử lý khi bấm menu3
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}