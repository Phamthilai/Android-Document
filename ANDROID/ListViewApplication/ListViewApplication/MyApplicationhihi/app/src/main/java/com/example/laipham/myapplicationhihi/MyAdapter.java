package com.example.laipham.myapplicationhihi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

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

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName =(TextView) convertView.findViewById(R.id.item_txtName);
            viewHolder.tvAge =(TextView) convertView.findViewById(R.id.item_txtAge);
            viewHolder.bntView = (Button)convertView.findViewById(R.id.item_btnview);
            viewHolder.bntEdit = (Button)convertView.findViewById(R.id.item_btnedit);
            viewHolder.bntDelete = (Button)convertView.findViewById(R.id.item_btndelete);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(data.get(position).getName());
        viewHolder.tvAge.setText(String.valueOf(data.get(position).getAge()));
        viewHolder.bntView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onViewClick(position);
                }
            }
        });
        viewHolder.bntEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onEditClick(position);
                }
            }
        });
        viewHolder.bntDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onDeleteClick(position);
                }
            }
        });

        return convertView;
    }


public class ViewHolder {
    TextView tvName, tvAge;
    Button bntEdit, bntView, bntDelete;

}
    public interface OnViewClickListener{
        void onViewClick(int pos);
        void onEditClick(int pos);
        void onDeleteClick(int pos);
    }

}
