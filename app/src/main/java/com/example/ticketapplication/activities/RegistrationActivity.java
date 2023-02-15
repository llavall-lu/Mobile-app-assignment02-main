package com.example.ticketapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.ticketapplication.MainActivity;
import com.example.ticketapplication.R;
import com.example.ticketapplication.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog progressDialog;

    private String email ="", password ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //start firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        //Progress Dialog...
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Creating your account...");
        progressDialog.setCanceledOnTouchOutside(false);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData() {
        //Getting Data
        email = binding.emailEt.getText().toString().trim();
        password = binding.passwordEt.getText().toString().trim();

        //Validating Data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //If invalid email
            binding.emailEt.setError("Invalid email format");
        } else if (TextUtils.isEmpty(password)) {
            //Password Field is empty
            binding.passwordEt.setError("Enter Password");
        } else if (password.length()<6) {
            //If password is less than 6 characters long
            binding.emailEt.setError("Password must be 6 or more characters long");
        }
        else {
            //Confirming data with database
            firebaseSignUp();
        }
    }

    private void firebaseSignUp() {
        //show progress
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                //signup Success
                progressDialog.dismiss();
                //get user info
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                String email = firebaseUser.getEmail();
                Toast.makeText(RegistrationActivity.this,"Account created\n"+email, Toast.LENGTH_SHORT).show();
                //open MainActivity
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    //signup failed
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void login(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));   //opens Login Activity
    }
}