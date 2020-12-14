package com.example.tailoringmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class addStudent extends AppCompatActivity {
    EditText firstname, lastname, email, phone;
    String firstname_Value,lastname_Value,email_value,phone_value,spinData1,spinData2;
    Button addstudent;
    ProgressDialog progressDialog;
    ValueEventListener listener;
    Spinner spinner_course1,spinner_course2;
    DatabaseReference details;
    DatabaseReference spinnerArea;
    ArrayList<String> spinnerDataList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        firstname = (EditText)findViewById(R.id.editText_firstName);
        lastname = (EditText) findViewById(R.id.editText_LastName);
        email = (EditText) findViewById(R.id.editText_email);
        phone = (EditText) findViewById(R.id.editText_phone);
        addstudent = (Button) findViewById(R.id.addstudent_btn);
        spinner_course1 = (Spinner) findViewById(R.id.spinnercourse1);
        spinner_course2 = (Spinner) findViewById(R.id.spinnercourse2);


        spinnerArea = FirebaseDatabase.getInstance().getReference("SpinnerArea");
        spinnerDataList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,spinnerDataList );

        spinnerDataList.clear();
        retrieveData();
        spinner_course1.setAdapter(adapter);
        spinner_course2.setAdapter(adapter);

        addstudent.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 firstname_Value= firstname.getText().toString();
                 lastname_Value = lastname.getText().toString();
                 email_value = email.getText().toString();
                phone_value = phone.getText().toString();

                 if (spinner_course1.getSelectedItem() != null) {
                     spinData1 = spinner_course1.getSelectedItem().toString();

                 } else {
                     Toast.makeText(addStudent.this, "Select The Course 1", Toast.LENGTH_SHORT).show();
                 }


                 if (spinner_course2.getSelectedItem() != null) {
                     spinData2 = spinner_course1.getSelectedItem().toString();

                 } else {
                     Toast.makeText(addStudent.this, "Select The Course 2", Toast.LENGTH_SHORT).show();
                 }

                 HashMap<String, Object> detailsMap=new HashMap<>();
                 detailsMap.put("FirstName",firstname_Value);
                 detailsMap.put("LastName",lastname_Value);
                 detailsMap.put("Email",email_value);
                detailsMap.put("Phone",phone_value);
                detailsMap.put("Course1",spinData1);
                detailsMap.put("Course2",spinData2);
                 details = FirebaseDatabase.getInstance().getReference().child("details").child(phone_value);
                 details.setValue(detailsMap);
                 progressDialog = new ProgressDialog(addStudent.this);
                 progressDialog.setMessage("Uploading Details");
                 progressDialog.setCancelable(false);
                 progressDialog.show();

                 CountDownTimer countDownTimer = new CountDownTimer(2000,100) {
                     @Override
                     public void onTick(long l) {

                     }

                     @Override
                     public void onFinish() {
                         Toast.makeText(addStudent.this, "Details Uploaded Successfully", Toast.LENGTH_SHORT).show();
                         Intent intent = new Intent(addStudent.this,homePage.class);
                         startActivity(intent);

                     }
                 }.start();


             }
         });
    }
    private void retrieveData()
    {
        listener = spinnerArea.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot item:dataSnapshot.getChildren())
                {
                    spinnerDataList.add(item.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(addStudent.this, "Error Retriving Spinner", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
