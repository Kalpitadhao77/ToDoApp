package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> todolist;
    ArrayAdapter arrayAdapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todolist=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,R.layout.layout,todolist);
        listView=findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
        editText=findViewById(R.id.id_text);
    }
    public void add_task(View view){
        todolist.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");

    }
    public void task(View view){
        TextView textView=findViewById(R.id.layout);
        textView.setVisibility(TextView.VISIBLE);
    }
}