package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class JobAdvertisementActivity extends AppCompatActivity {

    private ListView jobAdvertisementList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_advertisement);

        jobAdvertisementList = findViewById(R.id.jobAdvListID);

        String[] companyNames = getResources().getStringArray(R.array.jobAdvArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(JobAdvertisementActivity.this, R.layout.job_adv_list_view, R.id.showJobAdvListID, companyNames);
        jobAdvertisementList.setAdapter(adapter);


    }
}