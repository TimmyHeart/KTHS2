package com.example.kt_tranhieunghia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnthoat;
    ImageView img1, img2, img3, img4, img5,img6;
    Intent i;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this,Bai6.class);  // chuyển sang màn hình 2
                startActivity(i);
            }
        });
img3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        i = new Intent(MainActivity.this,Bai3.class);  // chuyển sang màn hình 2
        startActivity(i);
    }
});


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this,Bai1.class);  // chuyển sang màn hình 2
                startActivity(i);

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(MainActivity.this,Bai2.class);
                startActivity(i);
            }
        });


        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tạo đối tượng
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                //Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý thoát chương trình không?");
                // Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                //Nút Cancel
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
//Tạo dialog
                AlertDialog al = b.create();
//Hiển thị
                al.show();
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
                i=new Intent(MainActivity.this,thongtin.class);
                startActivity(i);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu2:

                Toast.makeText(this, "Ban vua bam vao menu2", Toast.LENGTH_SHORT).show();//code xử lý khi bấm menu2
                break;
            case R.id.menu3:
                i = new Intent(MainActivity.this,Bai3.class);//code xử lý khi bấm menu3
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
        btnthoat = findViewById(R.id.btnThoat);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);
        img4 = findViewById(R.id.image4);
        img5 = findViewById(R.id.image5);
        img6 = findViewById(R.id.image6);
    }




}