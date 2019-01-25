package com.example.tannguyen.listviewapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnViewClickListener {
    ListView mListView;
    TextView txtName,txtAge;
    Button btnAdd;
    int position;
    MyAdapter adapter;
    ArrayList<Student> ms = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.activity_listView);


        btnAdd = (Button)findViewById(R.id.activity_btnAdd);

        getData();

        adapter = new MyAdapter(this, ms,this);
        mListView.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                intent.putExtra("data","");
                startActivityForResult(intent,1);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("name",ms.get(position).getName());
                intent.putExtra("age",ms.get(position).getAge());
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 20){
            String strName = data.getStringExtra("name");
            String strAge = data.getStringExtra("age");

            Student a = new Student(strName,Integer.parseInt(strAge));
            ms.add(a);
            adapter.notifyDataSetChanged();
        }
        if (resultCode == 30){
            String strName = data.getStringExtra("name");
            String strAge = data.getStringExtra("age");
            ms.get(position).setName(strName);
            ms.get(position).setAge(Integer.parseInt(strAge));
            adapter.notifyDataSetChanged();
        }
    }



    private void getData(){
        Student s1 = new Student();
        s1.setName("tan");
        s1.setAge(12);
        ms.add(s1);
        Student s2 = new Student("ads",13);
        ms.add(s2);
    }

    @Override
    public void onViewClick(int pos) {
        Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        intent.putExtra("name",ms.get(pos).getName());
        intent.putExtra("age",ms.get(pos).getAge());
        startActivity(intent);
    }

    @Override
    public void onEditClick(int pos) {
        this.position =pos;
        Intent intent = new Intent(MainActivity.this,AddActivity.class);
        intent.putExtra("name",ms.get(pos).getName());
        intent.putExtra("age",ms.get(pos).getAge());
        startActivityForResult(intent,5);
    }
}
