package com.example.baggas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addstudent;
    Button displaystudent;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addstudent=(Button)findViewById(R.id.addstudentbtn);
        displaystudent=(Button)findViewById(R.id.displaystudentbtn);
        db = new DatabaseHelper(getApplicationContext());

        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AddStudent.class);
                startActivity(i);
            }
        });
        displaystudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DisplayStudent.class);
                startActivity(i);

            }
        });

    }
}