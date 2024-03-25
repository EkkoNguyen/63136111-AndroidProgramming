package till.edu.cau2_quizzyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WinActivity extends AppCompatActivity {
    CircularProgressBar circularprogressbar;
    TextView ketQua;
    LinearLayout btnChoiLai;
    int soDapAndung, soDapAnSai;
    TextView btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        btnChoiLai = findViewById(R.id.btn_choiLai);
        circularprogressbar = findViewById(R.id.circularProgressBar);
        ketQua = findViewById(R.id.ket_qua);
        btnExit = findViewById(R.id.exit);
        soDapAndung = getIntent().getIntExtra("dung",0);
        soDapAnSai = getIntent().getIntExtra("sai",0);
        circularprogressbar.setProgress(soDapAndung);
        ketQua.setText(soDapAndung+"/8");
    }
    public void onClickBtnChoiLai(){
        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WinActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onClickExit(){
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}