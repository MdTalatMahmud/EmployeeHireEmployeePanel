package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpressJobHuntSubMenuActivity extends AppCompatActivity {

    private Button setContactDetailsButton, jobAdvertisementsButton, appliedJobsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_job_hunt_sub_menu);

        //finding id
        jobAdvertisementsButton = findViewById(R.id.jobAdvertisementsButtonID);
        appliedJobsButton = findViewById(R.id.appliedJobsButtonID);
        setContactDetailsButton = findViewById(R.id.setContactDetailsButtonID);

        //button functioning
        setContactDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressJobHuntSubMenuActivity.this, SetMyContactDetailsActivity.class);
                startActivity(intent);
            }
        });

        jobAdvertisementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressJobHuntSubMenuActivity.this, JobPositionSelectionActivity.class);
                startActivity(intent);
            }
        });

        appliedJobsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressJobHuntSubMenuActivity.this, AppliedJobsActivity.class);
                startActivity(intent);
            }
        });


    }
}