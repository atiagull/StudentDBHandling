package com.example.studentdbhandling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.studentdbhandling.Data.MyDbHandler;
import com.example.studentdbhandling.adapter.RecyclerViewAdapter;
import com.example.studentdbhandling.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Student> studentsArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(this);
        Student s1 = new Student("saliha","13","para 13", "para 12","para 2");
       // s1.setId(3);

       // Log.d("msg","no of effected rows : " + db.updateStudent(s1));
        Student s2 = new Student("madiha","16","sabaq5", "sabqi5","manzil5");
       // db.insertStudent(s1);
//        db.insertStudent(s2);
//        Log.d("msg"," "+ s1);
//        Log.d("msg"," "+ s2);
      //  s1.setName("atia gull");
      //  db.updateStudent(s1);
      //  db.insertStudent(s2);
        studentsArrayList = new ArrayList<>();
        List<Student> studentsList = db.getAllStudents();
        for(Student std: studentsList)
        {
            Log.d("msg","record : " + std);
            studentsArrayList.add(std);
        }
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,studentsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


    }
}