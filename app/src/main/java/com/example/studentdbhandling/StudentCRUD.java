package com.example.studentdbhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studentdbhandling.Data.MyDbHandler;
import com.example.studentdbhandling.model.Student;

import java.util.List;

public class StudentCRUD extends AppCompatActivity {
    MyDbHandler dbHandler;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_crud);

//        binding xml views with local variables
        EditText etId = findViewById(R.id.etStdId);
        EditText etName = findViewById(R.id.etName);
        EditText etRollNo = findViewById(R.id.etRollNo);
        Button save = findViewById(R.id.btnSave);
        Button edit = findViewById(R.id.btnEdit);
        Button delete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.lvStudents);
        dbHandler = new MyDbHandler(this);
        RefreshGrid();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etName.getText().toString().equals("") || etRollNo.getText().toString().equals(""))
                {
                    Toast.makeText(StudentCRUD.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    return;
                }
                Student std = new Student(etName.getText().toString(),etRollNo.getText().toString());
                dbHandler.insertStudent(std);
                Toast.makeText(StudentCRUD.this, "Student Saved successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etRollNo.setText("");
                etId.setText("");
                RefreshGrid();

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().equals("") || etRollNo.getText().toString().equals(""))
                {
                    Toast.makeText(StudentCRUD.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    return;
                }
                int id = Integer.valueOf(etId.getText().toString());
                Student std = dbHandler.getStudent(id);
                std.setName(etName.getText().toString());
                std.setRollNo(etRollNo.getText().toString());
                dbHandler.updateStudent(std);

                Toast.makeText(StudentCRUD.this, "Student Updated successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etRollNo.setText("");
                etId.setText("");
                RefreshGrid();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.deleteStudent(etId.getText().toString());
                Toast.makeText(StudentCRUD.this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etRollNo.setText("");
                etId.setText("");
                RefreshGrid();
            }
        });


    }
    public void RefreshGrid(){
        List<Student> students = dbHandler.getAllStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Student>(StudentCRUD.this, android.R.layout.simple_list_item_1,students);
        listView.setAdapter(arrayAdapter);


    }
}
