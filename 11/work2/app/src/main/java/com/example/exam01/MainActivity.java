package com.example.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager f = new FoodManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayList<Food> list = f.managedata();
        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int position = i; //롱클릭 한 위치 index 체크
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(f.ShowremoveData(i) + "을(를) 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)//back버튼 눌러도 안닫힘
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                f.removeData(position);
                                adapter.notifyDataSetChanged();
                            }
                        }) // null 대화상자가 닫히기만 함
                        .setNegativeButton("취소버튼", null)
                        .show();
                return false;
            }
        });

        Button button1 = (Button) findViewById(R.id.button) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ConstraintLayout orderLayout = (ConstraintLayout)View.inflate(MainActivity.this, R.layout.order_layout,null);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("음식 추가")
                        .setView(orderLayout)
                        .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText editText1 = (EditText)orderLayout.findViewById(R.id.food);
                                String text1 = editText1.getText().toString();
                                EditText editText2 = (EditText)orderLayout.findViewById(R.id.country);
                                String text2 = editText2.getText().toString();
                                f.addData(text1, text2);
                                adapter.notifyDataSetChanged();
                            }
                        }) // null 대화상자가 닫히기만 함
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}















