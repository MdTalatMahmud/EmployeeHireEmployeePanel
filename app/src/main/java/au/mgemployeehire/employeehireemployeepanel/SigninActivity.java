package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText signInEmailEditText, signInPasswordEditText;
    private TextView gotoSignUpTextView;
    private Button signInButton;
    private ProgressBar signInProgressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth = FirebaseAuth.getInstance();

        signInEmailEditText = findViewById(R.id.signinEmailID);
        signInPasswordEditText = findViewById(R.id.signinPasswordID);
        gotoSignUpTextView = findViewById(R.id.gotoSignUpTVID);
        signInButton = findViewById(R.id.signinBtnID);
        signInProgressBar = findViewById(R.id.signinProgressBarID);

        signInButton.setOnClickListener(this);
        gotoSignUpTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signinBtnID:
                userLogin();
                break;

            case R.id.gotoSignUpTVID:
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {
        String email = signInEmailEditText.getText().toString().trim();
        String password = signInPasswordEditText.getText().toString().trim();

        if (email.isEmpty()){
            signInEmailEditText.setError("Enter an email address");
            signInEmailEditText.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signInEmailEditText.setError("Enter a valid email address");
            signInEmailEditText.requestFocus();
            return;
        }

        if (password.isEmpty()){
            signInPasswordEditText.setError("Enter an email address");
            signInPasswordEditText.requestFocus();
            return;
        }
        if (password.length()<6){
            signInPasswordEditText.setError("Password should be at least 6 characters");
            signInPasswordEditText.requestFocus();
            return;
        }

        //progress bar visibility check
        signInProgressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                signInProgressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(), FirstMenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Oops! Something wrong.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}