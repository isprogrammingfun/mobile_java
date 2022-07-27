package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int SUB_ACTIVITY_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Food food = new Food();
                Intent intent = new Intent(this, SubActivity2.class);

                intent.putExtra("subject", "mobile software");
                intent.putExtra("food", food);
                startActivityForResult(intent, SUB_ACTIVITY_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SUB_ACTIVITY_CODE:
                if (resultCode == RESULT_OK) {
                    String resultData = data.getStringExtra("result data");
                    Toast.makeText(this, "Result: " + resultData, Toast.LENGTH_SHORT).show();
                    Log.i("MainActivity", "Result: " + resultData);
                }
                break;
        }
    }


}