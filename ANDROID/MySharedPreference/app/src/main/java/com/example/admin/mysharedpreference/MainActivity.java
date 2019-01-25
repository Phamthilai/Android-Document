package com.example.admin.mysharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         edtPass = (EditText)findViewById(R.id.edt_pass);
         edtUsername = (EditText)findViewById(R.id.edt_username);

         if(checkLogin()){
             Intent intent = new Intent(this, HomeActivity.class);
             startActivity(intent);
             finish();
         }
    }

    public void onLogin(View v){
       if(!edtUsername.getText().toString().trim().equals("")){
           saveLogin(edtUsername.getText().toString().trim());
           Intent intent = new Intent(this, HomeActivity.class);
           startActivity(intent);
           finish();
       }


    }

    private boolean checkLogin(){
        SharedPreferences pref = getSharedPreferences("myprefer",MODE_PRIVATE);
        if(!pref.getString("myuser","").equals("")){
            return true;
        }
        return false;
    }

    private void saveLogin(String username){
        SharedPreferences pref = getSharedPreferences("myprefer",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("myuser", username);
        editor.commit();
    }
}
