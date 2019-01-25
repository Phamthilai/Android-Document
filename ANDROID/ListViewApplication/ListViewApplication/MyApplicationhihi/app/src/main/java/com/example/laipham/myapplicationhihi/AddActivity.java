package com.example.laipham.myapplicationhihi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {
    EditText addName,addAge;
    Button btnAdd,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.add_data);

        addName = (EditText)findViewById(R.id.add_name);
        addAge = (EditText)findViewById(R.id.add_age);
        btnAdd = (Button)findViewById(R.id.add_btnAdd);
        btnSave = (Button)findViewById(R.id.add_btnSave);
//        addAge.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (keyCode == KeyEvent.KEYCODE_ENTER) {
//                    /* do something */
//                }
//                return false;
//            }
//
//
//        });
//        addAge.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                if (!AddActivity.isNumeric(s.toString())) {
//
//                };
//            }
//        });

        addAge.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_Z)) {
                    Toast.makeText(AddActivity.this,
                            "Data input must be number", Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });

        if (getIntent() != null){
            btnAdd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String name = addName.getText().toString();
                    Integer age = Integer.valueOf(addAge.getText().toString());
                    if(!addName.getText().toString().equals("") && Integer.valueOf(addAge.getText().toString())!= 0){
                        Intent intent = new Intent();
                        intent.putExtra("name",addName.getText().toString());
                        intent.putExtra("age",String.valueOf(addAge.getText().toString()));
                        setResult(20,intent);
                        finish();
                    }
                   else {
                        Toast.makeText(AddActivity.this,
                                "Don't empty", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

        addName.setText(getIntent().getStringExtra("name"));
        addAge.setText(getIntent().getIntExtra("age",0)+"");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("name",addName.getText().toString());
                intent.putExtra("age",String.valueOf(addAge.getText().toString()));
                setResult(30,intent);
                finish();
            }
        });
    }
    public static boolean isNumeric(String strNum) {
        try {
                double d = Double.parseDouble(strNum);
                } catch (NumberFormatException | NullPointerException nfe) {
                return false;
            }
                return true;
    }
}
