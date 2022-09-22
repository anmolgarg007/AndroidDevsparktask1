package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //button declration
        Button signup,login,google,facebook;
        signup=findViewById(R.id.btnemail);
        login=findViewById(R.id.btnlogin);
        google=findViewById(R.id.btngoogle);
        facebook=findViewById(R.id.btnfacebook);

        EditText email,pass;
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        //chaning the status bar color

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //firebase
        auth=FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);}

        });

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String e=email.getText().toString();
            String p=pass.getText().toString();
            if(e.isEmpty()){
                email.setError("Enter your email !");
                email.requestFocus();
            } else if(!Patterns.EMAIL_ADDRESS.matcher(e).matches()){
                Toast.makeText(MainActivity.this,"Enter your email",Toast.LENGTH_SHORT).show();
                email.setError("Enter valid email");
                email.requestFocus();
            }
            if(p.isEmpty()){
                pass.setError("Enter your password");
                pass.requestFocus();
                if(p.length()<6){
                    Toast.makeText(MainActivity.this,"Minimum 6 characters required !",Toast.LENGTH_SHORT).show();
                }
            }

            auth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.VISIBLE);
                        Intent i=new Intent(MainActivity.this,MainScreen.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Failed to login !",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    });}
}