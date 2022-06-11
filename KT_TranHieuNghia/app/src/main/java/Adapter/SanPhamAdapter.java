package Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kt_tranhieunghia.R;
import model.SanPham;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter {
    Activity activity;

    public SanPhamAdapter(Activity activity, ArrayList products) {
        super(activity,0,products);
        this.activity =  activity;
    }
    @NonNull
    @Override
    public View getView(int position, View customView, ViewGroup parent) {

        if(customView ==null) {


            LayoutInflater inflater = activity.getLayoutInflater();
            customView = inflater.inflate(R.layout.item, null);
        }

        ImageView imgHinh= customView.findViewById(R.id.imgHinh);
        TextView txtTen= customView.findViewById(R.id.txtTen);
        TextView txtGia= customView.findViewById(R.id.txtGia);

        SanPham sp=(SanPham) getItem(position);
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText(" Giá:"+sp.getGia());

        return customView;
    }

}
