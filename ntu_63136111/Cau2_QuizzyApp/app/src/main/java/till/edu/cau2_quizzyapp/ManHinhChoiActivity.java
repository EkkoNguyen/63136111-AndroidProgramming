package till.edu.cau2_quizzyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ManHinhChoiActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int time = 20;
    ProgressBar progressBar;
    ArrayList<ModelClass> danhSachCauHoi;
    ModelClass modelClass;
    int index = 0;
    TextView cardQuestion, optionA, optionB,optionC, optionD;
    CardView cardA, cardB, cardC, cardD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_choi);
        TimDieuKhien();
        this.danhSachCauHoi = danhSachCauHoi;
        Collections.shuffle(danhSachCauHoi);
        modelClass = danhSachCauHoi.get(index);
        caiDatCauHoi();
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                time = time - 1;
                progressBar.setProgress(time);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(ManHinhChoiActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.man_hinh_overtime_dialog);
                dialog.findViewById(R.id.btn_choiLai).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ManHinhChoiActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
    }

    private void caiDatCauHoi() {
        cardQuestion.setText(modelClass.getCauhoi());
        optionA.setText(modelClass.dapAnA);
        optionB.setText(modelClass.dapAnB);
        optionC.setText(modelClass.dapAnC);
        optionD.setText(modelClass.dapAnD);

    }

    private void TimDieuKhien() {
        progressBar = findViewById(R.id.quiz_timer);
        cardQuestion = findViewById(R.id.card_question);
        optionA = findViewById(R.id.card_optionA);
        optionB = findViewById(R.id.card_optionB);
        optionC = findViewById(R.id.card_optionC);
        optionD = findViewById(R.id.card_optionD);

        cardA = findViewById(R.id.cardA);
        cardB = findViewById(R.id.cardB);
        cardC = findViewById(R.id.cardC);
        cardD = findViewById(R.id.cardD);
    }
}