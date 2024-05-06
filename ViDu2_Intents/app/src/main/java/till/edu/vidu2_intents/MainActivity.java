package till.edu.vidu2_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NhapLieu(View v){
        Intent intent = new Intent(this, NhapLieuActivity.class);
        startActivityForResult(intent, 8000);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 8000){
            if(resultCode == RESULT_OK){
                String hoTen = data.getStringExtra("HT");
                int namSinh = data.getIntExtra("NS", 0);

                TextView tvHT = findViewById(R.id.hoTen);
                TextView tvNS = findViewById(R.id.namSinh);
                tvHT.setText(hoTen);
                tvNS.setText(String.valueOf(namSinh));
            }
            else {
                Toast.makeText(this, "Trả về thất bại", Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}