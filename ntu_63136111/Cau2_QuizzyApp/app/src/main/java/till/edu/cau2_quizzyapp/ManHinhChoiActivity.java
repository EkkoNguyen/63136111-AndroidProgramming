package till.edu.cau2_quizzyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class ManHinhChoiActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int time = 20;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_choi);

        progressBar = findViewById(R.id.quiz_timer);
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
}