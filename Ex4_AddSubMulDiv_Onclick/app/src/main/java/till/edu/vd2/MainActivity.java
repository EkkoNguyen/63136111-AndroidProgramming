package till.edu.vd2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    void TimDieuKhien(){
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        edtKQ = (EditText) findViewById(R.id.edtKQ);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }
    public void XuLyCong(View v){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a + b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyTru(View v){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a - b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyNhan(View v){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a * b;
        edtKQ.setText(String.valueOf(tong));
    }
    public void XuLyChia(View v){
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double tong = a / b;
        edtKQ.setText(String.valueOf(tong));
    }
}