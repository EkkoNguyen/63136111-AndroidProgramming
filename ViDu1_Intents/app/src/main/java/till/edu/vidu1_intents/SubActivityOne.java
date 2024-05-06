package till.edu.vidu1_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivityOne extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
    }

    public void QuayVe(View view){
        Intent iManHinhChinh = new Intent(SubActivityOne.this, MainActivity.class);
        startActivity(iManHinhChinh);
    }
}
