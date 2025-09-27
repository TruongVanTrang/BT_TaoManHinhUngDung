package com.example.bt_manhinhungdung;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietPhimActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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
        ImageView imgPoster     = findViewById(R.id.imgPoster);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            txtTenPhim.setText("Tên phim: " + b.getString("TEN_PHIM"));
            txtGioChieu.setText("Giờ chiếu: " + b.getString("GIO_CHIEU"));
            txtGiaVe.setText("Giá vé: " + b.getString("GIA_VE"));
            txtNhaXuatBan.setText("Nhà xuất bản: " + b.getString("NXB"));
            txtNgayPhatHanh.setText("Ngày phát hành: " + b.getString("NGAY_PHAT_HANH"));
            txtDanhGia.setText("Đánh giá: " + b.getString("DANH_GIA"));
            txtMoTa.setText("Mô tả: " + b.getString("MO_TA"));

            // 🖼 Hiển thị ảnh poster
            int posterResId = b.getInt("POSTER_RES_ID", -1);
            if (posterResId != -1) {
                imgPoster.setImageResource(posterResId);
            }
        }

        Button btnQuayLai = findViewById(R.id.btnQuayLai);
        Button btnHome    = findViewById(R.id.btnHome);

        btnQuayLai.setOnClickListener(v -> finish());
        btnHome.setOnClickListener(v -> {
            Intent homeIntent = new Intent(ChiTietPhimActivity.this, TrangChuActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        });
        Button btnDatVeNgay = findViewById(R.id.btnDatVeNgay);

        btnDatVeNgay.setOnClickListener(v -> {
            Intent i = new Intent(ChiTietPhimActivity.this, ChonPhimActivity.class);

            // Lấy tên phim từ TextView (bỏ tiền tố "Tên phim: ")
            String tenPhim = txtTenPhim.getText().toString().replace("Tên phim: ", "");
            i.putExtra("TEN_PHIM", tenPhim);

            // Lấy resource id ảnh poster (nếu bạn lưu posterRes khi set ảnh)
            int posterRes = getIntent().getIntExtra("POSTER_RES_ID", R.drawable.bgr_dv);
            i.putExtra("POSTER_RES", posterRes);

            startActivity(i);
        });


    }
}
