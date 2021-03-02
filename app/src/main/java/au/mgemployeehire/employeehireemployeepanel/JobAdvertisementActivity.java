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
    private FirebaseDatabase mDatabase;
    private TextView keyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_advertisement);

        databaseReference = FirebaseDatabase.getInstance().getReference("JobAdvertisementInfo");
        jobAdvertisementDataList = new ArrayList<>();

        jobListAdapter = new JobListAdapter(JobAdvertisementActivity.this, jobAdvertisementDataList);

        jobAdvertisementList = findViewById(R.id.jobAdvListID);
        keyTextView = findViewById(R.id.keyTextViewID);

        //getting the id
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                int i = 0;
//                while (i<1){
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                        if ( i==1){
//                            String a = dataSnapshot.getKey();
//                            Toast.makeText(JobAdvertisementActivity.this,""+a, Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//
//                    }
//
//                }
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
////                        i++;
////                        if (i==2){
////                            String a = dataSnapshot.getKey();
////                            Toast.makeText(JobAdvertisementActivity.this,""+a, Toast.LENGTH_SHORT).show();
////                            break;
////                        }
////                        for (i=0; i<2; i++){
////                            String a = dataSnapshot.getKey();
////                            Toast.makeText(JobAdvertisementActivity.this,""+a, Toast.LENGTH_SHORT).show();
////                        }
//
//
//                    }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        //passing data to another activity from list
//        jobAdvertisementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Toast.makeText(JobAdvertisementActivity.this,""+viewStr, Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(JobAdvertisementActivity.this, JobDetailsActivity.class);
////                startActivity(intent);
//            }
//        });
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

                    //Toast.makeText(JobAdvertisementActivity.this,""+dataSnapshot1.getKey(), Toast.LENGTH_SHORT).show();
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