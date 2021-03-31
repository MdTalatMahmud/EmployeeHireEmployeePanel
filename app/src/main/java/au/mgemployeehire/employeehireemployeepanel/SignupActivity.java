package au.mgemployeehire.employeehireemployeepanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText signUpEmailEditText, signUpPasswordEditText, signUpUserNameEditText;
    private TextView gotoSignInTextView;
    private Button signUpButton;
    private ProgressBar progressBarSignUp;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        //finding id
        signUpUserNameEditText = findViewById(R.id.signupUserNameID);
        signUpEmailEditText = findViewById(R.id.signupEmailID);
        signUpPasswordEditText = findViewById(R.id.signupPasswordID);

        gotoSignInTextView = findViewById(R.id.gotoSignInTVID);
        signUpButton = findViewById(R.id.signupBtnID);
        progressBarSignUp = findViewById(R.id.signinProgressBarID);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        //signUpButton.setOnClickListener(this);
        gotoSignInTextView.setOnClickListener(this);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_username = signUpUserNameEditText.getText().toString();
                String txt_email = signUpEmailEditText.getText().toString();
                String txt_password = signUpPasswordEditText.getText().toString();

                //progress bar visibility check
                progressBarSignUp.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(SignupActivity.this,"Fill all required fields", Toast.LENGTH_LONG).show();
                }else if (txt_password.length() < 6){
                    Toast.makeText(SignupActivity.this,"Password should be at least 6 characters", Toast.LENGTH_LONG).show();
                }else {
                    register(txt_username, txt_email, txt_password);
                }
            }
        });

    }

    //register user
    private void register(String username, String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            String userid = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("ChatUser").child(userid);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id",userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL","default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(SignupActivity.this, FirstMenuActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                        //progressBar gone
                                        progressBarSignUp.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else {
                            Toast.makeText(SignupActivity.this,"Error! May be you have entered already registered email ID", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.signupBtnID:
//                userRegister();
//                break;

            case R.id.gotoSignInTVID:
                Intent intent = new Intent(getApplicationContext(),SigninActivity.class);
                startActivity(intent);
                break;
        }

    }

//    private void userRegister() {
//        String email = signUpEmailEditText.getText().toString().trim();
//        String password = signUpPasswordEditText.getText().toString().trim();
//
//        if (email.isEmpty()){
//            signUpEmailEditText.setError("Enter an email address");
//            signUpEmailEditText.requestFocus();
//            return;
//        }
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            signUpEmailEditText.setError("Enter a valid email address");
//            signUpEmailEditText.requestFocus();
//            return;
//        }
//
//        if (password.isEmpty()){
//            signUpPasswordEditText.setError("Enter an email address");
//            signUpPasswordEditText.requestFocus();
//            return;
//        }
//        if (password.length()<6){
//            signUpPasswordEditText.setError("Password should be at least 6 characters");
//            signUpPasswordEditText.requestFocus();
//            return;
//        }
//        //showing progress bar
//        progressBarSignUp.setVisibility(View.VISIBLE);
//
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                progressBarSignUp.setVisibility(View.GONE);
//                if (task.isSuccessful()) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Toast.makeText(getApplicationContext(), "Register Successful",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(SignupActivity.this, FirstMenuActivity.class);
//                    startActivity(intent);
//                } else {
//                    // If sign in fails, display a message to the user.
//                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
//                        Toast.makeText(getApplicationContext(), "User email already registered",Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "Oops! Something wrong. Please, try again later",Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            }
//        });
//
//    }


}