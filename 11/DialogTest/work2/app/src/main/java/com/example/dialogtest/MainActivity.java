package com.example.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 int selectedIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("음식을 선택하세요")
                   // .setMessage("대화상자 메세지")
                    .setSingleChoiceItems(R.array.foods, selectedIndex, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                          selectedIndex = i;
                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setCancelable(false)//back버튼 눌러도 안닫힘
                    .setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"확인!!!",Toast.LENGTH_SHORT).show();
                        }
                    }) // null 대화상자가 닫히기만 함
                    .setNeutralButton("대기버튼", null)
                    .setNegativeButton("취소버튼", null)
                    .show();
            Toast.makeText(this, "대화상자와 상관없음", Toast.LENGTH_SHORT).show();//modeless
              //finish(); 확인이나 취소버튼 쪽에 있어야함
            break;
        }
    }
}