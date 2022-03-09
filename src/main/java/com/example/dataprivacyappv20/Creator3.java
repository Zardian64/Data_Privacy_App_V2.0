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
import com.google.firebase.database.ValueEventListener;



public class Creator3 extends AppCompatActivity  {

    private EditText question1, A1, A2, A3, A4;
    private Button addQ, finish;
    private DatabaseReference mDatabase;

    FirebaseDatabase database;
    DatabaseReference databaseReference;


    SurveyClass survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator3);


        question1 = findViewById(R.id.question);
        A1 = findViewById(R.id.Answer1);
        A2 = findViewById(R.id.Answer2);
        A3 = findViewById(R.id.Answer3);
        A4 = findViewById(R.id.Answer4);
        addQ = findViewById(R.id.saveQ);
        finish = findViewById(R.id.finish);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(SurveyClass.getName());
        mDatabase = FirebaseDatabase.getInstance().getReference();


        addQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // getting text from our edittext fields.
                String question = question1.getText().toString();
                String a1 = A1.getText().toString();
                String a2 = A2.getText().toString();
                String a3 = A3.getText().toString();
                String a4 = A4.getText().toString();


                // below line is for checking weather the
                // edittext fields are empty or not.
                if ((TextUtils.isEmpty(question)) && (TextUtils.isEmpty(a1)) && (TextUtils.isEmpty(a2)) && (TextUtils.isEmpty(a3)) && (TextUtils.isEmpty(a4))) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(Creator3.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDataToFirebase(question, a1, a2, a3, a4);
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openC4();
            }
        });
    }

    private void addDataToFirebase(String q, String a1, String a2, String a3, String a4) {
        // below 3 lines of code is used to set
        // data in our object class.
        SurveyClass.setQuestion(q);
        SurveyClass.setA1(a1);
        SurveyClass.setA2(a2);
        SurveyClass.setA3(a3);
        SurveyClass.setA4(a4);
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
                Toast.makeText(Creator3.this, "data added", Toast.LENGTH_SHORT).show();

                onClick();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(Creator3.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onClick() {
        Intent intent = new Intent(Creator3.this, Creator3.class);
        startActivity(intent);
       /* question1.setText("");
        A1.setText("");
        A2.setText("");
        A3.setText("");
        A4.setText("");
        */
    }


    public void openC4() {
        Intent intent = new Intent (Creator3.this, Creator4.class);
        startActivity(intent);
    }
}


