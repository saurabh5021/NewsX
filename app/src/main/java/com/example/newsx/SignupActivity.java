package com.example.newsx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    EditText email,password, repassword;
    Button signupBtn;
    TextView signin;
    String emailPattern = "[a-zA-Z0-9,_-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        email= findViewById(R.id.email);
        password = findViewById(R.id.passwordsignup);
        signupBtn  = findViewById(R.id.signupbtn);
        repassword = findViewById(R.id.repassword);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });



    }

    private void Register()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String repass = repassword.getText().toString().trim();
        if(user.isEmpty())
        {
            email.setError("Email can not be empty");
        }
        if(!user.matches(emailPattern)){
            email.setError("Entered email is not valid");
        }
        if(pass.isEmpty())
        {
            password.setError("Password can not be empty");
        }
        if(repass.isEmpty())
        {
            repassword.setError("Password can not be empty");
        }
        if(!repass.equals(pass)){
            repassword.setError("Password does not match");
        }

        else
        {


            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignupActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this, MainActivity.class));

                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


}