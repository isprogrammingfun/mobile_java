package com.example.hw10;

import android.widget.ListView;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;

    public ArrayList managedata(){
        myDataList = new ArrayList<MyData>();

        myDataList.add( new MyData(1, "하월곡동", "서울시 성북구", "좋음"));
        myDataList.add( new MyData(2, "잠실동", "서울시 송파구", "보통"));
        myDataList.add( new MyData(3, "));

        return myDataList;
    }
    public void removeData(int idx) {
        myDataList.remove(idx);
    }
}
