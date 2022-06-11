package com.example.kt_tranhieunghia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Listview1 extends AppCompatActivity {
    Intent i;
    ListView lvData1;
    String []arrData={"Nguyễn Trường Quý","Đặng Anh Kiệt", "Phạm Huỳnh Nhật Huy","Bùi Minh Thiên","Đỗ Gia Bảo","Lê Thanh Huy","Trần Minh Quang","Lê Phú Phúc","Huỳnh Đức Lộc","Nguyễn Văn Trung Trực", "Nguyễn Thị Bảo Trân","Huỳnh Hữu Lý","Phạm Minh Đức","Trần Đức Nhân","Nguyễn Tấn Đạt","Lê Huế Anh","Đinh Nguyễn Trường Hải","Chế Phương Nam","Nguyễn Chí Cường","Nguyễn Trần Quang Tuyến","Nguyễn Thanh Minh Nhựt","Huỳnh Thành Đạt","Nguyễn Huỳnh Trung Tính","Đặng Thụy Thanh Duy","Nguyễn Xuân Trường","Trương Lệ Hào","Nguyễn Thị Thanh Tuyền","Đoàn Tường Vy","Lê Đức Lợi","Trần Hiếu Nghĩa"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List View1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvData1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Listview1.this, "Bạn đã chọn : "+ arrData[position], Toast.LENGTH_SHORT).show();
            }
        });
        ;
    }

    private void addControls() {
        lvData1 = findViewById(R.id.lvData1);
        adapter = new ArrayAdapter<String>(Listview1.this, android.R.layout.simple_list_item_1,arrData);
        //gán adapter cho listview
        lvData1.setAdapter(adapter);
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
                i=new Intent(Listview1.this,thongtin.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}