package com.example.bt_manhinhungdung;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DanhSachPhimActivity extends AppCompatActivity {

    // Dữ liệu mẫu
    String[] danhSachPhim = {
            "Avengers: Endgame - 19:00 - 80.000đ",
            "Avatar 2 - 20:00 - 90.000đ",
            "Minions 2 - 18:30 - 70.000đ"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_phim);

        ListView listView = findViewById(R.id.listPhim);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                danhSachPhim
        );
        listView.setAdapter(adapter);
    }
}
