package com.example.tannguyen.listviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context mcontext;

    OnViewClickListener mListener;

    private ArrayList<Student> data = new ArrayList<>();

    public MyAdapter(Context c, ArrayList<Student> m ,OnViewClickListener list){
        mcontext = c;
        data = m;
        mListener = list;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_layout, parent, false);


        TextView txtName =(TextView) rowView.findViewById(R.id.item_txtName);
        TextView txtAge =(TextView) rowView.findViewById(R.id.item_txtAge);

        txtName.setText(data.get(position).getName());
        txtAge.setText(String.valueOf(data.get(position).getAge()));

        Button btnView = (Button)rowView.findViewById(R.id.item_btnview);
        Button btnEdit = (Button)rowView.findViewById(R.id.item_btnedit);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onViewClick(position);
                }
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onEditClick(position);
                }
            }
        });

        return rowView;
    }

    public interface OnViewClickListener{
        void onViewClick(int pos);
        void onEditClick(int pos);
    }

}
