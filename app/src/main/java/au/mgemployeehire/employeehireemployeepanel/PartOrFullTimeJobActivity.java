package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartOrFullTimeJobActivity extends AppCompatActivity {

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_or_full_time_job);

        nextButton = findViewById(R.id.nextBtnID);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartOrFullTimeJobActivity.this, WhatKindsOfJobsActivity.class);
                startActivity(intent);
            }
        });
    }
}