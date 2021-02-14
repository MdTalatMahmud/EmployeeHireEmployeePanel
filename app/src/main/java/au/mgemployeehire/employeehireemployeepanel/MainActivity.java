package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button jobAdvButton, appliedJobsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding id
        jobAdvButton = findViewById(R.id.jobAdvBtnID);
        appliedJobsButton = findViewById(R.id.appliedJobsBtnID);

        //button functioning
        jobAdvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JobAdvertisementActivity.class);
                startActivity(intent);
            }
        });

        appliedJobsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppliedJobsActivity.class);
                startActivity(intent);
            }
        });
    }
}