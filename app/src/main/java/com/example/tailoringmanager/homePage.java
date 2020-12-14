package com.example.tailoringmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homePage extends AppCompatActivity {
    Button addStudent, addCourse, studentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        addStudent = (Button) findViewById(R.id.btn_Addstudent);
        addCourse = (Button) findViewById(R.id.btn_Addcourse);
        studentDetails = (Button) findViewById(R.id.btn_Studentdetails);


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homePage.this,addStudent.class);
                startActivity(intent);
            }
        });
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homePage.this, addCourse.class);
                startActivity(intent);

            }
        });
        studentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homePage.this, studentDetails.class);
                startActivity(intent);
            }
        });
    }
}
