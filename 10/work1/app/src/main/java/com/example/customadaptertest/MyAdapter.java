package com.example.customadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList){
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int pos) {
        return myDataList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return myDataList.get(pos).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);
            holder = new ViewHolder();
            holder.tvNo = (TextView)convertView.findViewById(R.id.tvNo);
            holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView)convertView.findViewById(R.id.tvPhone);
            holder.btnCheck = (Button)convertView.findViewById(R.id.btnCheck);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.btnCheck.setFocusable(false);
        holder.tvNo.setText(String.valueOf(myDataList.get(position).get_id()));
        holder.tvName.setText(myDataList.get(position).getName());
        holder.tvPhone.setText(myDataList.get(position).getPhone());
        holder.btnCheck.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + " 선텍", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvNo.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(context, String.valueOf(myDataList.get(position).get_id()), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        holder.tvName.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(context, myDataList.get(position).getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        holder.tvPhone.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(context, myDataList.get(position).getPhone(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return convertView;
    }

    static class ViewHolder{
        TextView tvNo;
        TextView tvName;
        TextView tvPhone;
        Button btnCheck;
    }
}
