package com.example.admin.bindview1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   Button btnOK;
   EditText edtName, edtAge;
   TextView txtResults;

   ArrayList<Student> arr = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = (Button) findViewById(R.id.activity_main_btn_ok);
        edtName = (EditText)findViewById(R.id.activity_main_edt_name);
        edtAge = (EditText)findViewById(R.id.activity_main_edt_age);


        btnOK.setOnClickListener(this);
        txtResults = (TextView)findViewById(R.id.activity_main_result);

    }

    @Override
    public void onClick(View view) {
        Student d = new Student(edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString()));
        arr.add(d);

        String s = "";
        for(int i=0;i<arr.size();i++){
            s += arr.get(i).getName()+"       "+arr.get(i).getAge()+"\n";
        }
        txtResults.setText(s);
    }

//    public void onOK(View view){
//        Toast.makeText(this, edtHello.getText().toString(),Toast.LENGTH_SHORT).show();
//    }
}
