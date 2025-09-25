package com.example.bt_manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class TrangChuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        Button btnDanhSach = findViewById(R.id.btnDanhSachPhim);

        // Khi bấm nút → chuyển sang Danh Sách Phim
        btnDanhSach.setOnClickListener(v -> {
            Intent intent = new Intent(TrangChuActivity.this, DanhSachPhimActivity.class);
            startActivity(intent);
        });
    }
}
