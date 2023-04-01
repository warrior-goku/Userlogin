package com.example.land;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText fullname,signupemail,number,signupPassword,confirmpassword;
    private Button signupButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        fullname = findViewById(R.id.Fullname);
        number = findViewById(R.id.Mobile);
        signupemail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        confirmpassword = findViewById(R.id.confirmpassword);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullname.getText().toString().trim();
                String email = signupemail.getText().toString().trim();
                String num  = number.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();
                String confirm = confirmpassword.getText().toString().trim();

                if(name.isEmpty()){
                    fullname.setError("Fullname can't be Empty");
                }
                if (email.isEmpty()){
                    signupemail.setError("Email can;t be Empty");
                }
                if (num.isEmpty()){
                    number.setError("Mobile number can't be Empty");
                }
                if (pass.isEmpty()){
                    signupPassword.setError("password can;t be Empty");
                }
                if (confirm.isEmpty()){
                    confirmpassword.setError("confirm-password can't be Empty");
                } else{

                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "Signup Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this,Login.class));
                            }else {
                                Toast.makeText(signup.this, "Signup Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,Login.class));
            }
        });

    }
}