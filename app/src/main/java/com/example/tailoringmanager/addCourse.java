package com.example.tailoringmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addCourse extends AppCompatActivity {
    DatabaseReference databaseReference;
    EditText course;
    Button button;
    String course_Value;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        course = (EditText) findViewById(R.id.editText_addCourse);
        button = (Button) findViewById(R.id.addcourse_btn);
        databaseReference= FirebaseDatabase.getInstance().getReference();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                course_Value= course.getText().toString();
                databaseReference.child("SpinnerArea").push().setValue(course_Value);
                progressDialog = new ProgressDialog(addCourse.this);
                progressDialog.setMessage("Adding Course");
                progressDialog.setCancelable(false);
                progressDialog.show();

                CountDownTimer countDownTimer = new CountDownTimer(2000,100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(addCourse.this, "Course Added Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(addCourse.this,homePage.class);
                        startActivity(intent);

                    }
                }.start();


            }
        });
    }
}
