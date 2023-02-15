package com.example.ticketapplication.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.ticketapplication.MainActivity;
import com.example.ticketapplication.R;
import com.example.ticketapplication.databinding.ActivityLoginBinding;
import com.example.ticketapplication.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    private String email ="", password ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Progress Dialog...
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Logging In");
        progressDialog.setCanceledOnTouchOutside(false);

        //start firebase auth
        firebaseAuth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validate Data
                validateData();
            }
        });
    }

    private void validateData() {
        //get data
        email = binding.emailEt.getText().toString().trim();
        password = binding.passwordEt.getText().toString().trim();

        //Validating Data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //If invalid email
            binding.emailEt.setError("Invalid email format");
        } else if (TextUtils.isEmpty(password)) {
            //Password Field is empty
            binding.passwordEt.setError("Enter Password");
        } 
        else {
            //Confirming data with database
            firebaseLogin();
        }

    }

    private void firebaseLogin() {
        //show progress
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                //Login Success
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();  //getting user info
                String email = firebaseUser.getEmail();
                Toast.makeText(LoginActivity.this,"Logged In\n"+email, Toast.LENGTH_SHORT).show();
                //open MainActivity
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Login Failed, show error message
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, ""+e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void register (View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
}