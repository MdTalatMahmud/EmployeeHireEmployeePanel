package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobDetailsOfAppliedJobsActivity extends AppCompatActivity {

    private TextView jobPositionTV, jobTypeTV, departmentTV, fromTimeTV, toTimeTV, maleFemaleTV, numberOfStaffTV, jobDescriptionTV,
            ppeRequirementsTV, transportRequirementsTV, engRequirementTV, liftingCapacityTV, additionalRequirementTV, temperatureTV, licenseRequiredTV;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details_of_applied_jobs);

        //getting up back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //finding id
        jobPositionTV = findViewById(R.id.jobPositionTVID2);
        jobTypeTV = findViewById(R.id.jobTypeTVID2);
        departmentTV = findViewById(R.id.departmentTVID2);
        fromTimeTV = findViewById(R.id.fromTimeTVID2);
        toTimeTV = findViewById(R.id.toTimeTVID2);
        maleFemaleTV = findViewById(R.id.maleFemaleTVID2);
        numberOfStaffTV = findViewById(R.id.numberOfStaffTVID2);
        jobDescriptionTV = findViewById(R.id.jobDescriptionTVID2);
        ppeRequirementsTV = findViewById(R.id.ppeRequirementsTVID2);
        transportRequirementsTV = findViewById(R.id.transportRequirementsTVID2);
        engRequirementTV = findViewById(R.id.engRequirementTVID2);
        liftingCapacityTV = findViewById(R.id.liftingCapacityTVID2);
        additionalRequirementTV = findViewById(R.id.additionalRequirementTVID2);
        temperatureTV = findViewById(R.id.temperatureTVID2);
        licenseRequiredTV = findViewById(R.id.licenseRequiredTVID2);


        //getting user email UID
        String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

//        jobAdvTextView.setText(AppConstant.keyStr);
//        String key = jobAdvTextView.getText().toString();

        //getting data from database
        databaseReference = FirebaseDatabase.getInstance().getReference().child("appliedJobId").child(user_id).child(AppConstant.appliedJobKeyStr);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //fetching data from database
                try {   //here is a problem
                String division = snapshot.child("workingDivisionStr").getValue().toString();
                String fromTime = snapshot.child("startTimeStr").getValue().toString();
                String toTime = snapshot.child("endTimeStr").getValue().toString();
                String gender = snapshot.child("maleFemaleStr").getValue().toString();//here is a mistake
                String jobPosition = snapshot.child("jobPositionStr").getValue().toString();
                String workerQuantity = snapshot.child("workerQuantityStr").getValue().toString();
                String jobType = snapshot.child("jobTypeStr").getValue().toString();
                String jobDescription = snapshot.child("jobDescriptionStr").getValue().toString();
                String ppe = snapshot.child("ppeStr").getValue().toString();
                String transportRequirement = snapshot.child("transportRequirementsStr").getValue().toString();
                String englishRequirement = snapshot.child("engRequirementStr").getValue().toString();
                String liftingCapacity = snapshot.child("liftingCapacityStr").getValue().toString();
                String environment = snapshot.child("environmentStr").getValue().toString();
                String licenseRequirement = snapshot.child("licenseRequiredStr").getValue().toString();
                String additionalRequirement = snapshot.child("additionalRequirementStr").getValue().toString();

                //setting data to textView

                    jobPositionTV.setText(jobPosition);
                    jobTypeTV.setText(jobType);
                    departmentTV.setText(division);
                    fromTimeTV.setText(fromTime);
                    toTimeTV.setText(toTime);
                    maleFemaleTV.setText(gender); //gotta bug here!
                    numberOfStaffTV.setText(workerQuantity);
                    jobDescriptionTV.setText(jobDescription);
                    ppeRequirementsTV.setText(ppe);
                    transportRequirementsTV.setText(transportRequirement);
                    engRequirementTV.setText(englishRequirement);
                    liftingCapacityTV.setText(liftingCapacity);
                    additionalRequirementTV.setText(additionalRequirement);
                    temperatureTV.setText(environment);
                    licenseRequiredTV.setText(licenseRequirement);
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Problem loading the job details",Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}