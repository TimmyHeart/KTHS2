package com.example.kt_tranhieunghia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TTSV extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttsv);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thông tin sinh viên");
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
                Toast.makeText(this,"Bạn vừa chọn menu 1",Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu1
                break;
            case R.id.menu2:
                Toast.makeText(this,"Bạn vừa chọn menu 2",Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu2
                break;
            case R.id.menu3:
                i = new Intent(TTSV.this, Bai2.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu4:
                i = new Intent(TTSV.this, Bai3.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);

    }
}