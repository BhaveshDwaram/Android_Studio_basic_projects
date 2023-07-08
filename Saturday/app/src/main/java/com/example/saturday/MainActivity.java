package com.example.saturday;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saturday.CourseAdapter;
import com.example.saturday.CourseModel;

import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity {

    private RecyclerView courseRV;

    // Arraylist for storing data
    private ArrayList<CourseModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseRV = findViewById(R.id.r);

        // here we have created new array list and added data to it.
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("Android", 4, R.drawable.android));
        courseModelArrayList.add(new CourseModel("Java ", 3, R.drawable.java));
        courseModelArrayList.add(new CourseModel("C++", 4, R.drawable.cpp));
        courseModelArrayList.add(new CourseModel("Python", 4, R.drawable.python));
        courseModelArrayList.add(new CourseModel("AI", 4, R.drawable.ai));
        courseModelArrayList.add(new CourseModel("Machine learning", 4, R.drawable.ml));
        courseModelArrayList.add(new CourseModel("web app", 4, R.drawable.webapp));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }
}