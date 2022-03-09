package com.example.dataprivacyappv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homeMenu extends AppCompatActivity {

    private TextView opening, surveyText;
    private Button createSurvey, toInfo, takeSurvey, accInfoChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        Button  accInfo, prot, survey, create;

        accInfo = findViewById(R.id.accInfoChange);
        prot = findViewById(R.id.prot);
        survey = findViewById(R.id.takeSurvey);
        create = findViewById(R.id.createSurvey);

        prot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProt();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreator();
            }
        });
    }

    public void openProt() {
        Intent intent = new Intent (this, protection_Details.class);
        startActivity(intent);
    }

    public void openCreator(){
        Intent intent1 = new Intent(homeMenu.this,
                Creator2.class);
        startActivity(intent1);
    }
}