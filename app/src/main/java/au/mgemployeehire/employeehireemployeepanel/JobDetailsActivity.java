package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class JobDetailsActivity extends AppCompatActivity {

    private TextView jobAdvTextView;
    private TextView companyNameTextView, companyStreetTextView, companySuburbTextView, companyStateTextView, awardTextView, contactPersonNameTextView,
            contactPersonEmailTextView, contactPhoneNumberTextView, supervisorNameTextView, supervisorMobileNumberTextView, workingDivisionTextView,
            workStreetTextView, workSuburbTextView, workStateTextView, fromDateTextView, toDateTextView, fromTimeTextView, toTimeTextView, genderTextView,
            jobPositionTextView, workerQuantityTextView, jobTypeTextView, jobDescriptionTextView, ppeRequirementTextView, transportRequirementTextView,
            englishRequirementsTextView, liftingCapacityTextView, environmentTextView, licenseRequirementTextView;
    private Button applyButton, backButton;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        //id finding
        jobAdvTextView = findViewById(R.id.jobAdvID);

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
        genderTextView = findViewById(R.id.maleFemaleTVID);//problem here!
        jobPositionTextView = findViewById(R.id.jobPositionTVID);
        workerQuantityTextView = findViewById(R.id.numberOfStaffTVID);
        jobTypeTextView = findViewById(R.id.jobTypeTVID);
        jobDescriptionTextView = findViewById(R.id.jobDescriptionTVID);
        ppeRequirementTextView = findViewById(R.id.ppeRequirementsTVID);
        transportRequirementTextView = findViewById(R.id.transportRequirementsTVID);
        englishRequirementsTextView = findViewById(R.id.engRequirementTVID);
        liftingCapacityTextView = findViewById(R.id.liftingCapacityTVID);
        environmentTextView = findViewById(R.id.temparatureTVID);
        licenseRequirementTextView = findViewById(R.id.licenseRequiredTVID);

        applyButton = findViewById(R.id.jobApplyBtnID);
        backButton = findViewById(R.id.backBtnID);

        jobAdvTextView.setText(AppConstant.keyStr);
        String key = jobAdvTextView.getText().toString();

        //getting data from database
        databaseReference = FirebaseDatabase.getInstance().getReference().child("JobAdvertisementInfo").child(JobAdvertisementActivity.jobPosStr).child(key);
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
                genderTextView.setText(gender); //gotta bug here!
                jobPositionTextView.setText(jobPosition);
                workerQuantityTextView.setText(workerQuantity);
                jobTypeTextView.setText(jobType);
                jobDescriptionTextView.setText(jobDescription);
                ppeRequirementTextView.setText(ppe);
                transportRequirementTextView.setText(transportRequirement);
                englishRequirementsTextView.setText(englishRequirement);
                liftingCapacityTextView.setText(liftingCapacity);
                environmentTextView.setText(environment);
                licenseRequirementTextView.setText(licenseRequirement);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //back button functioning
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobDetailsActivity.super.onBackPressed();
            }
        });

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finding email that is used for sign in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String userEmail = user.getEmail();

                //getting user email UID
                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                //retrieving info of applicant
                DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("applicantDetails").child(user_id);

                databaseReference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            String applicantName = snapshot.child("applicantName").getValue().toString();
                            String applicantContactNumber = snapshot.child("applicantContactNumber").getValue().toString();
                            String applicantEmail = snapshot.child("applicantEmail").getValue().toString();
                            String applicantEducationalQualification = snapshot.child("applicantEducationalQualification").getValue().toString();
                            String applicantExperience = snapshot.child("applicantExperience").getValue().toString();
                            String applicantLicense = snapshot.child("applicantLicense").getValue().toString();
                            String applicantAvailability = snapshot.child("applicantAvailability").getValue().toString();

                            //communicating database..sending apply information to database
                            DatabaseReference dr;
                            dr = FirebaseDatabase.getInstance().getReference().child("jobApplyRecords");
                            //String uniqueKey = dr.push().getKey();//generating uniqueKey, not using anymore
                            String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();//getting signed in user email unique id
                            dr.child(key).child(user_id).child("email").setValue(userEmail); //this email is signed in email (email that is used for sign in)
                            dr.child(key).child(user_id).child("applicantName").setValue(applicantName);
                            dr.child(key).child(user_id).child("applicantContactNumber").setValue(applicantContactNumber);
                            dr.child(key).child(user_id).child("applicantContactEmail").setValue(applicantEmail);
                            dr.child(key).child(user_id).child("applicantEducationalQualification").setValue(applicantEducationalQualification);
                            dr.child(key).child(user_id).child("applicantExperience").setValue(applicantExperience);
                            dr.child(key).child(user_id).child("applicantLicense").setValue(applicantLicense);
                            dr.child(key).child(user_id).child("applicantAvailability").setValue(applicantAvailability);
                            dr.child(key).child(user_id).child("encryptedEmailID").setValue(user_id);

                            //sending job advertisement info under user_id to the database
                            DatabaseReference databaseReference1;
                            databaseReference1 = FirebaseDatabase.getInstance().getReference().child("appliedJobId");

                            //databaseReference1.child(user_id).child(key).setValue(key);
                            databaseReference1.child(user_id).child(key).child("companyNameStr").setValue(companyNameTextView.getText());
                            databaseReference1.child(user_id).child(key).child("streetStr").setValue(companyStreetTextView.getText());
                            databaseReference1.child(user_id).child(key).child("suburbStr").setValue(companySuburbTextView.getText());
                            databaseReference1.child(user_id).child(key).child("stateStr").setValue(companyStateTextView.getText());
                            databaseReference1.child(user_id).child(key).child("awardStr").setValue(awardTextView.getText());
                            databaseReference1.child(user_id).child(key).child("yourNameStr").setValue(contactPersonNameTextView.getText());
                            databaseReference1.child(user_id).child(key).child("emailStr").setValue(contactPersonEmailTextView.getText());
                            databaseReference1.child(user_id).child(key).child("phoneStr").setValue(contactPhoneNumberTextView.getText());
                            databaseReference1.child(user_id).child(key).child("nameOfThePersonStr").setValue(supervisorNameTextView.getText());
                            databaseReference1.child(user_id).child(key).child("supervisorMobileNumberStr").setValue(supervisorMobileNumberTextView.getText());
                            databaseReference1.child(user_id).child(key).child("workingDivisionStr").setValue(workingDivisionTextView.getText());
                            databaseReference1.child(user_id).child(key).child("workSiteStreetStr").setValue(workStreetTextView.getText());
                            databaseReference1.child(user_id).child(key).child("workSiteSuburbStr").setValue(workSuburbTextView.getText());
                            databaseReference1.child(user_id).child(key).child("workSiteStateStr").setValue(workStateTextView.getText());
                            databaseReference1.child(user_id).child(key).child("fromDateStr").setValue(fromDateTextView.getText());
                            databaseReference1.child(user_id).child(key).child("toDateStr").setValue(toDateTextView.getText());
                            databaseReference1.child(user_id).child(key).child("startTimeStr").setValue(fromTimeTextView.getText());
                            databaseReference1.child(user_id).child(key).child("endTimeStr").setValue(toTimeTextView.getText());
                            databaseReference1.child(user_id).child(key).child("maleFemaleStr").setValue(genderTextView.getText());
                            databaseReference1.child(user_id).child(key).child("jobPositionStr").setValue(jobPositionTextView.getText());
                            databaseReference1.child(user_id).child(key).child("workerQuantityStr").setValue(workerQuantityTextView.getText());
                            databaseReference1.child(user_id).child(key).child("jobTypeStr").setValue(jobTypeTextView.getText());
                            databaseReference1.child(user_id).child(key).child("jobDescriptionStr").setValue(jobDescriptionTextView.getText());
                            databaseReference1.child(user_id).child(key).child("ppeStr").setValue(ppeRequirementTextView.getText());
                            databaseReference1.child(user_id).child(key).child("transportRequirementsStr").setValue(transportRequirementTextView.getText());
                            databaseReference1.child(user_id).child(key).child("engRequirementStr").setValue(englishRequirementsTextView.getText());
                            databaseReference1.child(user_id).child(key).child("liftingCapacityStr").setValue(liftingCapacityTextView.getText());
                            databaseReference1.child(user_id).child(key).child("environmentStr").setValue(environmentTextView.getText());
                            databaseReference1.child(user_id).child(key).child("licenseRequiredStr").setValue(licenseRequirementTextView.getText());
                            databaseReference1.child(user_id).child(key).child("keyStr").setValue(key);

                            //show job apply confirmation message with a toast
                            Toast.makeText(getApplicationContext(), "Congratulation! Successfully Applied",Toast.LENGTH_LONG).show();

                            //back to MainActivity.class
                            Intent intent = new Intent(JobDetailsActivity.this, MainActivity.class);
                            startActivity(intent);

                        }catch (Exception e){
                            Toast.makeText(JobDetailsActivity.this,"Something went wrong. Try again please.", Toast.LENGTH_LONG).show();
                        }

                        //
                        //DatabaseReference databaseReference3 = FirebaseDatabase.getInstance().getReference();
                        

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                //sending email function call
                sendEmail();
            }
        });


    }

    //sending email function
    private void sendEmail(){
        String mEmail = "freshexport.order@gmail.com";
        String mSubject = "Someone Applied";
        String mMessage = "Someone Applied to a job. \n Company Information:\nJob ID is "+jobAdvTextView.getText()+", Company Name: "+companyNameTextView.getText()+
                ", Contact person name: "+contactPersonNameTextView.getText()+", Contact Person Email: "+contactPersonEmailTextView.getText()+", Contact Phone: "+contactPhoneNumberTextView.getText();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);
        javaMailAPI.execute();

    }
}