package com.example.mads.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mads.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    ImageView ImgUserPhoto;
    static int PReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickedImageUri;

    private EditText userEmail,userPassword,userPassword2,userName;
    private TextView instructions;
    private ProgressBar loadingProgress;
    private Button regBtn;

    private FirebaseAuth mAuth;
    DatabaseReference reference;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inu views
        //ImgUserPhoto = findViewById(R.id.regUserPhoto);
        instructions = findViewById(R.id.instruction);

        userEmail = findViewById(R.id.regMail);
        userPassword = findViewById(R.id.regPassword);
        userName = findViewById(R.id.regName);
        userPassword2 = findViewById(R.id.regPassword2);
        loadingProgress = findViewById(R.id.regProgressBar);
        regBtn = findViewById(R.id.regBtn);
        loadingProgress.setVisibility(View.INVISIBLE );

        mAuth = FirebaseAuth.getInstance();

regBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

regBtn.setVisibility(View.INVISIBLE);
loadingProgress.setVisibility(View.VISIBLE);
final String email = userEmail.getText().toString();
final String password = userPassword.getText().toString();
final String password2 = userPassword2.getText().toString();
final String name = userName.getText().toString();
final String inst = instructions.getText().toString();

if( email.isEmpty() || name.isEmpty() || password.isEmpty() || password2.isEmpty() || !password.equals(password2)){

    // something goes wrong .all fields must be filled
    //we need to display an error message
showMessage("please verify all fields");
regBtn.setVisibility(View.VISIBLE);
loadingProgress.setVisibility(View.INVISIBLE);

}
else
{
    //everything is okey. create user account
    //

    CreateUserAccount(email,name,password);
}



    }
});


        ImgUserPhoto = findViewById(R.id.regUserPhoto);

        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 22) {

                    checkAndRequestForPermission();

                } else {
                    openGallery();
                }


            }
        });
    }

    private void CreateUserAccount(String email, final String name, String password) {
        //this method create user account with specific email and password
         mAuth.createUserWithEmailAndPassword(email,password)
                  .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()){

                             FirebaseUser firebaseUser = mAuth.getCurrentUser();
                             String userid = firebaseUser.getUid();
                             reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);



                             HashMap<String, String> hashMap = new HashMap<>();
                             hashMap.put("id", userid);
                             hashMap.put("username", String.valueOf((name)));
                             hashMap.put("imageUrl","default");
                             hashMap.put("title", "drug_user");
                             hashMap.put("status","offline");
                             hashMap.put("description","student");

                             reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task) {
                                     if (task.isSuccessful()){
                                         //user account created successfully
                                         showMessage("Account created");
                                         //after creation of an account ,information is updated
                                         updateUserInfo(name ,pickedImageUri, mAuth.getCurrentUser());
                                     }

                                 }
                             });



                         }
                         else {
                             // account creation failed
                             showMessage("account creation failed" + task.getException().getMessage());
                             regBtn.setVisibility(View.VISIBLE);
                             loadingProgress.setVisibility(View.INVISIBLE);
                         }
                     }
                 });








    }

    private void updateUserInfo(final String name, Uri pickedImageUri ,final FirebaseUser currentUser) {
        //first we need to upload user photo to firebase storage and get uri
        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImageUri.getLastPathSegment());
        imageFilePath.putFile(pickedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess( UploadTask.TaskSnapshot taskSnapshot) {
                //image upload successfully
                //now we can get our image uri

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {


                    @Override
                    public void onSuccess(Uri uri) {
                        //uri contain user image uri
                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .setPhotoUri(uri)
                                .build();





                     currentUser.updateProfile(profileUpdate)
                             .addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task) {
                                     if (task.isSuccessful()){
                                         //user info updated successfully
                                         showMessage("Register complete");
                                         updateUI();
                                     }
                                 }
                             });

                    }
                });


            }
       });

    }


    private void updateUI() {
        Intent homeActivity = new Intent(getApplicationContext(),Home.class);
        startActivity(homeActivity);
        finish();
    }

    // simple method to show toast message
    private void showMessage(String message) {


        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

    }

    private void openGallery() {
        //TODO: open gallery intent and wait for user to pick an image

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }


   private void checkAndRequestForPermission() {

        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                Toast.makeText(RegisterActivity.this, "PLease accept for required permission", Toast.LENGTH_SHORT).show();

            }
            else
                {
                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }

        }
        else {
            openGallery();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null){
         //the user has successfully picked an image
        //
        pickedImageUri = data.getData();
        ImgUserPhoto.setImageURI(pickedImageUri);

    }

    }


}










