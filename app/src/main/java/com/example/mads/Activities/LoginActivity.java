package com.example.mads.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mads.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText userMail,userPassword;
    private Button btnLogin;
    private ProgressBar loginProgress;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;
    private Button loginPhoto;
    private TextView textView;
    private TextView ab;
    private Intent MentorActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView)findViewById(R.id.welcome_text);
        ab = (TextView) findViewById(R.id.about_text);
        userMail = findViewById(R.id.login_mail);
        userPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.loginBtn);
        loginProgress = findViewById(R.id.login_progress);
        mAuth = FirebaseAuth.getInstance();
       HomeActivity = new Intent(this,com.example.mads.Activities.Home.class);
       // MentorActivity = new Intent(this,com.example.mads.Activities.MentorActivity.class);
        loginPhoto = findViewById(R.id.login_photo);

        loginPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent slideActivity = new Intent(getApplicationContext(),SlideActivity.class);
                startActivity(slideActivity);
                finish();
            }
        });

        loginProgress.setVisibility(View.INVISIBLE);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    loginProgress.setVisibility(View.VISIBLE);
                    btnLogin.setVisibility(View.INVISIBLE);

                    final String mail = userMail.getText().toString();
                    final String password = userPassword.getText().toString();

                    if (mail.isEmpty() || password.isEmpty()) {
                        showMessage("Please verify all fields");



                    }
                    else {
                        signIn(mail,password);
                    }
            }
        });



    }

    private void signIn(String mail, String password) {
mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {

        if(task.isSuccessful()){
            loginProgress.setVisibility(View.INVISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
            updateUI();
        }
        else {

            showMessage(task.getException().getMessage());
            btnLogin.setVisibility(View.VISIBLE);
            loginProgress.setVisibility(View.INVISIBLE);
        }
    }
});



    }

    private void updateUI() {
    startActivity(HomeActivity);
    finish();

    }

    private void showMessage(String text) {

        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null){
            //user is already connected so we need to redirect him to homepage
            updateUI();
        }

    }
}
