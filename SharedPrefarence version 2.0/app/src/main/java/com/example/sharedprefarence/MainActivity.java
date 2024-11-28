package com.example.sharedprefarence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private EditText editText1, editText2;
    private TextInputEditText editText3;
    private Button submit, show;
    private AppCompatButton reset;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.show);
        reset = findViewById(R.id.reset);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData1 = editText1.getText().toString();
                String getData2 = editText2.getText().toString();
                String getData3 = editText3.getText().toString();

                if ( getData1.length()>0 && getData2.length()>0 && getData3.length()>0 ){

                    editor.putString("name",getData1);
                    editor.putString("email",getData2);
                    editor.putString("password",getData3);
                    editor.apply();

                    editText1.setText(null);
                    editText2.setText(null);
                    editText3.setText(null);
                    display.setText(null);

                    Toast.makeText(MainActivity.this, "Submitted SuccessFully", Toast.LENGTH_SHORT).show();

                }

                else if (getData1.length()>0) {
                    editText1.setError(null);

                    if (getData2.length()>0){
                        editText2.setError(null);

                        if (getData3.length()>0){
                            editText3.setError(null);
                        }else{
                            editText3.setError("Empty");
                        }

                    }else {
                        editText2.setError("Empty");

                        if (getData3.length()>0){
                            editText3.setError(null);
                        }else{
                            editText3.setError("Empty");
                        }
                    }

                }


                else if (getData2.length()>0) {
                    editText2.setError(null);

                    if (getData1.length()>0){
                        editText1.setError(null);

                        if (getData3.length()>0){
                            editText3.setError(null);
                        }else{
                            editText3.setError("Empty");
                        }

                    }else {
                        editText1.setError("Empty");

                        if (getData3.length()>0){
                            editText3.setError(null);
                        }else{
                            editText3.setError("Empty");
                        }
                    }

                }


                else if (getData3.length()>0) {
                    editText3.setError(null);

                    if (getData2.length()>0){
                        editText2.setError(null);

                        if (getData1.length()>0){
                            editText1.setError(null);
                        }else{
                            editText1.setError("Empty");
                        }

                    }else {
                        editText2.setError("Empty");

                        if (getData1.length()>0){
                            editText1.setError(null);
                        }else{
                            editText1.setError("Empty");
                        }
                    }

                }


                else{
                    editText1.setError("Empty");
                    editText2.setError("Empty");
                    editText3.setError("Empty");
                    Toast.makeText(MainActivity.this, "Field is Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });








        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (  sharedPreferences.contains("name") && sharedPreferences.contains("email")  && sharedPreferences.contains("password") ){
                    String data1 = sharedPreferences.getString("name",null);
                    String data2 = sharedPreferences.getString("email",null);
                    String data3 = sharedPreferences.getString("password",null);

                    editText1.setText(""+data1);
                    editText2.setText(""+data2);
                    editText3.setText(""+data3);

                    display.setText(""+data1+"\n"+data2+"\n"+data3);

                }else{
                    Toast.makeText(MainActivity.this, "DataBase Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });








        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();
                editText1.setText(null);
                editText2.setText(null);
                editText3.setText(null);
                display.setText(null);
                editText1.setError(null);
                editText2.setError(null);
                editText3.setError(null);
            }
        });







    }
}