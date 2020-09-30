package com.example.bacay.fragment.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bacay.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class frag_1nguoichoi extends Fragment {
    private Button btn;
    private ImageView[] labai = new ImageView[3];
    private List<Integer> danhSachLaBai;

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
        View view = inflater.inflate(R.layout.ui_motnguoi, container, false);

        labai[0] = view.findViewById(R.id.tab1nguoichoi_labai1);
        labai[1] = view.findViewById(R.id.tab1nguoichoi_labai2);
        labai[2] = view.findViewById(R.id.tab1nguoichoi_labai3);

        for (int i = 0; i < 3; i++)
            labai[i].setImageResource(R.drawable.b_matsau);

        btn = view.findViewById(R.id.tab1nguoichoi_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danhSachLaBai = new ArrayList<>();
                String sonut = "";
                while (danhSachLaBai.size() < 3) {
                    int ran = new Random().nextInt(52) + 1;
                    if (!danhSachLaBai.contains(ran))
                        danhSachLaBai.add(ran);
                }
                //Gán lá bài lên UI
                for (int i = 0; i < 3; i++) {
                    labai[i].setImageResource(imglabai[danhSachLaBai.get(i) - 1]);
                }

                int flag = 0, diem = 0;

                //Tính số nút
                for (int x : danhSachLaBai) {
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
                    sonut = "3 tiên";
                else if (diem % 10 == 0)
                    sonut = "Bù";
                else if (diem % 10 != 0)
                    sonut = String.valueOf(diem % 10);

                Snackbar.make(getView(), "Số nút: " + sonut, Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
