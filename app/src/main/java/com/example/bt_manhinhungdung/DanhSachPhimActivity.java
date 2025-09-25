package com.example.bt_manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DanhSachPhimActivity extends AppCompatActivity {

    // 🔹 6 bộ phim mẫu
    String[][] data = {
            {"Avengers: Endgame", "4.8"},
            {"Avatar 2", "4.7"},
            {"Minions 2", "4.3"},
            {"The Batman", "4.6"},
            {"Doctor Strange 2", "4.5"},
            {"Spider-Man: No Way Home", "4.9"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_phim);

        ListView listView = findViewById(R.id.listPhim);
        ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, 0, data) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext())
                            .inflate(R.layout.item_danh_sach_phim, parent, false);
                }
                TextView tvTenPhim  = convertView.findViewById(R.id.tvTenPhim);
                TextView tvDanhGia  = convertView.findViewById(R.id.tvDanhGia);

                tvTenPhim.setText(data[position][0]);
                tvDanhGia.setText("★" + data[position][1]);
                return convertView;
            }
        };
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(DanhSachPhimActivity.this, ChiTietPhimActivity.class);
            switch (position) {
                case 0:
                    putPhim(intent, "Avengers: Endgame", "19:00", "80.000đ",
                            "Marvel Studios", "26/04/2019", "4.8/5",
                            "Biệt đội Avengers hợp lực để đảo ngược thảm kịch Thanos, trận chiến quyết định số phận vũ trụ.",
                            150);
                    break;
                case 1:
                    putPhim(intent, "Avatar 2", "20:00", "90.000đ",
                            "20th Century Fox", "16/12/2022", "4.7/5",
                            "Hành trình mới trên Pandora với thế giới dưới biển tuyệt đẹp và những mối hiểm họa mới.",
                            200);
                    break;
                case 2:
                    putPhim(intent, "Minions 2", "18:30", "70.000đ",
                            "Universal Pictures", "01/07/2022", "4.3/5",
                            "Những chú Minion tinh nghịch tiếp tục chuyến phiêu lưu đầy tiếng cười cùng Gru thời trẻ.",
                            180);
                    break;
                case 3:
                    putPhim(intent, "The Batman", "21:00", "85.000đ",
                            "Warner Bros", "04/03/2022", "4.5/5",
                            "Batman phải đối mặt với kẻ giết người hàng loạt The Riddler để bảo vệ thành phố Gotham.",
                            170);
                    break;
                case 4:
                    putPhim(intent, "Doctor Strange 2", "17:45", "95.000đ",
                            "Marvel Studios", "06/05/2022", "4.6/5",
                            "Phù thủy tối thượng bước vào đa vũ trụ hỗn loạn để ngăn chặn thảm họa siêu nhiên.",
                            190);
                    break;
                case 5:
                    putPhim(intent, "Spider-Man: No Way Home", "20:30", "100.000đ",
                            "Marvel Studios", "17/12/2021", "4.9/5",
                            "Peter Parker nhờ Doctor Strange giúp đỡ, mở ra đa vũ trụ với nhiều kẻ thù cũ quay trở lại.",
                            220);
                    break;
            }
            startActivity(intent);
        });

        // 🔹 Xử lý 2 nút điều hướng
        Button btnQuayLai = findViewById(R.id.btnQuayLai);
        Button btnHome    = findViewById(R.id.btnHome);

        btnQuayLai.setOnClickListener(v -> finish());

        btnHome.setOnClickListener(v -> {
            Intent homeIntent = new Intent(DanhSachPhimActivity.this, TrangChuActivity.class);
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        });
    }

    /** Tiện ích để gói dữ liệu phim */
    private void putPhim(Intent i, String ten, String gio, String gia, String nxb,
                         String ngayPhatHanh, String danhGia, String moTa, int soLuong) {
        i.putExtra("TEN_PHIM", ten);
        i.putExtra("GIO_CHIEU", gio);
        i.putExtra("GIA_VE", gia);
        i.putExtra("NXB", nxb);
        i.putExtra("NGAY_PHAT_HANH", ngayPhatHanh);
        i.putExtra("DANH_GIA", danhGia);
        i.putExtra("MO_TA", moTa);
        i.putExtra("SO_LUONG_DA_DAT", soLuong);
    }
}
