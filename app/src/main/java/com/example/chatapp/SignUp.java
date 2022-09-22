package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth authprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        getSupportActionBar().hide();
        Button submit;
        submit=findViewById(R.id.btn_submit);

        EditText name,email,phone,newpaas,confirmpass;
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);

        newpaas=findViewById(R.id.newpass);
        confirmpass=findViewById(R.id.confirmpass);
        authprofile= FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=authprofile.getCurrentUser();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String e=email.getText().toString();
                String p=phone.getText().toString();
                Intent i=new Intent(SignUp.this,MainScreen.class);
                i.putExtra("Name :",n);
                i.putExtra("Email :",e);
                i.putExtra("Mobile :",p);
                startActivity(i);
                finish();
                }

        });


    }



    }