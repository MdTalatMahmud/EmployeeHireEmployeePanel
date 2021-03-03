package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobDetailsActivity extends AppCompatActivity {

    private TextView keyTextView;
    private TextView companyNameTextView, companyStreetTextView, companySuburbTextView, companyStateTextView, awardTextView, contactPersonNameTextView,
            contactPersonEmailTextView, contactPhoneNumberTextView, supervisorNameTextView, supervisorMobileNumberTextView, workingDivisionTextView,
            workStreetTextView, workSuburbTextView, workStateTextView, fromDateTextView, toDateTextView, fromTimeTextView, toTimeTextView, genderTextView,
            jobPositionTextView, workerQuantityTextView, jobTypeTextView, jobDescriptionTextView, ppeRequirementTextView, transportRequirementTextView;
    private Button applybutton;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        //id finding
        keyTextView = findViewById(R.id.keyTExtID);

        companyNameTextView = findViewById(R.id.conpanyNameTVID);
        companyStreetTextView = findViewById(R.id.streetTVID);
        companySuburbTextView = findViewById(R.id.suburbTVID);
        companyStateTextView = findViewById(R.id.stateTVID);
        awardTextView = findViewById(R.id.industryAwardTVID);
        contactPersonNameTextView = findViewById(R.id.contactPersonNameTVID);
        contactPersonEmailTextView = findViewById(R.id.contactPersonEmailTVID);
        contactPhoneNumberTextView = findViewById(R.id.contactPhoneNoTVID);
        supervisorNameTextView = findViewById(R.id.supervisorNameTVID);
        supervisorMobileNumberTextView = findViewById(R.id.siteSupervisorMobileNoTVID);
        workingDivisionTextView = findViewById(R.id.departmentTVID);
        workStreetTextView = findViewById(R.id.worksiteStreetTVID);
        workSuburbTextView = findViewById(R.id.worksiteSuburbTVID);
        workStateTextView = findViewById(R.id.worksiteStateTVID);
        fromDateTextView = findViewById(R.id.fromDateTVID);
        toDateTextView = findViewById(R.id.toDateTVID);
        fromTimeTextView = findViewById(R.id.fromTimeTVID);
        toTimeTextView = findViewById(R.id.toTimeTVID);
        //genderTextView = findViewById(R.id.genderTVID);
        jobPositionTextView = findViewById(R.id.jobPositionTVID);
        workerQuantityTextView = findViewById(R.id.numberOfStaffTVID);
        jobTypeTextView = findViewById(R.id.jobTypeTVID);
        jobDescriptionTextView = findViewById(R.id.jobDescriptionTVID);
        ppeRequirementTextView = findViewById(R.id.ppeRequirementsTVID);
        transportRequirementTextView = findViewById(R.id.transportRequirementsTVID);

        applybutton = findViewById(R.id.jobApplyBtnID);

        keyTextView.setText(AppConstant.keyStr);
        String key = keyTextView.getText().toString();

        //getting data from database
        databaseReference = FirebaseDatabase.getInstance().getReference().child("JobAdvertisementInfo").child(key);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //fetching data from database
                String companyName = snapshot.child("companyNameStr").getValue().toString();
                String companyStreet = snapshot.child("streetStr").getValue().toString();
                String companySuburb = snapshot.child("suburbStr").getValue().toString();
                String companyState = snapshot.child("stateStr").getValue().toString();
                String industryAward = snapshot.child("awardStr").getValue().toString();
                String contactPersonName = snapshot.child("yourNameStr").getValue().toString();
                String contactPersonEmail = snapshot.child("emailStr").getValue().toString();
                String contactPhoneNumber = snapshot.child("phoneStr").getValue().toString();
                String supervisorName = snapshot.child("nameOfThePersonStr").getValue().toString();
                String supervisorMobileNumber = snapshot.child("supervisorMobileNumberStr").getValue().toString();
                String division = snapshot.child("workingDivisionStr").getValue().toString();
                String workStreet = snapshot.child("workSiteStreetStr").getValue().toString();
                String workSuburb = snapshot.child("workSiteSuburbStr").getValue().toString();
                String workState = snapshot.child("workSiteStateStr").getValue().toString();
                String fromDate = snapshot.child("fromDateStr").getValue().toString();
                String toDate = snapshot.child("toDateStr").getValue().toString();
                String fromTime = snapshot.child("startTimeStr").getValue().toString();
                String toTime = snapshot.child("endTimeStr").getValue().toString();
                //String gender = snapshot.child("endTimeStr").getValue().toString();//here is a mistake
                String jobPosition = snapshot.child("jobPositionStr").getValue().toString();
                String workerQuantity = snapshot.child("workerQuantityStr").getValue().toString();
                String jobType = snapshot.child("jobTypeStr").getValue().toString();
                String jobDescription = snapshot.child("jobDescriptionStr").getValue().toString();
                String ppe = snapshot.child("ppeStr").getValue().toString();
                String transportRequirement = snapshot.child("transportRequirementsStr").getValue().toString();

                //setting data to textView
                companyNameTextView.setText(companyName);
                companyStreetTextView.setText(companyStreet);
                companySuburbTextView.setText(companySuburb);
                companyStateTextView.setText(companyState);
                awardTextView.setText(industryAward);
                contactPersonNameTextView.setText(contactPersonName);
                contactPersonEmailTextView.setText(contactPersonEmail);
                contactPhoneNumberTextView.setText(contactPhoneNumber);
                supervisorNameTextView.setText(supervisorName);
                supervisorMobileNumberTextView.setText(supervisorMobileNumber);
                workingDivisionTextView.setText(division);
                workStreetTextView.setText(workStreet);
                workSuburbTextView.setText(workSuburb);
                workStateTextView.setText(workState);
                fromDateTextView.setText(fromDate);
                toDateTextView.setText(toDate);
                fromTimeTextView.setText(fromTime);
                toTimeTextView.setText(toTime);
                //genderTextView.setText(gender);
                jobPositionTextView.setText(jobPosition);
                workerQuantityTextView.setText(workerQuantity);
                jobTypeTextView.setText(jobType);
                jobDescriptionTextView.setText(jobDescription);
                ppeRequirementTextView.setText(ppe);
                transportRequirementTextView.setText(transportRequirement);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        applybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("JobAdvertisementInfo").child(a);
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        String companyName = snapshot.child("companyNameStr").getValue().toString();
//                        companyNameTextView.setText(companyName);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
            }
        });


    }
}