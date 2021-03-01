package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_advertisement);

        databaseReference = FirebaseDatabase.getInstance().getReference("JobAdvertisementInfo");
        jobAdvertisementDataList = new ArrayList<>();

        jobListAdapter = new JobListAdapter(JobAdvertisementActivity.this, jobAdvertisementDataList);

        jobAdvertisementList = findViewById(R.id.jobAdvListID);

        //passing data to another activity from list
        jobAdvertisementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(JobAdvertisementActivity.this, JobDetailsActivity.class);
                startActivity(intent);
            }
        });
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