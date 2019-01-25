package com.example.laipham.myapplicationhihi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnViewClickListener{

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

    @Override
    public void onDeleteClick(int pos) {
        showEditDialog(pos);

    }
    public void showEditDialog(final int position){
//        String a = ""+position;
//        final int temp = Integer.parseInt(a);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Do you want to delete "+ ms.get(position).getName());
        alertDialogBuilder.setMessage("Do you want to delete now?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ms.remove(position);
//                        mData = getData();
                        final MyAdapter adapter = new MyAdapter(MainActivity.this, ms, MainActivity.this);
                        mListView.setAdapter(adapter);
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

//        final Dialog dialog = new Dialog(MainActivity.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.activity_edit_contact);
////Bind dialog views
//        final EditText renameEdittext=(EditText)dialog.findViewById(R.id.rename_edittext);
//        final Button renameButton=(Button)dialog.findViewById(R.id.rename_button);
//        Button deleteButton=(Button)dialog.findViewById(R.id.delete_button);
//
//        //Set clicked album name to rename edittext
//        renameEdittext.setText(arrContact.get(position).getName());
//
//        //When rename button is clicked, first rename edittext should be checked if it is empty
//        //If it is not empty, data and listview item should be changed.
//        renameButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!renameEdittext.getText().toString().equals("")) {
//                    arrContact.get(position).setName(renameEdittext.getText().toString());
//                    //Notify adapter about changing of model list
//                    customAdapper.notifyDataSetChanged();
//                    //Close dialog
//                    dialog.dismiss();
//                } else {
//                    Toast.makeText(MainActivity.this, "Can be empty", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        //When delete button is clicked, it should be deleted from
//        //data list and adapter should be notified that data list change
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                arrContact.remove(position);
//                //Notify adapter about changing of model list
//                customAdapper.notifyDataSetChanged();
//                //Close dialog
//                dialog.dismiss();
//            }
//        });
//        dialog.show();

    }
}
