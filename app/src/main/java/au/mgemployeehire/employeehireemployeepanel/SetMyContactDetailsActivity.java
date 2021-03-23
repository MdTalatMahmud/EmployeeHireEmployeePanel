package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SetMyContactDetailsActivity extends AppCompatActivity {

    private EditText nameEditText, contactNumberEditText, emailEditText, educationalQualificationEditText, experienceEditText, LicenseEditText;
    private Button applicantDetailsSaveButton, backButton;
    private DatabaseReference databaseReference, databaseReference2;
    private CheckBox AM12_AM6_CheckBox, AM6_PM12_CheckBox, PM12_PM6_CheckBox, PM6_AM12_CheckBox;
    private TextView availabilityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_my_contact_details);

        databaseReference = FirebaseDatabase.getInstance().getReference("applicantDetails");

        //id finding
        nameEditText = findViewById(R.id.staffNameID);
        contactNumberEditText = findViewById(R.id.contactNumberID);
        emailEditText = findViewById(R.id.applicantEmailID);
        educationalQualificationEditText = findViewById(R.id.applicantEducationID);
        experienceEditText = findViewById(R.id.applicantExperienceID);
        LicenseEditText = findViewById(R.id.applicantLicenseID);
        availabilityTextView = findViewById(R.id.setAvailabilityTextViewID);
        applicantDetailsSaveButton = findViewById(R.id.saveApplicantDetailsBtnID);
        backButton = findViewById(R.id.backBtnID);

        //checkBox ID finding
        AM12_AM6_CheckBox = findViewById(R.id.AM12_AM6);
        AM6_PM12_CheckBox = findViewById(R.id.AM6_PM12);
        PM12_PM6_CheckBox = findViewById(R.id.PM12_PM6);
        PM6_AM12_CheckBox = findViewById(R.id.PM6_AM12);

        //Time table checkBox functioning
        AM12_AM6_CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AM12_AM6_CheckBox.isChecked()){
                    AM12_AM6_CheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    AM12_AM6_CheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        AM6_PM12_CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AM6_PM12_CheckBox.isChecked()){
                    AM6_PM12_CheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    AM6_PM12_CheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        PM12_PM6_CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PM12_PM6_CheckBox.isChecked()){
                    PM12_PM6_CheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    PM12_PM6_CheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        PM6_AM12_CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PM6_AM12_CheckBox.isChecked()){
                    PM6_AM12_CheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    PM6_AM12_CheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });


        //getting user email UID
        String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //retrieving values and setting to EditTexts
        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("applicantDetails").child(user_id);

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
                    //String availability = snapshot.child("applicantAvailability").getValue().toString();

                    nameEditText.setText(applicantName);
                    contactNumberEditText.setText(applicantContactNumber);
                    emailEditText.setText(applicantEmail);
                    educationalQualificationEditText.setText(applicantEducationalQualification);
                    experienceEditText.setText(applicantExperience);
                    LicenseEditText.setText(applicantLicense);
                    //availabilityTextView.setText(availability);

                }catch (Exception e){
                    Toast.makeText(SetMyContactDetailsActivity.this,"No data saved yet", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //back button functioning
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetMyContactDetailsActivity.super.onBackPressed();
            }
        });

        //save data using button
        applicantDetailsSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Time table data collect
                String timeTableString = "";
                if (AM12_AM6_CheckBox.isChecked()){
                    timeTableString += "\n12:00 AM - 6:00 AM";
                }
                if (AM6_PM12_CheckBox.isChecked()){
                    timeTableString += "\n6:00 AM - 12:00 PM";
                }
                if (PM12_PM6_CheckBox.isChecked()){
                    timeTableString += "\n12:00 PM - 6:00 PM";
                }
                if (PM6_AM12_CheckBox.isChecked()){
                    timeTableString += "\n6:00 PM - 12:00 AM";
                }
                availabilityTextView.setText(timeTableString);

                String applicantName = nameEditText.getText().toString();
                String applicantContactNumber = contactNumberEditText.getText().toString();
                String applicantEmail = emailEditText.getText().toString();
                String applicantEducationalQualification = educationalQualificationEditText.getText().toString();
                String applicantExperience = experienceEditText.getText().toString();
                String applicantLicense = LicenseEditText.getText().toString();
                //String availability = availabilityTextView.getText().toString();

                //getting user email UID
                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

                ApplicantDetails details = new ApplicantDetails(applicantName, applicantContactNumber, applicantEmail, applicantEducationalQualification, applicantExperience, applicantLicense);

                //setting value to database
                databaseReference.child(user_id).setValue(details);
                Toast.makeText(SetMyContactDetailsActivity.this,"User info saved Successfully!", Toast.LENGTH_LONG).show();


            }
        });

    }
}