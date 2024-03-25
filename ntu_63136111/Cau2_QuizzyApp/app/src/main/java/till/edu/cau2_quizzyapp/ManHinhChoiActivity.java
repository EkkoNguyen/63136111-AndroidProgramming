package till.edu.cau2_quizzyapp;

import static till.edu.cau2_quizzyapp.MainActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
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
    int soDapAnDung = 0, soDapAnSai = 0;
    LinearLayout btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_choi);

        TimDieuKhien();

        danhSachCauHoi = list;
        Collections.shuffle(danhSachCauHoi);
        modelClass = danhSachCauHoi.get(index);

        resetColorBtn();

        btnNext.setClickable(false);

        startTimer(20);

        caiDatCauHoi();
    }
    public void startTimer(int i){
        time = i;
        countDownTimer = new CountDownTimer(time * 1000, 1000) {
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
                    public void onClick(View v) {
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
        optionA.setText(modelClass.getDapAnA());
        optionB.setText(modelClass.getDapAnB());
        optionC.setText(modelClass.getDapAnC());
        optionD.setText(modelClass.getDapAnD());
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
        btnNext = findViewById(R.id.btn_next);
    }

    public void chonDapAnDung(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.green));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soDapAnDung++;
                if(index < danhSachCauHoi.size() - 1){
                    index++;
                    modelClass = danhSachCauHoi.get(index);
                    resetColorBtn();
                    enableAllBtn();
                    caiDatCauHoi();
                    countDownTimer.cancel();
                    startTimer(20);
                }else {
                    Win();
                }
            }
        });
    }

    public void chonDapAnSai(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.red));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soDapAnSai++;
                if(index < danhSachCauHoi.size() - 1){
                    index++;
                    modelClass = danhSachCauHoi.get(index);
                    resetColorBtn();
                    enableAllBtn();
                    caiDatCauHoi();
                    countDownTimer.cancel();
                    startTimer(20);
                }else {
                    Win();
                }
            }
        });
    }

    private void Win() {
    Intent intent = new Intent(ManHinhChoiActivity.this, WinActivity.class);
    intent.putExtra("dung",soDapAnDung);
    intent.putExtra("Sai",soDapAnSai);
    startActivity(intent);
    }

    public void enableAllBtn(){
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }
    public void disableAllBtn(){
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }
    public void resetColorBtn(){
        cardA.setBackgroundColor(getResources().getColor(R.color.white));
        cardB.setBackgroundColor(getResources().getColor(R.color.white));
        cardC.setBackgroundColor(getResources().getColor(R.color.white));
        cardD.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void optionAClick(View v){
        disableAllBtn();
        btnNext.setClickable(true);
        if(modelClass.getDapAnA().equals(modelClass.getDapAnDung())){
            chonDapAnDung(cardA);
        }else{
            chonDapAnSai(cardA);
        }
    }
    public void optionBClick(View v){
        disableAllBtn();
        btnNext.setClickable(true);
        if(modelClass.getDapAnB().equals(modelClass.getDapAnDung())){
            chonDapAnDung(cardB);
        }else{
            chonDapAnSai(cardB);
        }
    }
    public void optionCClick(View v){
        disableAllBtn();
        btnNext.setClickable(true);
        if(modelClass.getDapAnC().equals(modelClass.getDapAnDung())){
            chonDapAnDung(cardC);
        }else{
            chonDapAnSai(cardC);
        }
    }
    public void optionDClick(View v){
        disableAllBtn();
        btnNext.setClickable(true);
        if(modelClass.getDapAnD().equals(modelClass.getDapAnDung())){
            chonDapAnDung(cardD);
        }else{
            chonDapAnSai(cardD);
        }
    }
}