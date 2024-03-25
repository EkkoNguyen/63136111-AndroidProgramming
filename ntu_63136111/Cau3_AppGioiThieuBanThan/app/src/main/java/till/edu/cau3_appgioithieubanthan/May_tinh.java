package till.edu.cau3_appgioithieubanthan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class May_tinh extends AppCompatActivity implements View.OnClickListener {
    TextView ketQua, tinhToan;
    MaterialButton btnC, btnNgoacMo, btnNgoacDong, btnChia;
    MaterialButton btn7, btn8, btn9, btnNhan;
    MaterialButton btn4, btn5, btn6, btnCong;
    MaterialButton btn1, btn2, btn3, btnTru;
    MaterialButton btnAC, btn0, btnCham, btnBang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);
        timDieuKhien();
        ketQua = findViewById(R.id.ketQua);
        tinhToan = findViewById(R.id.tinhtoan);
        btnC.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnCham.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnBang.setOnClickListener(this);

    }

    public void timDieuKhien(){
        btnC = findViewById(R.id.btn_c);
        btnAC = findViewById(R.id.btn_AC);
        btnCham = findViewById(R.id.btn_cham);
        btn9 = findViewById(R.id.btn_9);
        btn8 = findViewById(R.id.btn_8);
        btn7 = findViewById(R.id.btn_7);
        btn6 = findViewById(R.id.btn_6);
        btn5 = findViewById(R.id.btn_5);
        btn4 = findViewById(R.id.btn_4);
        btn3 = findViewById(R.id.btn_3);
        btn2 = findViewById(R.id.btn_2);
        btn1 = findViewById(R.id.btn_1);
        btn0 = findViewById(R.id.btn_0);
        btnChia = findViewById(R.id.btn_chia);
        btnNhan = findViewById(R.id.btn_nhan);
        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnBang = findViewById(R.id.btn_bang);
    }

    @Override
    public void onClick(View v){
        MaterialButton btn = (MaterialButton) v;
        String btnText = btn.getText().toString();
        String phepTinh = tinhToan.getText().toString();

        if(btnText.equals("AC")){
            tinhToan.setText("");
            ketQua.setText("");
            return;
        }
        if(btnText.equals("=")){
            tinhToan.setText(ketQua.getText());
            return;
        }
        if(btnText.equals("C")){
            phepTinh = phepTinh.substring(0, phepTinh.length() - 1);
        }else{
            phepTinh = phepTinh+btnText;
        }
        tinhToan.setText(phepTinh);
        String ketQuaCuoi = getKetQua(phepTinh);
        if(!ketQuaCuoi.equals("Err")){
            ketQua.setText(ketQuaCuoi);
        }
    }
    String getKetQua(String data){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String ketQuaCuoi = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(ketQuaCuoi.endsWith(".0")){
                ketQuaCuoi = ketQuaCuoi.replace(".0","");
            }
            return ketQuaCuoi;
        }catch (Exception e){
            return "Err";
        }
    }
}