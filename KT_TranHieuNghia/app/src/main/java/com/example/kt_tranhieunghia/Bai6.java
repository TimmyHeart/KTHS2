package com.example.kt_tranhieunghia;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Adapter.SanPhamAdapter;
import model.SaleManager;
import model.SanPham;

import java.util.ArrayList;

public class Bai6 extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Gio hang 2");
        actionBar.setDisplayHomeAsUpEnabled(true);
        addControls();

        SaleManager saleManager = SaleManager.get();
        saleManager.generateProducts();
        ArrayList produts = saleManager.getProducts();

        sanPhamAdapter = new SanPhamAdapter(Bai6.this,produts);
        lvSanPham.setAdapter(sanPhamAdapter);
        lvSanPham.setOnItemLongClickListener(new ItemLongClickRemove());


        //addEvents();
        //  fakeData();
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.h6, "Sản Phẩm 1", 60000));
        sanPhamAdapter.add(new SanPham(R.drawable.h7, "Sản Phẩm 2", 70000));
        sanPhamAdapter.add(new SanPham(R.drawable.h8, "Sản Phẩm 3", 80000));
        sanPhamAdapter.add(new SanPham(R.drawable.h9, "Sản Phẩm 4", 90000));
        sanPhamAdapter.add(new SanPham(R.drawable.h10, "Sản Phẩm 5", 100000));
        sanPhamAdapter.add(new SanPham(R.drawable.h11, "Sản Phẩm 6", 110000));
        sanPhamAdapter.add(new SanPham(R.drawable.h12, "Sản Phẩm 7", 120000));
        sanPhamAdapter.add(new SanPham(R.drawable.h13, "Sản Phẩm 8", 130000));
        sanPhamAdapter.add(new SanPham(R.drawable.h14, "Sản Phẩm 9", 140000));
        sanPhamAdapter.add(new SanPham(R.drawable.h15, "Sản Phẩm 10", 150000));
    }




    private void addControls() {
        lvSanPham = findViewById(R.id.lvSanPham);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                Toast.makeText(this, "Bạn vừa chọn menu 1", Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu1
                break;
            case R.id.menu2:
                Toast.makeText(this, "Bạn vừa chọn menu 2", Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu2
                break;
            case R.id.menu3:
                //  //code xử lý khi bấm menu3
                Toast.makeText(this, "Bạn vừa chọn menu 3", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu4:
                Toast.makeText(this, "Bạn vừa chọn menu 4", Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu2
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Bai6.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    SaleManager.get().getProducts().remove(position);
                    //cập nhật lại listview
                    sanPhamAdapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }





}