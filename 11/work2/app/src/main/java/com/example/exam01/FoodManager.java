package com.example.exam01;

import android.widget.ListView;

import java.util.ArrayList;

public class FoodManager {
    private ArrayList<Food> foodList;
    private ListView listView;

    public ArrayList managedata(){
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
        return foodList;
    }
    public String ShowremoveData(int idx) {return foodList.get(idx).getFood();}
    public void removeData(int idx) { foodList.remove(idx);
    }
    public void addData(String str1, String str2){
        foodList.add(new Food(str1, str2));
    }
}
