package till.edu.vidu2_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NhapLieuActivity extends AppCompatActivity{
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_lieu);
        btn1 = findViewById(R.id.btnAccept);
        btn2 = findViewById(R.id.btnCancel);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhapQuayVe(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }



    public void nhapQuayVe(View v){
        EditText edHT =(EditText) findViewById(R.id.txtHoVaTen);
        EditText edNS =(EditText) findViewById(R.id.txtNamSinh);

        String hoTen = edHT.getText().toString();
        int namSinh = Integer.parseInt(edNS.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("HT", hoTen);
        intent.putExtra("NS", namSinh);

        setResult(RESULT_OK, intent);

        finish();
    }
}