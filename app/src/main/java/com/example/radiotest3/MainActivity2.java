package com.example.radiotest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView Price, List;
    String List3 = "", List4 = "", List34;
    String List12;
    RadioGroup radioGroup3, radioGroup4;
    RadioButton rbma, rbsa, rbfin, rbpo, rbbe, rbmen;
    int i1i2;
    int i3 = 0;
    int i4 = 0;
    int i3i4 = 0;
    Button PButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra("data");
        List12 = data.ListList;
        i1i2 = data.iiii;
        Price = findViewById(R.id.price);
        List = findViewById(R.id.list);
        radioGroup3 = findViewById(R.id.RGfis);
        radioGroup4 = findViewById(R.id.RGmea);
        rbma = findViewById(R.id.RB_mackerel);
        rbsa = findViewById(R.id.RB_salmon);
        rbfin = findViewById(R.id.fisnone);
        rbpo = findViewById(R.id.RB_pork);
        rbbe = findViewById(R.id.RB_beef);
        rbmen = findViewById(R.id.meanone);
        PButton = findViewById(R.id.PrevButton);

        radioGroup3.setOnCheckedChangeListener((radioGroup1, i) -> {
            if(rbma.isChecked()) {
                i3 = 300;
                List3 = "고등어";
            }
            else if(rbsa.isChecked()) {
                i3 = 350;
                List3 = "연어";
            }
            else {
                i3 = 0;
                List3 = " ";
            }
            i3i4 = i1i2 + i3 + i4;
            List34 = List12 + List3 + List4;
            String price = Integer.toString(i3i4);
            Price.setText(price);
            List.setText(List34);
        });

        radioGroup4.setOnCheckedChangeListener((radioGroup2, i) -> {
            if(rbpo.isChecked()) {
                i4 = 500;
                List4 = "  삼겹살";
            }
            else if(rbbe.isChecked()) {
                i4 = 1000;
                List4 = "  스테이크";
            }
            else {
                i4 = 0;
                List4 = " ";
            }
            i3i4 = i1i2 + i3 + i4;
            List34 = List12 + List3 + List4;
            String price = Integer.toString(i3i4);
            Price.setText(price);
            List.setText(List34);
        });

        PButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, MainActivity.class);
                String ListList = List34;
                int iiii = i3i4;
                intent.putExtra("ListList", ListList);
                intent.putExtra("iiii", iiii);
                startActivity(intent);
            }
        });
    }
}