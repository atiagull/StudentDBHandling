package com.example.studentdbhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentdbhandling.Data.MyDbHandler;
import com.example.studentdbhandling.model.Student;

public class LessonsCRUD extends AppCompatActivity {
    String id,sabaq,sabqi,manzil,name,rollNo;
    MyDbHandler myHandler;
    TextView txtSabaq;
    TextView txtSabqi;
    TextView txtManzil;
    EditText etSabaq;
    EditText etSabqi;
    EditText etManzil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_crud);


        Button btnUpdateLesson = findViewById(R.id.btnUpdateLesson);
        Intent intent = getIntent();
         id = intent.getStringExtra("id");
         sabaq = intent.getStringExtra("sabaq");
         sabqi = intent.getStringExtra("sabqi");
         manzil = intent.getStringExtra("manzil");
         name = intent.getStringExtra("name");
         rollNo = intent.getStringExtra("rollNo");
        txtSabaq = findViewById(R.id.txtSabaq);
        txtSabqi = findViewById(R.id.txtSabqi);
        txtManzil = findViewById(R.id.txtManzil);

        etSabaq = findViewById(R.id.etSabaq);
        etSabqi = findViewById(R.id.etSabqi);
        etManzil = findViewById(R.id.etManzil);

        txtSabaq.setText(sabaq);
        txtSabqi.setText(sabqi);
        txtManzil.setText(manzil);

        myHandler =  new MyDbHandler(this);

        btnUpdateLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                Log.d(",msg"," "+ (etSabqi.getText().toString()));
                    student.setId(Integer.parseInt(id));
                    student.setSabqi(etSabqi.getText().toString());
                    student.setSabaq(etSabaq.getText().toString());
                    student.setManzil(etManzil.getText().toString());
                    student.setName(name);
                    student.setRollNo(rollNo);
                    myHandler.updateStudent(student);
                    txtSabaq.setText(student.getSabaq());
                    txtSabqi.setText(student.getSabqi());
                    txtManzil.setText(student.getManzil());

            }
        });



    }
}