package com.example.admin.mysharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {

    TextView txtWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtWelcome = (TextView) findViewById(R.id.txt_welcome);

          getInfor();

    }

    private void getInfor(){
       SharedPreferences pref = getSharedPreferences("myprefer",MODE_PRIVATE);
        if(!pref.getString("myuser","").equals("")){
            txtWelcome.setText(pref.getString("myuser",""));
        }
    }

    public void logout(View v){
        SharedPreferences pref = getSharedPreferences("myprefer",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
