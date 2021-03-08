package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JobPositionSelectionActivity extends AppCompatActivity {

    private Button nextButton, backButton;
    private RadioGroup jobPositionRadioGroup;
    private RadioButton jobPositionRadioButton;
    private TextView jobPositionTextView, maleFemaleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_position_selection);

        jobPositionTextView = findViewById(R.id.jobPositionTextID);
        maleFemaleTextView = findViewById(R.id.maleFemaleTextID);

        nextButton = findViewById(R.id.JobPositionSelectionNextBtnID);
        backButton = findViewById(R.id.backJobPositionSelectionPageBtnID);

        jobPositionRadioGroup = findViewById(R.id.jobPositionRadioGroup);

        //getting male/female data
        Bundle maleFemaleBundle = getIntent().getExtras();
        if (maleFemaleBundle!=null){
            String maleFemaleStr = maleFemaleBundle.getString("maleFemale");
            maleFemaleTextView.setText(maleFemaleStr);
            //maleFemaleString = maleFemaleStr;
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobPositionSelectionActivity.this, JobAdvertisementActivity.class);

                try{
                    int jobPost = jobPositionRadioGroup.getCheckedRadioButtonId();
                    jobPositionRadioButton = findViewById(jobPost);
                    jobPositionTextView.setText(jobPositionRadioButton.getText());
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Please, select one",Toast.LENGTH_LONG).show();
                }
                //sending jobPosition
                String jobPosStr = jobPositionTextView.getText().toString();
                intent.putExtra("jobPosition", jobPosStr);

                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobPositionSelectionActivity.super.onBackPressed();
            }
        });
    }

    public void jobPosition(View view){
        int jobPos = jobPositionRadioGroup.getCheckedRadioButtonId();
        jobPositionRadioButton = findViewById(jobPos);
    }
}