package com.example.dataprivacyappv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button continue1 = (Button) findViewById(R.id.continue1);
        continue1.setBackgroundColor(Color.RED);

        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewAct();
            }
        });
        }

    public void openNewAct() {
        Intent intent = new Intent (this, Login2A.class);
        startActivity(intent);
    }
}



