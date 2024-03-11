package till.edu.ex5_addsubmuldiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button nutCong, nutTru, nutChia, nutNhan;
    void TimDieuKhien(){
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyCong();
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyTru();
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyNhan();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyChia();
            }
        });
    }
    public void XuLyCong(){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a + b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyTru(){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a - b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyNhan(){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a * b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyChia(){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a / b;
        edtKQ.setText(String.valueOf(tong));
    }
}