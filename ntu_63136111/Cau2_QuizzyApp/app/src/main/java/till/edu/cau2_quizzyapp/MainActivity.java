package till.edu.cau2_quizzyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new ModelClass("Việt Nam hình gì?","S","O","B","D","S"));
        list.add(new ModelClass("2 + 2 = ?","1","2","3","4","4"));
        list.add(new ModelClass("5 + 5 = ?","5","6","7","10","10"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ManHinhChoiActivity.class);
                startActivity(intent);
            }
        },1500);
    }
}