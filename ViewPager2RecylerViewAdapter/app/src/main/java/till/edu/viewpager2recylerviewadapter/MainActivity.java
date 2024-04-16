package till.edu.viewpager2recylerviewadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> viewPagerData;

    ViewPager2 viewPager2Land;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerData = getDataForViewPager();
        viewPager2Land = findViewById(R.id.vp2Land);
        landScapeAdapter = new LandScapeAdapter(this, viewPagerData);
        viewPager2Land.setAdapter(landScapeAdapter);
        viewPager2Land.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    ArrayList<LandScape> getDataForViewPager() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new LandScape("thaphanoi", "Cột cờ Hà Nội"));
        dsDuLieu.add(new LandScape("effel", "Tháp Effel"));
        dsDuLieu.add(new LandScape("buckingham", "Cung điện Buckinghham"));
        dsDuLieu.add(new LandScape("thaphanoi", "Cột cờ Hà Nội"));
        dsDuLieu.add(new LandScape("effel", "Tháp Effel"));
        dsDuLieu.add(new LandScape("buckingham", "Cung điện Buckinghham"));
        return dsDuLieu;
    }
}