package com.example.bt_manhinhungdung;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class XacNhanVeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_ve);

        LinearLayout layoutThongTin = findViewById(R.id.layoutThongTin);
        LinearLayout layoutThanhCong = findViewById(R.id.layoutThanhCong);
        Button btnThanhToan = findViewById(R.id.btnThanhToan);
        Button btnQuayLai  = findViewById(R.id.btnQuayLai);
        Button btnVeTrangChu = findViewById(R.id.btnVeTrangChu);

        ImageView imgPosterConfirm = findViewById(R.id.imgPosterConfirm);
        TextView tvTenPhim = findViewById(R.id.tvTenPhim);
        TextView tvNgayChieu = findViewById(R.id.tvNgayChieu);
        TextView tvGioChieu = findViewById(R.id.tvGioChieu);
        TextView tvGhe = findViewById(R.id.tvGhe);
        TextView tvSoLuong = findViewById(R.id.tvSoLuong);
        TextView tvTongTien = findViewById(R.id.tvTongTien);

        Intent i = getIntent();
        tvTenPhim.setText("Tên phim: " + i.getStringExtra("TEN_PHIM"));
        tvNgayChieu.setText("Ngày chiếu: " + i.getStringExtra("NGAY_CHIEU"));
        tvGioChieu.setText("Giờ chiếu: " + i.getStringExtra("GIO_CHIEU"));
        tvGhe.setText("Ghế: " + i.getStringExtra("GHE"));
        int soLuong = i.getIntExtra("SO_LUONG", 1);
        tvSoLuong.setText("Số lượng vé: " + soLuong);
        int tongTien = soLuong * 80000;
        tvTongTien.setText("Tổng tiền: " + tongTien + " VNĐ");

        int posterRes = i.getIntExtra("POSTER_RES", R.drawable.bgr_dv);
        imgPosterConfirm.setImageResource(posterRes);

        btnThanhToan.setOnClickListener(v -> {
            Toast.makeText(this, "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
            layoutThongTin.setVisibility(View.GONE);
            layoutThanhCong.setVisibility(View.VISIBLE);
        });

        btnQuayLai.setOnClickListener(v -> finish());

        btnVeTrangChu.setOnClickListener(v -> {
            Intent home = new Intent(this, TrangChuActivity.class);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(home);
            finish();
        });
    }
}

