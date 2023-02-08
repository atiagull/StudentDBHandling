package com.example.studentdbhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        Button submit = findViewById(R.id.btnSubmit);
        EditText username = findViewById(R.id.etUsername);
        EditText password = findViewById(R.id.etPassword);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = username.getText().toString();
                String pass = password.getText().toString();
                Log.d("msg"," naem: "+ name + "  pass: " +pass);
                if(name.equals("admin") && pass.equals("admin"))
                {
                    Intent intent = new Intent(loginForm.this, CrudOptions.class);
                    startActivity(intent);
                }
                else
                {
                    Toast. makeText(getApplicationContext(),"Invalid credentials! " + name + " " + pass,Toast. LENGTH_SHORT).show();

                }
            }
        });

    }
}