package com.example.kt_tranhieunghia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import model.Contact;

public class Listview3 extends AppCompatActivity {
    Intent it;
    EditText edtid, edtname, edtphone;
    Button edtluu;
    ListView lvContact;
    ArrayAdapter<Contact>contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ListView3");
        actionBar.setDisplayHomeAsUpEnabled(true);
        addControls();
        addEvents();
    }

    private void addEvents() {
        edtluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyThemContact();
            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c=contactAdapter.getItem(position);
                edtid.setText(c.getId()+"");
                edtname.setText(c.getName());
                edtphone.setText(c.getPhone());

            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c=contactAdapter.getItem(position);
                AlertDialog.Builder b = new AlertDialog.Builder(Listview3.this);
//Thiết lập tiêu đề
                b.setTitle("Xác nhận");
                b.setMessage("Bạn có đồng ý xóa không?");
// Nút Ok
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contactAdapter.remove(c);
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
                return false;
            }
        });
    }

    private void xulyThemContact() {
        Contact c=new Contact();
        c.setId((Integer.parseInt(edtid.getText().toString())));
        c.setName(edtname.getText().toString());
        c.setPhone(edtphone.getText().toString());
        contactAdapter.add(c);
    }

    private void addControls() {
        edtid=findViewById(R.id.edtid);
        edtname=findViewById(R.id.edtname);
        edtphone=findViewById(R.id.edtphone);
        edtluu=findViewById(R.id.edtluu);
        lvContact=findViewById(R.id.lvContact);
        contactAdapter=new ArrayAdapter<Contact>(Listview3.this, android.R.layout.simple_list_item_1);
        lvContact.setAdapter(contactAdapter);
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
                it=new Intent(Listview3.this,thongtin.class);
                startActivity(it);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu2:
                Toast.makeText(this,"Bạn vừa chọn menu 2",Toast.LENGTH_LONG).show();
                //code xử lý khi bấm menu1
                break;
            case R.id.menu3:
                it = new Intent(Listview3.this, Bai2.class);
                startActivity(it);
                //code xử lý khi bấm menu3
                break;
            case R.id.menu4:
                it = new Intent(Listview3.this, Bai3.class);
                startActivity(it);
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}