package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

    private EditText nameEditText, contactNumberEditText, emailEditText, experienceEditText, LicenseEditText;
    private Button applicantDetailsSaveButton, backButton;
    private DatabaseReference databaseReference, databaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_my_contact_details);

        databaseReference = FirebaseDatabase.getInstance().getReference("applicantDetails");

        //id finding
        nameEditText = findViewById(R.id.staffNameID);
        contactNumberEditText = findViewById(R.id.contactNumberID);
        emailEditText = findViewById(R.id.applicantEmailID);
        experienceEditText = findViewById(R.id.applicantExperienceID);
        LicenseEditText = findViewById(R.id.applicantLicenseID);
        applicantDetailsSaveButton = findViewById(R.id.saveApplicantDetailsBtnID);
        backButton = findViewById(R.id.backBtnID);

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
                    String applicantExperience = snapshot.child("applicantExperience").getValue().toString();
                    String applicantLicense = snapshot.child("applicantLicense").getValue().toString();

                    nameEditText.setText(applicantName);
                    contactNumberEditText.setText(applicantContactNumber);
                    emailEditText.setText(applicantEmail);
                    experienceEditText.setText(applicantExperience);
                    LicenseEditText.setText(applicantLicense);

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
                String applicantName = nameEditText.getText().toString();
                String applicantContactNumber = contactNumberEditText.getText().toString();
                String applicantEmail = emailEditText.getText().toString();
                String applicantExperience = experienceEditText.getText().toString();
                String applicantLicense = LicenseEditText.getText().toString();

                //getting user email UID
                String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

                ApplicantDetails details = new ApplicantDetails(applicantName, applicantContactNumber, applicantEmail, applicantExperience, applicantLicense);

                //setting value to database
                databaseReference.child(user_id).setValue(details);
                Toast.makeText(SetMyContactDetailsActivity.this,"User info saved Successfully!", Toast.LENGTH_LONG).show();


            }
        });

    }
}