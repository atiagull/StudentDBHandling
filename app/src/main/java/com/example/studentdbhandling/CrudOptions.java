package com.example.studentdbhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrudOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_options);

        Button btnStudentCrud = findViewById(R.id.btnStudentCrud);
        Button btnLessonCrud = findViewById(R.id.btnLessonCrud);
        Button btnGitLink = findViewById(R.id.btnGitLink);

        btnLessonCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudOptions.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnStudentCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrudOptions.this, StudentCRUD.class);
                startActivity(intent);
            }
        });
        btnGitLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "https://github.com/atiagull/StudentDBHandling";
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

    }
}