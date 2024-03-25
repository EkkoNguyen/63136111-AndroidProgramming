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
        list.add(new ModelClass("Con vật nào dưới đây không thể bơi?","Cá","Chim cánh cụt","Vịt","Voi","Voi"));
        list.add(new ModelClass("Hình thoi có mấy cạnh?","3","4","5","6","4"));
        list.add(new ModelClass("Hiệp khí đạo là tên khác của môn võ nào?","Aikido","Judo","Karate","Vovinam","Aikido"));
        list.add(new ModelClass("Lễ hội khai ấn Đền Trần diễn ra ở tỉnh nào?","Ninh Bình","Bắc Ninh","Nam Định","Thái Bình","Nam Định"));
        list.add(new ModelClass("Đất nước hình lục lăng là tên gọi khác của quốc gia nào?","Anh","Ý","Pháp","Đức","Pháp"));
        list.add(new ModelClass("Thể loại thơ Haiku là của quốc gia nào?","Trung Quốc","Nhật Bản","Hàn Quốc","Ấn Độ","Nhật Bản"));
        list.add(new ModelClass("Tên loại búp bê gỗ nổi tiếng của Nga?","Daruma ","KiroV","Perestroika","Matryoshka","Matryoshka"));
        list.add(new ModelClass("Đàn cổ cầm có mấy dây?","3","7","5","6","7"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, ManHinhChoiActivity.class);
                startActivity(intent);
            }
        },1500);
    }
}