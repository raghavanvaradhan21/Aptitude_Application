package com.example.aptitudetest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonlogin;
    FirebaseAuth nAuth;
    Button buttonregister;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = nAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword= findViewById(R.id.password);
        buttonlogin = findViewById(R.id.loginButton);
        nAuth=FirebaseAuth.getInstance();
        buttonregister=findViewById(R.id.btn_register);
        buttonregister.setOnClickListener(view -> {
                 Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
                finish();
        });

       buttonlogin.setOnClickListener(view -> {
           String email, password;
           email = String.valueOf(editTextEmail.getText());
           password = String.valueOf(editTextPassword.getText());

           if (TextUtils.isEmpty(email)) {
               Toast.makeText(Login.this,"Email is required",Toast.LENGTH_SHORT).show();
               return;
           }
           if (TextUtils.isEmpty(password)){
               Toast.makeText(Login.this,"Password is required",Toast.LENGTH_SHORT).show();
               return;
           }

           nAuth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(getApplicationContext(), "Login Successful.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                startActivity(intent);
                                finish();
                           } else {

                               Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                           }
                       }
                   });
       });
    }
    public void onBackPressed() {
        //super.onBackPressed();
        super.onBackPressed();
        {
            //to not go back we have to not call super.onBackpressed()
        }
    }
}