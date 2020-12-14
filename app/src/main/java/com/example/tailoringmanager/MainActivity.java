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

public class MainActivity extends AppCompatActivity {
    EditText username_id, password_id;
    Button login_id;
    String userame,password;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_id = (EditText) findViewById(R.id.username_edtTxt);
        password_id = (EditText) findViewById(R.id.pasword_edtTxt);

        login_id = (Button) findViewById(R.id.login_loginActivity);

        login_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userame = username_id.getText().toString();
                password = password_id.getText().toString();
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Please Wait!");
                progressDialog.setCancelable(false);
                progressDialog.show();

                CountDownTimer countDownTimer = new CountDownTimer(3000,100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();
                        if(userame.equals("Admin") && password.equals("Admin"))
                        {
                            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, homePage.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
                        }

                    }
                }.start();




            }
        });




    }
}
