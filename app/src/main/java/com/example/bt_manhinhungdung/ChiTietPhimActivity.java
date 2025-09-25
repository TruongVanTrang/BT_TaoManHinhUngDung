package com.example.bt_manhinhungdung;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietPhimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phim);

        TextView txtTenPhim     = findViewById(R.id.txtTenPhim);
        TextView txtGioChieu    = findViewById(R.id.txtGioChieu);
        TextView txtGiaVe       = findViewById(R.id.txtGiaVe);
        TextView txtNhaXuatBan  = findViewById(R.id.txtNhaXuatBan);
        TextView txtNgayPhatHanh= findViewById(R.id.txtNgayPhatHanh);
        TextView txtDanhGia     = findViewById(R.id.txtDanhGia);
        TextView txtMoTa        = findViewById(R.id.txtMoTa);
//        TextView txtSoLuong     = findViewById(R.id.txtSoLuongDaDat);

        // Nhận dữ liệu từ DanhSachPhimActivity
        Bundle b = getIntent().getExtras();
        if (b != null) {
            txtTenPhim.setText("Tên phim: " + b.getString("TEN_PHIM"));
            txtGioChieu.setText("Giờ chiếu: " + b.getString("GIO_CHIEU"));
            txtGiaVe.setText("Giá vé: " + b.getString("GIA_VE"));
            txtNhaXuatBan.setText("Nhà xuất bản: " + b.getString("NXB"));
            txtNgayPhatHanh.setText("Ngày phát hành: " + b.getString("NGAY_PHAT_HANH"));
            txtDanhGia.setText("Đánh giá: " + b.getString("DANH_GIA"));
            txtMoTa.setText("Mô tả: " + b.getString("MO_TA"));
//            txtSoLuong.setText("Số lượng đã đặt: " + b.getInt("SO_LUONG_DA_DAT"));
        }

        // Nút điều hướng
        Button btnQuayLai = findViewById(R.id.btnQuayLai);
        Button btnHome    = findViewById(R.id.btnHome);

        btnQuayLai.setOnClickListener(v -> finish());
        btnHome.setOnClickListener(v -> {
            finishAffinity(); // hoặc về TrangChuActivity
        });
    }
}
