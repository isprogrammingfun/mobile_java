package com.example.week9work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    int Pos;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        editText = findViewById(R.id.etItem);
        btn1 = findViewById(R.id.btnInsert);
        btn2 = findViewById(R.id.btnUpdate);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                editText.setText(subjectManager.getSubjectByPos(pos));
                Pos = pos;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
                subjectManager.removeData(pos);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btn1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                subjectManager.addData(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                subjectManager.updateSubject(Pos, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
