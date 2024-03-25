package till.edu.cau2_quizzyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<ModelClass> danhSachCauHoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhSachCauHoi = new ArrayList<>();
        danhSachCauHoi.add(new ModelClass("Việt Nam hình gì?","S","O","B","D","S"));
        danhSachCauHoi.add(new ModelClass("2 + 2 = ?","1","2","3","4","4"));
        danhSachCauHoi.add(new ModelClass("5 + 5 = ?","5","6","7","10","10"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ManHinhChoiActivity.class);
                startActivity(intent);
            }
        },1500);
    }
}