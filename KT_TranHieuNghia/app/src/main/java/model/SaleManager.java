package model;

import com.example.kt_tranhieunghia.R;

import java.util.ArrayList;

/**
 * Created by minhc_000 on 12/08/2015.
 */
public class SaleManager {
    private ArrayList Products;

    public SaleManager() {
        Products = new ArrayList();
    }

    public ArrayList getProducts() {
        return Products;
    }

    public void setProducts(ArrayList products) {
        Products = products;
    }





    public void generateProducts() {
        Products.clear();
        Products.add(new SanPham(R.drawable.h6,"Sản Phẩm 1",60000));
        Products.add(new SanPham(R.drawable.h7,"Sản Phẩm 2",70000));
        Products.add(new SanPham(R.drawable.h8,"Sản Phẩm 3",80000));
        Products.add(new SanPham(R.drawable.h9,"Sản Phẩm 4",90000));
        Products.add(new SanPham(R.drawable.h10,"Sản Phẩm 5",100000));
        Products.add(new SanPham(R.drawable.h11,"Sản Phẩm 6",110000));
        Products.add(new SanPham(R.drawable.h12,"Sản Phẩm 7",120000));
        Products.add(new SanPham(R.drawable.h13,"Sản Phẩm 8",130000));
        Products.add(new SanPham(R.drawable.h14,"Sản Phẩm 9",140000));
        Products.add(new SanPham(R.drawable.h15,"Sản Phẩm 10",150000));
    }

    private static SaleManager saleManager;

    public static SaleManager get() {
        if (saleManager == null)
            saleManager = new SaleManager();
        return saleManager;
    }
}
