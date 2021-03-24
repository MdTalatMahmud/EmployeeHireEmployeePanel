package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class JobAdvertisementActivity extends AppCompatActivity {

    private ListView jobAdvertisementList;
    DatabaseReference databaseReference;
    private List<JobAdvertisementData> jobAdvertisementDataList;
    private JobListAdapter jobListAdapter;
    public static String jobPosStr;
    private TextView keyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_advertisement);

        //catching job position
        Bundle jobPosition = getIntent().getExtras();
        if (jobPosition!=null){
            jobPosStr = jobPosition.getString("jobPosition");
        }

        //communicating database
        databaseReference = FirebaseDatabase.getInstance().getReference("JobAdvertisementInfo").child(jobPosStr);
        jobAdvertisementDataList = new ArrayList<>();

        jobListAdapter = new JobListAdapter(JobAdvertisementActivity.this, jobAdvertisementDataList);

        jobAdvertisementList = findViewById(R.id.jobAdvListID);
        keyTextView = findViewById(R.id.keyTextViewID);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                jobAdvertisementDataList.clear();
                for (DataSnapshot dataSnapshot1 : snapshot.getChildren()){
                    JobAdvertisementData jobAdvertisementData = dataSnapshot1.getValue(JobAdvertisementData.class);
                    jobAdvertisementDataList.add(jobAdvertisementData);
                }
                jobAdvertisementList.setAdapter(jobListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}