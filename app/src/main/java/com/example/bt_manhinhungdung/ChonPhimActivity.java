package com.example.bt_manhinhungdung;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChonPhimActivity extends AppCompatActivity {
    Spinner spinnerPhim, spinnerNgay, spinnerGio, spinnerGhe;
    EditText edtSoLuong;
    ImageView imgPoster;
    Button btnDatVe;
    int posterRes = R.drawable.bgr_dv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_phim);

        spinnerPhim = findViewById(R.id.spinnerPhim);
        spinnerNgay = findViewById(R.id.spinnerNgay);
        spinnerGio = findViewById(R.id.spinnerGio);
        spinnerGhe = findViewById(R.id.spinnerGhe);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        btnDatVe = findViewById(R.id.btnDatVe);
        imgPoster = findViewById(R.id.imgPoster);

        String[] danhSachPhim = {
                "-- Chọn phim --",
                "Avengers: Endgame",
                "Avatar 2",
                "Minions 2",
                "The Batman",
                "Doctor Strange 2",
                "Spider-Man"
        };
        String[] danhSachNgay = {"-- Chọn ngày --", "26/09/2025", "27/09/2025", "28/09/2025", "29/09/2025", "30/09/2025"};
        String[] gioChieu     = {"-- Chọn giờ --", "17:00", "19:30", "21:00", "22:00"};
        String[] danhSachGhe  = {"-- Chọn ghế --", "A1", "A2", "B1", "B2", "C1", "C2", "D1", "D2"};

        spinnerPhim.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, danhSachPhim));
        spinnerNgay.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, danhSachNgay));
        spinnerGio.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, gioChieu));
        spinnerGhe.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, danhSachGhe));

        spinnerPhim.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, danhSachPhim));
        spinnerPhim.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tenPhim = parent.getItemAtPosition(position).toString();
                switch (tenPhim) {
                    case "Avengers: Endgame":
                        posterRes = R.drawable.avengersendgame; break;
                    case "Avatar 2":
                        posterRes = R.drawable.avatar2; break;
                    case "Minions 2":
                        posterRes = R.drawable.minion; break;
                    case "The Batman":
                        posterRes = R.drawable.batman; break;
                    case "Doctor Strange 2":
                        posterRes = R.drawable.docterstrange; break;
                    case "Spider-Man":
                        posterRes = R.drawable.spiderman; break;
                    default:
                        posterRes = R.drawable.bgr_dv; // ảnh mặc định
                }
                imgPoster.setImageResource(posterRes);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        btnDatVe = findViewById(R.id.btnDatVe);
        btnDatVe.setOnClickListener(v -> {
            if (spinnerPhim.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Vui lòng chọn phim!", Toast.LENGTH_SHORT).show(); return;
            }
            if (spinnerNgay.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Vui lòng chọn ngày chiếu!", Toast.LENGTH_SHORT).show(); return;
            }
            if (spinnerGio.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Vui lòng chọn giờ chiếu!", Toast.LENGTH_SHORT).show(); return;
            }
            if (spinnerGhe.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Vui lòng chọn ghế!", Toast.LENGTH_SHORT).show(); return;
            }

            String soLuongText = edtSoLuong.getText().toString().trim();
            if (TextUtils.isEmpty(soLuongText)) {
                Toast.makeText(this, "Vui lòng nhập số lượng vé!", Toast.LENGTH_SHORT).show(); return;
            }

            int soLuong;
            try {
                soLuong = Integer.parseInt(soLuongText);
                if (soLuong <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Số lượng phải > 0", Toast.LENGTH_SHORT).show(); return;
            }

            Intent i = new Intent(this, XacNhanVeActivity.class);
            i.putExtra("TEN_PHIM", spinnerPhim.getSelectedItem().toString());
            i.putExtra("NGAY_CHIEU", spinnerNgay.getSelectedItem().toString());
            i.putExtra("GIO_CHIEU", spinnerGio.getSelectedItem().toString());
            i.putExtra("GHE", spinnerGhe.getSelectedItem().toString());
            i.putExtra("SO_LUONG", soLuong);
            i.putExtra("POSTER_RES", posterRes);
            startActivity(i);
        });
    }
}
