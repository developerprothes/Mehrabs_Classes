package com.aspprothes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextId1,editTextId2;
    private Button submitBtn,showBtn,resetBtn;
    private TextView display;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId1 = findViewById(R.id.editTextId1);
        editTextId2 = findViewById(R.id.editTextId2);
        display = findViewById(R.id.display);
        submitBtn = findViewById(R.id.submitBtn);
        showBtn = findViewById(R.id.showBtn);
        resetBtn = findViewById(R.id.resetBtn);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();






        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getData1 = editTextId1.getText().toString();
                String getData2 = editTextId2.getText().toString();

                editor.putString("names",getData1);
                editor.putString("email",getData2);
                editor.apply();

                editTextId1.setText(null);
                editTextId2.setText(null);
                display.setText(null);
                Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });






        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if ( sharedPreferences.contains("names") && sharedPreferences.contains("email") ){

                   String data1 = sharedPreferences.getString("names",null);
                   String data2 = sharedPreferences.getString("email",null);

                   display.setText("" + data1 + "\n" + data2);

                   editTextId1.setText(""+data1);
                   editTextId2.setText(""+data2);

               }else{
                   Toast.makeText(MainActivity.this, "Empty Storage", Toast.LENGTH_SHORT).show();
               }


            }
        });







        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                editTextId1.setText(null);
                editTextId2.setText(null);
                display.setText(null);
            }
        });





    }
}