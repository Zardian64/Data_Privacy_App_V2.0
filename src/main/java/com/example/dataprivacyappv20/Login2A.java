package com.example.dataprivacyappv20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Login2A extends AppCompatActivity {

    private EditText email1, password1;
    private Button login1, signup;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //taking instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        login1 = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAct();
            }
        });

    }

        private void loginUserAccount(){

            // Take the value of two edit texts in Strings
            String email, password;
            email = email1.getText().toString();
            password = password1.getText().toString();

            // validations for input email and password
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getApplicationContext(),
                        "Please enter email!!",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(),
                        "Please enter password!!",
                        Toast.LENGTH_LONG)
                        .show();
                return;
            }

            // signin existing user
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            task -> {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Login successful",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // if sign-in is successful

                                    // intent to home activity
                                    Intent intent1 = new Intent(Login2A.this, homeMenu.class);
                                    startActivity(intent1);
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                            "Login failed",
                                            Toast.LENGTH_LONG)
                                            .show();

                                }
                            });
        }

    public void openNewAct() {
        Intent intent = new Intent (this, SignUp2B.class);
        startActivity(intent);
    }
}





