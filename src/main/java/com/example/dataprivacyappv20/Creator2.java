package com.example.dataprivacyappv20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.sql.Ref;
import java.util.jar.Attributes;

import javax.xml.namespace.QName;

public class Creator2 extends AppCompatActivity {

        private EditText Name1;
        private Button continue2;
        private DatabaseReference mDatabase;

    //Database
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    SurveyClass survey;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_creator2);

            Name1 = findViewById(R.id.surveyTitle);
            continue2 =findViewById(R.id.continue2);

            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference("survey");
            mDatabase = FirebaseDatabase.getInstance().getReference();

            survey = new SurveyClass();

            continue2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    // getting text from our edittext fields.
                    String name = Name1.getText().toString();



                    // below line is for checking weather the
                    // edittext fields are empty or not.
                    if (TextUtils.isEmpty(name)) {
                        // if the text fields are empty
                        // then show the below message.
                        Toast.makeText(Creator2.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        // else call the method to add
                        // data to our database.
                        addDatatoFirebase(name);
                    }
                }
            });
        }

    private void addDatatoFirebase(String name) {
        // below 3 lines of code is used to set
        // data in our object class.
        SurveyClass.setName(name);
        // we are use add value event listener method
        // which is called with database reference.

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(survey);

                // after adding this data we are showing toast message.
                Toast.makeText(Creator2.this, "data added", Toast.LENGTH_SHORT).show();

                openNewAct();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(Creator2.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }



        public void openNewAct() {
            Intent intent = new Intent (Creator2.this, Creator3.class);
            startActivity(intent);
        }

    }

