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

public class Listview2 extends AppCompatActivity {
    Intent i;
    ListView lvData2;
    String []arrData2;
    //String []arrData2={"Nguyễn Trường Quý","Đặng Anh Kiệt", "Phạm Huỳnh Nhật Huy","Bùi Minh Thiên","Đỗ Gia Bảo","Lê Thanh Huy","Trần Minh Quang","Lê Phú Phúc","Huỳnh Đức Lộc","Nguyễn Văn Trung Trực", "Nguyễn Thị Bảo Trân","Huỳnh Hữu Lý","Phạm Minh Đức","Trần Đức Nhân","Nguyễn Tấn Đạt","Lê Huế Anh","Đinh Nguyễn Trường Hải","Chế Phương Nam","Nguyễn Chí Cường","Nguyễn Trần Quang Tuyến","Nguyễn Thanh Minh Nhựt","Huỳnh Thành Đạt","Nguyễn Huỳnh Trung Tính","Đặng Thụy Thanh Duy","Nguyễn Xuân Trường","Trương Lệ Hào","Nguyễn Thị Thanh Tuyền","Đoàn Tường Vy","Lê Đức Lợi","Trần Hiếu Nghĩa"};
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List View2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvData2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Listview2.this, "Bạn đã chọn : "+ arrData2[position], Toast.LENGTH_SHORT).show();
            }
        });
        ;
    }

    private void addControls() {
        lvData2 = findViewById(R.id.lvData2);
        arrData2=getResources().getStringArray(R.array.nghia);
        adapter2 = new ArrayAdapter<String>(Listview2.this, android.R.layout.simple_list_item_1,arrData2);
        //gán adapter cho listview
        lvData2.setAdapter(adapter2);
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
                i=new Intent(Listview2.this,thongtin.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}