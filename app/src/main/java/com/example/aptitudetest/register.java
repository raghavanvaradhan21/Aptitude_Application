package com.example.aptitudetest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    EditText editTextName,editTextEmail,editTextPhone,editTextPassword;
    Button buttonreg;
    FirebaseAuth nAuth;
    Button buttonlogin;

    FirebaseFirestore fstore;

    String UserID;

    public static final String TAG ="TAG";
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is already logged ins (non-null) and update UI accordingly.
        FirebaseUser currentUser = nAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName=findViewById(R.id.name);
        editTextEmail=findViewById(R.id.email);
        editTextPhone=findViewById(R.id.phone);
        editTextPassword=findViewById(R.id.password);
        buttonreg=findViewById(R.id.regButton);
        buttonlogin=findViewById(R.id.btn_login);
        nAuth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

       buttonlogin.setOnClickListener(view -> {
           Intent intent = new Intent(getApplicationContext(),Login.class);
           startActivity(intent);
           finish();
       });

        buttonreg.setOnClickListener(view -> {
            String name,email,phone,password;


            name = String.valueOf(editTextName.getText());
            email = String.valueOf(editTextEmail.getText());
            phone = String.valueOf(editTextPhone.getText());
            password = String.valueOf(editTextPassword.getText());


            if (TextUtils.isEmpty(name)) {
                Toast.makeText(register.this,"Enter Name",Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(register.this,"Enter Email",Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(phone)) {
                Toast.makeText(register.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(register.this,"Enter Password",Toast.LENGTH_SHORT).show();
                return;
             }


            nAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(register.this, "Account Created.",Toast.LENGTH_SHORT).show();
                        UserID = nAuth.getCurrentUser().getUid();

                        Map<String,Object> user = new HashMap<>();
                        user.put("Name",name);
                        user.put("Email",email);
                        user.put("Phone",phone);
                        DocumentReference documentReference = fstore.collection("Users").document(UserID);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG,"On Success User Profile is Created ");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d(TAG,"On Failure ", e);
                            }
                        });

                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        {
            //to not go back we have to not call super.onBackpressed()
        }
    }
}