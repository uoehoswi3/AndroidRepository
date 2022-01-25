package com.example.radiotest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Price, List;
    String List1 = "", List2 = "", List12;
    RadioGroup radioGroup1, radioGroup2;
    RadioButton rbca, rbon, rbven, rbap, rbpe, rbfrn;
    int i1 = 0;
    int i2 = 0;
    int i1i2 = 0;
    Button NButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Price = findViewById(R.id.price);
        List = findViewById(R.id.list);
        radioGroup1 = findViewById(R.id.RGveg);
        radioGroup2 = findViewById(R.id.RGfru);
        rbca = findViewById(R.id.RB_mackerel);
        rbon = findViewById(R.id.RB_salmon);
        rbven = findViewById(R.id.vegnone);
        rbap = findViewById(R.id.RB_pork);
        rbpe = findViewById(R.id.RB_pear);
        rbfrn = findViewById(R.id.frunone);
        NButton = findViewById(R.id.NextButton);

        radioGroup1.setOnCheckedChangeListener((radioGroup1, i) -> {
          if(rbca.isChecked()) {
              i1 = 200;
              List1 = "배추  ";
          }
          else if(rbon.isChecked()) {
              i1 = 40;
              List1 = "양파  ";
          }
          else {
              i1 = 0;
              List1 = " ";
          }
          i1i2 = i1 + i2;
          List12 = List1 + List2;
          String price = Integer.toString(i1i2);
          Price.setText(price);
          if (rbven.isChecked() && rbfrn.isChecked())
              List12 = "비어있음";
          List.setText(List12);
        });

        radioGroup2.setOnCheckedChangeListener((radioGroup2, i) -> {
            if(rbap.isChecked()) {
                i2 = 50;
                List2 = "사과  ";
            }
            else if(rbpe.isChecked()) {
                i2 = 100;
                List2 = "배  ";
            }
            else {
                i2 = 0;
                List2 = " ";
            }
            i1i2 = i1 + i2;
            List12 = List1 + List2;
            String price = Integer.toString(i1i2);
            Price.setText(price);
            if (rbven.isChecked() && rbfrn.isChecked())
                List12 = "비어있음";
            List.setText(List12);
        });

        NButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                String list = List12;
                int price = i1i2;
                intent.putExtra("ListList", list);
                intent.putExtra("PricePrice", price);
                startActivity(intent);
            }
        });
    }
}