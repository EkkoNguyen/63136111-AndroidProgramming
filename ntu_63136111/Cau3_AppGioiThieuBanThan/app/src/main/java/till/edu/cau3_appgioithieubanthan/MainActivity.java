package till.edu.cau3_appgioithieubanthan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView iconGitHub;
    public void goToUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iconGitHub= findViewById(R.id.icon_github);
        iconGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://github.com/EkkoNguyen/63136111-AndroidProgramming");
            }
        });
    }
}