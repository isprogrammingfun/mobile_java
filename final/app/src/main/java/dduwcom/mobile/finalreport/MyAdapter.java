package dduwcom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Movie> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<Movie> myDataList){
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
            holder.Mimage = (ImageView)convertView.findViewById(R.id.Mimage);
            holder.Mtitle = (TextView)convertView.findViewById(R.id.Mtitle);
            holder.Mactor = (TextView)convertView.findViewById(R.id.Mactor);
            holder.Mdate = (TextView)convertView.findViewById(R.id.Mdate);
            holder.Mgrade = (TextView)convertView.findViewById(R.id.Mgrade);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.Mtitle.setText(myDataList.get(position).getTitle());
        holder.Mactor.setText(myDataList.get(position).getActor());
        holder.Mdate.setText(myDataList.get(position).getDate());
        holder.Mgrade.setText(String.valueOf(myDataList.get(position).getGrade()));
//        holder.tvNo.setOnTouchListener(new View.OnTouchListener(){
//
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Toast.makeText(context, String.valueOf(myDataList.get(position).get_id()), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        holder.tvName.setOnTouchListener(new View.OnTouchListener(){
//
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Toast.makeText(context, myDataList.get(position).getName(), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        holder.tvPhone.setOnTouchListener(new View.OnTouchListener(){
//
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Toast.makeText(context, myDataList.get(position).getPhone(), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

        return convertView;
    }

    static class ViewHolder{
        ImageView Mimage;
        TextView Mtitle;
        TextView Mactor;
        TextView Mdate;
        TextView Mgrade;
    }
}
