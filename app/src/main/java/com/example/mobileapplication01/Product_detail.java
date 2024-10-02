package com.example.mobileapplication01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Product_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        setUpImageViewClick(R.id.imageView1, "donuts");
        setUpImageViewClick(R.id.imageView2, "croissant");
        setUpImageViewClick(R.id.imageView3, "cake");
        setUpImageViewClick(R.id.imageView4, "cookie");
    }

    private void setUpImageViewClick(int imageViewId, String roomType) {
        ImageView imageView = findViewById(imageViewId);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Product_detail.this, Product.class);
            intent.putExtra("roomType", roomType);
            startActivity(intent);
        });
    }
}
