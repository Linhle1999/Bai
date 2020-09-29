package com.example.btthaygiaover1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private ImageView may1, may2, may3, nguoi1, nguoi2, nguoi3;
    private Button play, play1;
    private List<Integer> may, nguoi;
    private TextView nv1, nv2, txt1, txt2, counttime, txt, sonut1, sonut2, txtsonut1, txtdiem1, txtdiem2;
    private NumberPicker time, time2;
    private int[] labai = {
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
    private int end1 = 0, end2 = 0, check1 = 0, check2 = 0;

    private LinearLayout layouttren, layoutduoi, showtime;

    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert = new AlertDialog.Builder(this);
        getSupportActionBar().hide();

        may = new ArrayList<>();
        nguoi = new ArrayList<>();

        may1 = findViewById(R.id.may1);
        may2 = findViewById(R.id.may2);
        may3 = findViewById(R.id.may3);

        nguoi1 = findViewById(R.id.nguoi1);
        nguoi3 = findViewById(R.id.nguoi2);
        nguoi2 = findViewById(R.id.nguoi3);

        txt1 = findViewById(R.id.diem1);
        txt2 = findViewById(R.id.diem2);

        sonut1 = findViewById(R.id.sonut1);
        sonut2 = findViewById(R.id.sonut2);

        layouttren = findViewById(R.id.layouttren);
        layoutduoi = findViewById(R.id.layoutduoi);
        showtime = findViewById(R.id.showtime);

        nv1 = findViewById(R.id.nv1);
        nv2 = findViewById(R.id.nv2);

        counttime = findViewById(R.id.counttime);
        txt = findViewById(R.id.txt);
        showtime = findViewById(R.id.showtime);

        time = findViewById(R.id.phut);
        time2 = findViewById(R.id.giay);

        txtdiem1 = findViewById(R.id.txtdiem1);
        txtdiem2 = findViewById(R.id.txtdiem2);

        txtsonut1 = findViewById(R.id.txtsonut);
    }


    public void popupMenu(View v) {
        final PopupMenu popup = new PopupMenu(this, v);
        getMenuInflater().inflate(R.menu.menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuitem_p: {
                        MotNguoi();
                        return true;
                    }
                    case R.id.menuitem_pvc: {
                        NguoiVoiMay();
                        return true;
                    }
                    case R.id.menuitem_cvc: {
                        MayVoiMay();
                        return true;
                    }
                    case R.id.menuitem_thoat: {
                        finishAffinity();
                    }
                    default:
                        return false;
                }
            }
        });
    }

    public void MotNguoi() {
        XoaDuLieuBanDau();

        txt1.setVisibility(View.GONE);
        txt2.setVisibility(View.GONE);

        txtdiem1.setVisibility(View.GONE);
        txtdiem2.setVisibility(View.GONE);

        layouttren.setVisibility(View.VISIBLE);

        nv1.setText("3 lá bài của bạn: ");

        play.setVisibility(View.VISIBLE);
        play.setText("Rút bài");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                may = new ArrayList<>();

                while (may.size() < 3) {
                    int ran1 = new Random().nextInt(52) + 1;
                    if (!may.contains(ran1))
                        may.add(ran1);
                }
                //Gán lá bài lên UI
                may1.setImageResource(labai[may.get(0) - 1]);
                may2.setImageResource(labai[may.get(1) - 1]);
                may3.setImageResource(labai[may.get(2) - 1]);

                int flag = 0, diem = 0;

                //Tính số nút
                for (int x : may) {
                    if (x % 4 == 0)
                        x /= 4;
                    else x = x / 4 + 1;
                    if (x > 10) {
                        flag += 1;
                        x = 10;
                    }
                    diem += x;
                }
                if (flag == 3)
                    sonut1.setText("3 tiên");
                else if (diem % 10 == 0)
                    sonut1.setText("Bù");
                else if (diem % 10 != 0)
                    sonut1.setText(String.valueOf(diem % 10));
            }
        });

    }

    public void NguoiVoiMay() {
        XoaDuLieuBanDau();

        txt1.setVisibility(View.GONE);
        txt2.setVisibility(View.GONE);

        txtdiem1.setVisibility(View.GONE);
        txtdiem2.setVisibility(View.GONE);

        nv1.setText("Máy");
        nv2.setText("Người");

        check1 = check2 = 0;

        layoutduoi.setVisibility(View.VISIBLE);
        layouttren.setVisibility(View.VISIBLE);

        play.setVisibility(View.VISIBLE);
        play1.setVisibility(View.VISIBLE);

        play1.setText("Máy rút bài");
        play.setText("Người rút bài");

        may = new ArrayList<>();
        nguoi = new ArrayList<>();

        sonut1.setText("0");
        sonut2.setText("0");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0, j = 0;
                if (nguoi.size() < 3) {
                    int ran = 0;
                    do {
                        ran = new Random().nextInt(52) + 1;
                        if (may.contains(ran) || nguoi.contains(ran))
                            ran = 0;
                        else break;
                    } while (ran == 0);
                    nguoi.add(ran);

                    if (check1 == 0)
                        nguoi1.setImageResource(labai[ran - 1]);
                    else if (check1 == 1)
                        nguoi2.setImageResource(labai[ran - 1]);
                    else if (check1 == 2) {
                        nguoi3.setImageResource(labai[ran - 1]);

                        play.setEnabled(false);
                        play.setBackgroundColor(getResources().getColor(R.color.colorDisable));

                        //Tính số nút
                        for (int x : nguoi) {
                            if (x % 4 == 0)
                                x /= 4;
                            else x = x / 4 + 1;
                            if (x > 10) {
                                x = 10;
                            }
                            sonut2.setText(String.valueOf((Integer.parseInt(sonut2.getText().toString()) + x) % 10));
                        }

                        if (nguoi.get(0) >= 37 && nguoi.get(1) >= 37 && nguoi.get(2) >= 37)
                            sonut2.setText("3 tiên");
                    }

                    check1++;
                }
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 0, diem = 0;
                if (may.size() < 3) {
                    int ran = 0;
                    do {
                        ran = new Random().nextInt(52) + 1;
                        if (may.contains(ran) || nguoi.contains(ran))
                            ran = 0;
                        else break;
                    } while (ran == 0);
                    may.add(ran);

                    if (check2 == 0)
                        may1.setImageResource(labai[ran - 1]);
                    else if (check2 == 1)
                        may2.setImageResource(labai[ran - 1]);
                    else if (check2 == 2) {
                        may3.setImageResource(labai[ran - 1]);

                        play1.setEnabled(false);
                        play1.setBackgroundColor(getResources().getColor(R.color.colorDisable));

                        //Tính số nút
                        for (int x : may) {
                            if (x % 4 == 0)
                                x /= 4;
                            else x = x / 4 + 1;
                            if (x > 10) {
                                flag += 1;
                                x = 10;
                            }
                            sonut1.setText(String.valueOf((Integer.parseInt(sonut1.getText().toString()) + x) % 10));
                        }

                        if (may.get(0) >= 37 && may.get(1) >= 37 && may.get(2) >= 37)
                            sonut1.setText("3 tiên");
                    }
                    check2++;
                }
            }
        });

        while (may.size() == 3 && nguoi.size() == 3) {
            int a = 0, b = 0;

            if (sonut1.getText().toString().equals("3 tiên"))
                a = 10;
            else if (sonut1.getText().toString().equals("Bù"))
                a = -1;
            else a = Integer.parseInt(sonut1.getText().toString());

            if (sonut2.getText().toString().equals("3 tiên"))
                b = 10;
            else if (sonut2.getText().toString().equals("Bù"))
                b = -1;
            else b = Integer.parseInt(sonut2.getText().toString());


            if (a > b)
                alert.setMessage(nv1.getText().toString() + " thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();
            else
                alert.setMessage(nv2.getText().toString() + " thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();
        }
    }

    public void MayVoiMay() {
        XoaDuLieuBanDau();

        txt1.setVisibility(View.VISIBLE);
        txtdiem1.setVisibility(View.VISIBLE);

        nv1.setText("Máy 1");
        nv2.setText("Máy 2");

        layoutduoi.setVisibility(View.VISIBLE);
        layouttren.setVisibility(View.VISIBLE);

        NumberPickShow();

        may = new ArrayList<>();
        nguoi = new ArrayList<>();

        play.setVisibility(View.VISIBLE);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                play.setEnabled(false);
                play.setBackgroundColor(getResources().getColor(R.color.colorDisable));
                end1 = end2 = 0;
                final long thoigianchay = TimeUnit.MILLISECONDS.convert(time.getValue(), TimeUnit.MINUTES)
                        + TimeUnit.MILLISECONDS.convert(time2.getValue(), TimeUnit.SECONDS);

                //Chạy đồng hồ đếm giờ
                new CountDownTimer(thoigianchay, 1000) {
                    public void onTick(long millisUntilFinished) {
                        counttime.setText(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)));
                    }

                    public void onFinish() {
                        Log.d("Ket thuc", String.valueOf(true));
                    }

                }.start();

                //Chạy với thời gian delay 5s
                new CountDownTimer(thoigianchay, 5000) {
                    public void onTick(long millisUntilFinished) {
                        int diem1 = 0, diem2 = 0;

//                        counttime.setText(String.valueOf(Integer.parseInt(counttime.getText().toString()) - 1));

                        may = new ArrayList<>();
                        nguoi = new ArrayList<>();

                        while (may.size() < 3 || nguoi.size() < 3) {
                            int ran1 = 0;
                            do {
                                ran1 = new Random().nextInt(52) + 1;
                                if (may.contains(ran1) || nguoi.contains(ran1))
                                    ran1 = 0;
                                else break;
                            } while (ran1 == 0);

                            if (may.size() < 3)
                                may.add(ran1);
                            else if (nguoi.size() < 3)
                                nguoi.add(ran1);
                        }
                        //Gán lá bài lên UI
                        may1.setImageResource(labai[may.get(0) - 1]);
                        may2.setImageResource(labai[may.get(1) - 1]);
                        may3.setImageResource(labai[may.get(2) - 1]);
                        nguoi1.setImageResource(labai[nguoi.get(0) - 1]);
                        nguoi2.setImageResource(labai[nguoi.get(1) - 1]);
                        nguoi3.setImageResource(labai[nguoi.get(2) - 1]);

                        int flag1 = 0, flag2 = 0;

                        //Tính số nút
                        for (int x : may) {
                            if (x % 4 == 0)
                                x /= 4;
                            else x = x / 4 + 1;
                            if (x > 10) {
                                flag1 += 1;
                                x = 10;
                            }
                            diem1 += x;
                        }
                        for (int x : nguoi) {
                            if (x % 4 == 0)
                                x /= 4;
                            else x = x / 4 + 1;
                            if (x > 10) {
                                flag2 += 1;
                                x = 10;
                            }
                            diem2 += x;
                        }
                        //Check ai lớn hơn
                        if (flag1 == 3 && flag2 == 3) {
                            Snackbar.make(v, "Hòa", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                            sonut1.setText(String.valueOf("3 tiên"));
                            sonut2.setText(String.valueOf("3 tiên"));
                        } else if (flag1 == 3 && flag2 != 3) {
                            Snackbar.make(v, nv1.getText().toString() + " thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                            sonut1.setText("3 tiên");
                            sonut2.setText(String.valueOf(diem2 % 10));
                            end1 += 1;
                        } else if (flag1 != 3 && flag2 == 3) {
                            Snackbar.make(v, nv2.getText().toString() + " thắng", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
                            sonut1.setText(String.valueOf(diem1 % 10));
                            sonut2.setText("3 tiên");
                            end2 += 1;
                        } else {
                            if (diem1 % 10 > diem2 % 10) {
                                Snackbar.make(v, nv1.getText().toString() + " thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                                sonut1.setText(String.valueOf(diem1 % 10));
                                sonut2.setText(String.valueOf(diem2 % 10));
                                end1 += 1;
                                if (diem2 % 10 == 0) sonut2.setText("Bù");
                            } else if (diem1 % 10 < diem2 % 10) {
                                Snackbar.make(v, nv2.getText().toString() + " thắng", BaseTransientBottomBar.LENGTH_LONG).show();
                                sonut1.setText(String.valueOf(diem1 % 10));
                                sonut2.setText(String.valueOf(diem2 % 10));
                                end2 += 1;
                                if (diem1 % 10 == 0) sonut1.setText("Bù");
                            } else if (diem1 % 10 == diem2 % 10) {
                                Snackbar.make(v, "Hòa", BaseTransientBottomBar.LENGTH_LONG).show();
                                sonut1.setText(String.valueOf(diem1 % 10));
                                sonut2.setText(String.valueOf(diem2 % 10));
                                if (diem1 % 10 == 0) {
                                    sonut1.setText("Bù");
                                    sonut2.setText("Bù");
                                }
                            }
                        }
                        txt1.setText(String.valueOf(end1));
                        txt2.setText(String.valueOf(end2));
                    }

                    public void onFinish() {
                        int diem1 = Integer.parseInt(txt1.getText().toString()), diem2 = Integer.parseInt(txt2.getText().toString());
                        if (diem1 > diem2)
                            alert.setMessage(nv1.getText().toString() + " thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();
                        else if (diem1 < diem2)
                            alert.setMessage(nv2.getText().toString() + " thắng!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();
                        else
                            alert.setMessage("Hòa!").setTitle("Thông báo").setPositiveButton("OK", null).create().show();

                        may1.setImageDrawable(null);
                        may2.setImageDrawable(null);
                        may3.setImageDrawable(null);
                        nguoi1.setImageDrawable(null);
                        nguoi2.setImageDrawable(null);
                        nguoi3.setImageDrawable(null);

                        sonut1.setText("");
                        sonut2.setText("");

                        txt1.setText("");
                        txt2.setText("");

                        play.setEnabled(true);
                        play.setBackgroundColor(getResources().getColor(R.color.colorButton));
                    }

                }.start();
            }
        });

    }

    public void XoaDuLieuBanDau() {
        may1.setImageDrawable(null);
        may2.setImageDrawable(null);
        may3.setImageDrawable(null);
        nguoi1.setImageDrawable(null);
        nguoi2.setImageDrawable(null);
        nguoi3.setImageDrawable(null);

        sonut1.setText("");
        sonut2.setText("");

        txt1.setText("");
        txt2.setText("");

        layouttren.setVisibility(View.GONE);
        layoutduoi.setVisibility(View.GONE);
        showtime.setVisibility(View.GONE);

        txt.setVisibility(View.GONE);
        counttime.setVisibility(View.GONE);

        play = findViewById(R.id.play);
        play1 = findViewById(R.id.play1);

        play.setVisibility(View.GONE);
        play1.setVisibility(View.GONE);

        play.setEnabled(true);
        play.setBackgroundColor(getResources().getColor(R.color.colorButton));

        play1.setEnabled(true);
        play1.setBackgroundColor(getResources().getColor(R.color.colorButton));
    }

    public void NumberPickShow() {
        counttime.setVisibility(View.VISIBLE);
        txt.setVisibility(View.VISIBLE);
        showtime.setVisibility(View.VISIBLE);

        //Set the minimum value of NumberPicker
//        time.setMinValue(0);
        time2.setMinValue(1);
        //Specify the maximum value/number of NumberPicker
//        time.setMaxValue(60);
        time2.setMaxValue(60);
        //Gets whether the selector wheel wraps when reaching the min/max value.
//        time.setWrapSelectorWheel(true);
        time2.setWrapSelectorWheel(true);
    }
}