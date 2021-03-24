package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppliedJobsActivity extends AppCompatActivity {

    private ListView appliedJobList;
    private DatabaseReference databaseReference;
    private List<AppliedJobAdvertisementData> appliedJobDataList;
    private AppliedJobListAdapter jobListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applied_jobs);

        //getting up back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //finding id
        appliedJobList = findViewById(R.id.appliedJobListID);

        //getting user email UID
        String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //communicating database
        databaseReference = FirebaseDatabase.getInstance().getReference("appliedJobId").child(user_id);
        appliedJobDataList = new ArrayList<>();

        jobListAdapter = new AppliedJobListAdapter(AppliedJobsActivity.this, appliedJobDataList);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                appliedJobDataList.clear();
                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    AppliedJobAdvertisementData jobAdvertisementData = dataSnapshot1.getValue(AppliedJobAdvertisementData.class);
                    appliedJobDataList.add(jobAdvertisementData);
                }
                appliedJobList.setAdapter(jobListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}