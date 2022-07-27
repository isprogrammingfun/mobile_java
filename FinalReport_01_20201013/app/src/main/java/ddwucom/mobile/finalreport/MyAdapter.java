package ddwucom.mobile.finalreport;

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
    private ArrayList<Movie> movieList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<Movie> movieList){
        this.context = context;
        this.layout = layout;
        this.movieList= movieList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int pos) {
        return movieList.get(pos);
    }

    @Override
    public long getItemId(int pos) { return movieList.get(pos).get_id();}

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
        holder.Mtitle.setText(movieList.get(position).getTitle());
        holder.Mactor.setText(movieList.get(position).getActor());
        holder.Mdate.setText(movieList.get(position).getDate());
        holder.Mgrade.setText(String.valueOf(movieList.get(position).getRating()));
        if (movieList.get(position).getPoster() == 1)
            holder.Mimage.setImageResource(R.mipmap.movie1);
        else if (movieList.get(position).getPoster() == 2)
            holder.Mimage.setImageResource(R.mipmap.movie2);
        else if (movieList.get(position).getPoster() == 3)
            holder.Mimage.setImageResource(R.mipmap.movie3);
        else if (movieList.get(position).getPoster() == 4)
            holder.Mimage.setImageResource(R.mipmap.movie4);
        else if (movieList.get(position).getPoster() == 5)
            holder.Mimage.setImageResource(R.mipmap.movie5);
        else
            holder.Mimage.setImageResource(R.mipmap.movieadd);
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
