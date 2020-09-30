package com.example.bacay.fragment.ui;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bacay.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class frag_mayvoinguoi extends Fragment {
    private Button buttonmayrut, buttonnguoirut;
    private ImageView[] labai = new ImageView[6];

    private List<Integer> danhSachLaBaiMay, danhSachLaBaiNguoi;

    private TextView soNutCuaMay, soNutCuaNguoi;

    private AlertDialog.Builder alert;

    private int[] imglabai = {
            R.drawable.b_1_1, R.drawable.b_1_2, R.drawable.b_1_3, R.drawable.b_1_4,
            R.drawable.b_2_1, R.drawable.b_2_2, R.drawable.b_2_3, R.drawable.b_2_4,
            R.drawable.b_3_1, R.drawable.b_3_2, R.drawable.b_3_3, R.drawable.b_3_4,
            R.drawable.b_4_1, R.drawable.b_4_2, R.drawable.b_4_3, R.drawable.b_4_4,
            R.drawable.b_5_1, R.drawable.b_5_2, R.drawable.b_5_3, R.drawable.b_5_4,
            R.drawable.b_6_1, R.drawable.b_6_2, R.drawable.b_6_3, R.drawable.b_6_4,
            R.drawable.b_7_1, R.drawable.b_7_2, R.drawable.b_7_3, R.drawable.b_7_4,
            R.drawable.b_8_1, R.drawable.b_8_2, R.drawable.b_8_3, R.drawable.b_8_4,
            R.drawable.b_9_1, R.drawable.b_9_2, R.drawable.b_9_3, R.drawable.b_9_4,
            R.drawable.b_10_1, R.drawable.b_10_2, R.drawable.b_10_3, R.drawable.b_10_4,
            R.drawable.b_11_1, R.drawable.b_11_2, R.drawable.b_11_3, R.drawable.b_11_4,
            R.drawable.b_12_1, R.drawable.b_12_2, R.drawable.b_12_3, R.drawable.b_12_4,
            R.drawable.b_13_1, R.drawable.b_13_2, R.drawable.b_13_3, R.drawable.b_13_4
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_mayvsnguoi, container, false);

        alert = new AlertDialog.Builder(getContext());

        buttonmayrut = view.findViewById(R.id.tabmayvsnguoi_buttonmayrut);
        buttonnguoirut = view.findViewById(R.id.tabmayvsnguoi_buttonnguoirut);

        soNutCuaMay = view.findViewById(R.id.tabmayvsnguoi_sonutcuamay);
        soNutCuaNguoi = view.findViewById(R.id.tabmayvsnguoi_sonutcuanguoi);

        labai[0] = view.findViewById(R.id.tabmayvsnguoi_labai1);
        labai[1] = view.findViewById(R.id.tabmayvsnguoi_labai2);
        labai[2] = view.findViewById(R.id.tabmayvsnguoi_labai3);
        labai[3] = view.findViewById(R.id.tabmayvsnguoi_labai4);
        labai[4] = view.findViewById(R.id.tabmayvsnguoi_labai5);
        labai[5] = view.findViewById(R.id.tabmayvsnguoi_labai6);

        for (int i = 0; i < 6; i++)
            labai[i].setImageResource(R.drawable.b_matsau);

        danhSachLaBaiMay = new ArrayList<>();
        danhSachLaBaiNguoi = new ArrayList<>();

        buttonmayrut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                if (danhSachLaBaiMay.size() < 3) {
                    int ran = 0;
                    do {
                        ran = new Random().nextInt(51) + 0;
                        if (danhSachLaBaiMay.contains(ran) || danhSachLaBaiNguoi.contains(ran))
                            ran = 0;
                        else break;
                    } while (ran == 0);
                    danhSachLaBaiMay.add(ran);

                    labai[danhSachLaBaiMay.size() - 1].setImageResource(imglabai[danhSachLaBaiMay.get(danhSachLaBaiMay.size() - 1)]);

                    if (danhSachLaBaiMay.size() == 3) {
                        buttonmayrut.setEnabled(false);
                        buttonmayrut.setBackgroundColor(Color.parseColor("#7EB3CC"));

                        //Tính số nút
                        for (int x : danhSachLaBaiMay) {
                            x = x / 4 + 1;
                            if (x > 10) {
                                i++;
                                x = 10;
                            }
                            soNutCuaMay.setText(String.valueOf((Integer.parseInt(soNutCuaMay.getText().toString()) + x) % 10));
                        }

                        if (i == 3)
                            soNutCuaMay.setText("3 tiên");
                    }

                }
                ThongBaoKetQua();
            }
        });

        buttonnguoirut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                if (danhSachLaBaiNguoi.size() < 3) {
                    int ran = 0;
                    do {
                        ran = new Random().nextInt(51) + 0;
                        if (danhSachLaBaiMay.contains(ran) || danhSachLaBaiNguoi.contains(ran))
                            ran = 0;
                        else break;
                    } while (ran == 0);
                    danhSachLaBaiNguoi.add(ran);

                    labai[danhSachLaBaiNguoi.size() + 2].setImageResource(imglabai[danhSachLaBaiNguoi.get(danhSachLaBaiNguoi.size() - 1)]);

                    if (danhSachLaBaiNguoi.size() == 3) {
                        buttonnguoirut.setEnabled(false);
                        buttonnguoirut.setBackgroundColor(Color.parseColor("#7EB3CC"));

                        //Tính số nút
                        for (int x : danhSachLaBaiNguoi) {
                            x = x / 4 + 1;
                            if (x > 10) {
                                i++;
                                x = 10;
                            }
                            soNutCuaNguoi.setText(String.valueOf((Integer.parseInt(soNutCuaNguoi.getText().toString()) + x) % 10));
                        }

                        if (i == 3)
                            soNutCuaNguoi.setText("3 tiên");
                    }

                }

                ThongBaoKetQua();
            }
        });


        return view;
    }

    private void ThongBaoKetQua() {
        if (danhSachLaBaiNguoi.size() == 3 && danhSachLaBaiMay.size() == 3) {
            int a = 0, b = 0;

            if (!soNutCuaNguoi.getText().toString().equals(""))
                if (soNutCuaNguoi.getText().toString().equals("3 tiên"))
                    a = 10;
                else if (soNutCuaNguoi.getText().toString().equals("Bù"))
                    a = -1;
                else a = Integer.parseInt(soNutCuaNguoi.getText().toString());

            if (!soNutCuaMay.getText().toString().equals(""))
                if (soNutCuaMay.getText().toString().equals("3 tiên"))
                    b = 10;
                else if (soNutCuaMay.getText().toString().equals("Bù"))
                    b = -1;
                else b = Integer.parseInt(soNutCuaMay.getText().toString());

            if (a > b)
                alert.setMessage("Số nút của Máy: " + soNutCuaMay.getText().toString() + "\nSố nút của Người: " + soNutCuaNguoi.getText().toString() + "\nNgười thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();
            else
                alert.setMessage("Số nút của Máy: " + soNutCuaMay.getText().toString() + "\nSố nút của Người: " + soNutCuaNguoi.getText().toString() + "\nMáy thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();

            for (int i = 0; i < 6; i++)
                labai[i].setImageResource(R.drawable.b_matsau);

            soNutCuaMay.setText("");
            soNutCuaNguoi.setText("");

            buttonmayrut.setEnabled(true);
            buttonmayrut.setBackgroundColor(Color.parseColor("#03A9F4"));

            buttonnguoirut.setEnabled(true);
            buttonnguoirut.setBackgroundColor(Color.parseColor("#009688"));

            danhSachLaBaiMay = new ArrayList<>();
            danhSachLaBaiNguoi = new ArrayList<>();
        }
    }
}
