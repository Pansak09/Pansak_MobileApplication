package com.example.mobileapplication01;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobileapplication01.model.smarthome;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.Button;

public class Product extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdptersmar mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        String roomType = getIntent().getStringExtra("roomType");

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<smarthome> smarthomes = getSmarthomesByRoomType(roomType);
        mAdapter = new MyAdptersmar(smarthomes, this);
        recyclerView.setAdapter(mAdapter);

        Button okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> {
            List<smarthome> selectedItems = mAdapter.getSelectedItems(); // ดึงรายการที่เลือก
            Intent intent = new Intent(Product.this, Chat.class);

            // ส่งชื่อของ smarthome ที่ถูกเลือกไปยัง Chat
            ArrayList<String> itemNames = new ArrayList<>();
            for (smarthome item : selectedItems) {
                itemNames.add(item.getSmarthome_name());
            }

            intent.putStringArrayListExtra("selectedItems", itemNames);
            startActivity(intent);
        });
    }

    private List<smarthome> getSmarthomesByRoomType(String roomType) {
        List<smarthome> smarthomes = new ArrayList<>();

        switch (roomType) {
            case "donuts":
                smarthomes.add(createSmarthome("โดนัทเคลือบน้ำตาล", "https://i.pinimg.com/564x/82/23/65/8223655316d17537dea599e3f3cd41b7.jpg", "", "25 บาท"));
                smarthomes.add(createSmarthome("โดนัท รสช็อกโกแลต", "https://i.pinimg.com/564x/f6/2b/81/f62b81242820c9e1e8661a3d6d1b2fae.jpg", "", "20 บาท"));
                smarthomes.add(createSmarthome("โดนัท รสชาเขียว", "https://i.pinimg.com/564x/04/c2/cf/04c2cf9f4a788118d86623f4ceda93a2.jpg", "", "30 บาท"));
                smarthomes.add(createSmarthome("โดนัท รสสตอเบอรี่", "https://i.pinimg.com/564x/db/88/e5/db88e5a739ff58905afc5aaa3f92d6b5.jpg", "", "45 บาท"));
                smarthomes.add(createSmarthome("Chocolate Glazed Peanut Butter Donuts", "https://i.pinimg.com/564x/f1/a5/71/f1a57167c59ded7b61e66e345fc66d5d.jpg", "", "30 บาท"));
                break;

            case "croissant":
                smarthomes.add(createSmarthome("Raspberry Pistachio Croissan", "https://i.pinimg.com/564x/c2/94/f2/c294f242f2131c97962694688c0e4743.jpg", "", "120 บาท"));
                smarthomes.add(createSmarthome("Chocolate Croissan", "https://i.pinimg.com/564x/13/96/9e/13969e3c3076b87709994a8205439905.jpg", "", "100 บาท"));
                smarthomes.add(createSmarthome("Almond Croissants", "https://i.pinimg.com/564x/2c/8e/38/2c8e38f6201d2bf50ad1dc3d796c149f.jpg", "", "89 บาท"));
                smarthomes.add(createSmarthome("Raspberry Rose Lychee Croissant", "https://i.pinimg.com/564x/d5/e2/52/d5e252d6a561ffa9d21ff7b5f494a33b.jpg", "", "89 บาท"));
                break;

            case "cookie":
                smarthomes.add(createSmarthome("Matilda's Chocolate Cake", "https://i.pinimg.com/564x/f0/d2/1f/f0d21f5bec274c9d0b20460d506e02e0.jpg", "", "350 บาท"));
                smarthomes.add(createSmarthome("Japanese Strawberry Sponge Cake", "https://i.pinimg.com/564x/09/c5/95/09c595afd9ac773c7bdeaea11a8ff64f.jpg", "", "450 บาท"));
                smarthomes.add(createSmarthome("Summer Cake", "https://i.pinimg.com/564x/8f/49/c9/8f49c93ecda1e91aeeec4a0b6c9ebc5b.jpg", "Summer Cake", "550 บาท"));
                smarthomes.add(createSmarthome("Peanut Butter Chocolate Layer Cake", "https://i.pinimg.com/564x/d4/ac/9f/d4ac9fe618f8290e994e296bbed9ce67.jpg", "", "50 บาท"));
                break;

            case "cake":
                smarthomes.add(createSmarthome("Chocolate Chip Cookie", "https://i.pinimg.com/564x/bc/6b/9a/bc6b9a55b264c33ee3a59c51531d3ca7.jpg", "", "35 บาท"));
                smarthomes.add(createSmarthome("Big Blue Monster Stuffed Cookies", "https://i.pinimg.com/564x/09/c5/95/09c595afd9ac773c7bdeaea11a8ff64f.jpg", "", "40 บาท"));
                smarthomes.add(createSmarthome("Butter Cookies", "https://i.pinimg.com/564x/43/04/bf/4304bfc0e1ac514ba34e3fa6a18f29ad.jpg", "", "50 บาท"));
                smarthomes.add(createSmarthome("Wanna-Be Brownie Cookies", "https://i.pinimg.com/564x/5b/5c/15/5b5c159470ff909990efeba5ad6e335d.jpg", "", "50 บาท"));
                break;
        }

        return smarthomes;
    }

    private smarthome createSmarthome(String name, String image, String detail, String price) {
        smarthome item = new smarthome();
        item.setSmarthome_name(name);
        item.setSmarthome_image(image);
        item.setSmarthome_detail(detail);
        item.setSmarthome_price(price);
        item.setChecked(false); // ตั้งค่าเริ่มต้นเป็นไม่เลือก
        return item;
    }
}
