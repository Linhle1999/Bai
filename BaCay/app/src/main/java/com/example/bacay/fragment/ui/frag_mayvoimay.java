package com.example.bacay.fragment.ui;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bacay.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class frag_mayvoimay extends Fragment {
    private Button btn, btnStop;
    private ImageView[] labai = new ImageView[6];
    private List<Integer> danhSachLaBaiMay1, danhSachLaBaiMay2, fullLaBai;
    private NumberPicker thoiGianChayPicker;

    private int soVanThangCuaMay1, soVanThangCuaMay2, currentPage;

    private TextView soNutCuaMay1, soNutCuaMay2, diemCuaMay1, diemCuaMay2;

    private AlertDialog.Builder alert;

    private TabLayout tabLayout;

    private long thoiGianChay;

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
        View view = inflater.inflate(R.layout.ui_mayvsmay, container, false);

        tabLayout = view.findViewById(R.id.tabs);



        labai[0] = view.findViewById(R.id.tabmayvsmay_labai1);
        labai[1] = view.findViewById(R.id.tabmayvsmay_labai2);
        labai[2] = view.findViewById(R.id.tabmayvsmay_labai3);
        labai[3] = view.findViewById(R.id.tabmayvsmay_labai4);
        labai[4] = view.findViewById(R.id.tabmayvsmay_labai5);
        labai[5] = view.findViewById(R.id.tabmayvsmay_labai6);

        for (int i = 0; i < 6; i++)
            labai[i].setImageResource(R.drawable.b_matsau);

        alert = new AlertDialog.Builder(getContext());

        soNutCuaMay1 = view.findViewById(R.id.tabmayvsmay_sonutmay1);
        soNutCuaMay2 = view.findViewById(R.id.tabmayvsmay_sonutmay2);

        diemCuaMay1 = view.findViewById(R.id.tabmayvsmay_diemmay1);
        diemCuaMay2 = view.findViewById(R.id.tabmayvsmay_diemmay2);

        thoiGianChayPicker = view.findViewById(R.id.tabmayvsmay_thoigianchay);

        thoiGianChayPicker.setMinValue(1);
        thoiGianChayPicker.setMaxValue(60);

        thoiGianChayPicker.setWrapSelectorWheel(true);

        btn = view.findViewById(R.id.tabmayvsmay_button);
        btnStop = view.findViewById(R.id.tabmayvsmay_buttonStop);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(false);
                btn.setBackgroundColor(Color.parseColor("#7AACA7"));

                btnStop.setEnabled(true);
                btnStop.setBackgroundColor(Color.parseColor("#F44336"));

                thoiGianChay = TimeUnit.MILLISECONDS.convert(thoiGianChayPicker.getValue(), TimeUnit.SECONDS);

                DemNguocThoiGian(thoiGianChay);

                Automatic(thoiGianChay, 2);
            }
        });
        return view;
    }

    private void DemNguocThoiGian(long thoigianchay) {
        new CountDownTimer(thoigianchay, 1000) {
            public void onTick(long millisUntilFinished) {
                thoiGianChayPicker.setValue(Integer.parseInt(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))));



//                Log.d("ONIONO",String.valueOf(tabLayout.getSelectedTabPosition()));

                btnStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thoiGianChayPicker.setValue(1);
                        cancel();
                    }
                });
            }

            public void onFinish() {
                thoiGianChayPicker.setValue(1);
            }

        }.start();
    }

    private void Automatic(long thoigianchay, int delay) {
        long delayTime = delay * 1000;
        soVanThangCuaMay1 = soVanThangCuaMay2 = 0;
        new CountDownTimer(thoigianchay, delayTime) {
            public void onTick(long millisUntilFinished) {
//                if (tabLayout.getSelectedTabPosition() == 0 || tabLayout.getSelectedTabPosition() == 1) {
//                    thoiGianChayPicker.setValue(1);
//                    cancel();
//                }

                int diem1 = 0, diem2 = 0;

                if (!diemCuaMay1.getText().toString().equals(""))
                    diem1 = Integer.parseInt(diemCuaMay1.getText().toString());

                if (!diemCuaMay2.getText().toString().equals(""))
                    diem2 = Integer.parseInt(diemCuaMay2.getText().toString());

                danhSachLaBaiMay1 = new ArrayList<>();
                danhSachLaBaiMay2 = new ArrayList<>();

                fullLaBai = new ArrayList<>();

                while (fullLaBai.size() < 6) {
                    int ran = 0;
                    do {
                        ran = new Random().nextInt(51) + 0;
                        if (fullLaBai.contains(ran))
                            ran = 0;
                        else break;
                    } while (ran == 0);

                    if (danhSachLaBaiMay1.size() < 3)
                        danhSachLaBaiMay1.add(ran);
                    else if (danhSachLaBaiMay2.size() < 3)
                        danhSachLaBaiMay2.add(ran);

                    fullLaBai.add(ran);
                }

                //Gán lá bài lên UI
                int j = 0;
                for (int i : fullLaBai) {
                    labai[j++].setImageResource(imglabai[i]);
                }
                int flag1 = 0, flag2 = 0;

                //Tính số nút
                for (int x : danhSachLaBaiMay1) {
                    x = x / 4 + 1;
                    if (x > 10) {
                        flag1++;
                        x = 10;
                    }
                    diem1 += x;
                }
                for (int x : danhSachLaBaiMay2) {
                    x = x / 4 + 1;
                    if (x > 10) {
                        flag2++;
                        x = 10;
                    }
                    diem2 += x;
                }

                //Check ai lớn hơn
                if (flag1 == 3 && flag2 == 3) {
                    Snackbar.make(getView(), "Hòa", BaseTransientBottomBar.LENGTH_LONG).show();
                    soNutCuaMay1.setText("3 tiên");
                    soNutCuaMay2.setText("3 tiên");
                } else if (flag1 == 3 && flag2 != 3) {
                    Snackbar.make(getView(), "Máy 1 thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                    soNutCuaMay1.setText("3 tiên");
                    soNutCuaMay2.setText(String.valueOf(diem2 % 10));
                    soVanThangCuaMay1++;
                } else if (flag1 != 3 && flag2 == 3) {
                    Snackbar.make(getView(), "Máy 2 thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                    soNutCuaMay1.setText(String.valueOf(diem1 % 10));
                    soNutCuaMay2.setText("3 tiên");
                    soVanThangCuaMay2++;
                } else {
                    if (diem1 % 10 > diem2 % 10) {
                        Snackbar.make(getView(), "Máy 1 thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                        soNutCuaMay1.setText(String.valueOf(diem1 % 10));
                        soNutCuaMay2.setText(String.valueOf(diem2 % 10));
                        soVanThangCuaMay1++;
                        if (diem2 % 10 == 0) soNutCuaMay2.setText("Bù");
                    } else if (diem1 % 10 < diem2 % 10) {
                        Snackbar.make(getView(), "Máy 2 thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                        soNutCuaMay1.setText(String.valueOf(diem1 % 10));
                        soNutCuaMay2.setText(String.valueOf(diem2 % 10));
                        soVanThangCuaMay2++;
                        if (diem1 % 10 == 0) soNutCuaMay1.setText("Bù");
                    } else if (diem1 % 10 == diem2 % 10) {
                        Snackbar.make(getView(), "Hòa", BaseTransientBottomBar.LENGTH_LONG).show();
                        soNutCuaMay1.setText(String.valueOf(diem1 % 10));
                        soNutCuaMay2.setText(String.valueOf(diem2 % 10));
                        if (diem1 % 10 == 0) {
                            soNutCuaMay1.setText("Bù");
                            soNutCuaMay2.setText("Bù");
                        }
                    }
                }
                diemCuaMay1.setText(String.valueOf(soVanThangCuaMay1));
                diemCuaMay2.setText(String.valueOf(soVanThangCuaMay2));

                btnStop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onFinish();
                        cancel();
                    }
                });
            }

            public void onFinish() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int diem1 = Integer.parseInt(diemCuaMay1.getText().toString()), diem2 = Integer.parseInt(diemCuaMay2.getText().toString());
                if (diem1 > diem2)
                    alert.setMessage("Số điểm của Máy 1: " + diem1 + "\nSố điểm của Máy 2: " + diem2 + "\nMáy 1 thắng!").setPositiveButton("OK", null).create().show();
                else if (diem1 < diem2)
                    alert.setMessage("Số điểm của Máy 1: " + diem1 + "\nSố điểm của Máy 2: " + diem2 + "\nMáy 2 thắng!").setPositiveButton("OK", null).create().show();
                else
                    alert.setMessage("Số điểm của Máy 1: " + diem1 + "\nSố điểm của Máy 2: " + diem2 + "\nHòa!").setPositiveButton("OK", null).create().show();

                for (int i = 0; i < 6; i++)
                    labai[i].setImageResource(R.drawable.b_matsau);

                soNutCuaMay1.setText("");
                soNutCuaMay2.setText("");

                diemCuaMay1.setText("0");
                diemCuaMay2.setText("0");

                btn.setEnabled(true);
                btn.setBackgroundColor(Color.parseColor("#009688"));

                btnStop.setEnabled(false);
                btnStop.setBackgroundColor(Color.parseColor("#D1908B"));
            }
        }.start();
    }

}
