package au.mgemployeehire.employeehireemployeepanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstMenuActivity extends AppCompatActivity {

    private Button expressJobHuntButton, expressStaffButton, expressAssistantOrAdminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_menu);

        expressJobHuntButton = findViewById(R.id.expressJobHuntButtonID);
        expressStaffButton = findViewById(R.id.expressStaffButtonID);
        expressAssistantOrAdminButton = findViewById(R.id.expressAssistantOrAdminButtonID);

        expressJobHuntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressJobHuntSubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressStaffSubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressAssistantOrAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressAssistantOrAdminSubMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}