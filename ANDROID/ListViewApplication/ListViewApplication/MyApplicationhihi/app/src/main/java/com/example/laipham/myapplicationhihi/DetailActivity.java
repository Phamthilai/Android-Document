package com.example.laipham.myapplicationhihi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getIntExtra("age",0)+ "";

        TextView txtName = (TextView)findViewById(R.id.detail_txtName);
        TextView txtAge = (TextView)findViewById(R.id.detail_txtAge);

        txtName.setText(name);
        txtAge.setText(age);
    }
}
