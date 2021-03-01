package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class INeedJobActivity extends AppCompatActivity {

    private Button iNeedJobButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_need_job);

        iNeedJobButton = findViewById(R.id.iNeedJobBtnID);

        iNeedJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(INeedJobActivity.this, PartOrFullTimeJobActivity.class);
                startActivity(intent);
            }
        });
    }
}