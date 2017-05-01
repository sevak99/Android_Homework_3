package com.example.homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_TITLE  = "com.example.homework_3.ProfileActivity.title";
    public static final String KEY_TITLE_BACK  = "com.example.homework_3.ProfileActivity.title.back";

    public static final int REQUEST_CODE = 5;

    private TextView userName;
    private TextView firstName;
    private TextView lastName;
    private TextView gender;
    private TextView age;
    private TextView bio;

    private Button edit;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = (TextView) findViewById(R.id.profile_userName);
        firstName = (TextView) findViewById(R.id.profile_firstName);
        lastName = (TextView) findViewById(R.id.profile_lastName);
        gender = (TextView) findViewById(R.id.profile_gender);
        age = (TextView) findViewById(R.id.profile_age);
        bio = (TextView) findViewById(R.id.profile_bio);
        edit = (Button) findViewById(R.id.btn_edit_profile);
        if(edit == null) Log.d("testt", "edit_wrong");

        user = (User) getIntent().getSerializableExtra(MainActivity.KEY_TITLE);

        userName.setText("User Name: " + user.getUserName());
        firstName.setText("First Name: " + user.getFirstName());
        lastName.setText("Last Name: " + user.getLastName());
        gender.setText("Gender: " + user.getGender());
        age.setText("Age: " + user.getAge());
        bio.setText("Bio: " + user.getBio());

        edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit_profile:

                Intent intent = new Intent(this, EditProfileActivity.class);
                intent.putExtra(KEY_TITLE, user);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {

                user = (User) data.getSerializableExtra(EditProfileActivity.KEY_TITLE);

                userName.setText("User Name: " + user.getUserName());
                firstName.setText("First Name: " + user.getFirstName());
                lastName.setText("Last Name: " + user.getLastName());
                gender.setText("Gender: " + user.getGender());
                age.setText("Age: " + user.getAge());
                bio.setText("Bio: " + user.getBio());
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(KEY_TITLE_BACK, user);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
