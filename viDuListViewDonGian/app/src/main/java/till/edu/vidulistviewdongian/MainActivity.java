package till.edu.vidulistviewdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtThongTin;
    ListView lvsTen;
    ArrayList<String> dsTen;
    ArrayAdapter<String> bo_nguon;
    void getControls(){
        edtThongTin = (EditText) findViewById(R.id.edThongTin);
        lvsTen = (ListView) findViewById(R.id.lvTen);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControls();
        dsTen = new ArrayList<String>();
        dsTen.add("Mai");
        dsTen.add("Lan");
        dsTen.add("Phương");
        dsTen.add("Phượng");
        dsTen.add("Phụng");
        dsTen.add("Lâm");
        bo_nguon = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTen);
        lvsTen.setAdapter(bo_nguon);
    }
    public void themPhanTu(View v){
        EditText edtTenMoi = (EditText) findViewById(R.id.edNhapTen);
        String tenNhap = edtTenMoi.getText().toString();
        dsTen.add(tenNhap);
        edtTenMoi.setText("");
        bo_nguon.notifyDataSetChanged();
    }
}