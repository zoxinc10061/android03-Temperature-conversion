package com.example.a03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int mode = 0;

    public void conversion(View view){
        EditText editText = findViewById(R.id.editTextTextPersonName);
        EditText editText2 = findViewById(R.id.editTextTextPersonName2);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        try {
            float temperature = Float.parseFloat(editText.getText().toString());
            if(!editText.getText().toString().contains("f")&&!editText.getText().toString().contains("F")){
                if (mode == 0){
                    textView4.setText("華氏溫度:");
                    textView5.setText("°F");
                    temperature = temperature*9/5+32;
                    editText2.setText(""+(float)(Math.round(temperature*100))/100);
                    mode = 1;
                }
                else{
                    textView.setText("攝氏溫度:");
                    textView2.setText("°C");
                    temperature = (temperature-32)/9*5;
                    editText.setText(""+(float)(Math.round(temperature*100))/100);
                    mode = 0;
                }
            }
            else {
                Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
        }
    }
}