package com.example.tannguyen.listviewapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddActivity extends Activity{
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

        if (getIntent() != null){
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("name",addName.getText().toString());
                    intent.putExtra("age",String.valueOf(addAge.getText().toString()));
                    setResult(20,intent);
                    finish();

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
}
