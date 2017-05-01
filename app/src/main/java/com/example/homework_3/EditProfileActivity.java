package com.example.homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_TITLE  = "com.example.homework_3.EditProfileActivity.title";

    private EditText userName;
    private EditText firstName;
    private EditText lastName;
    private EditText gender;
    private EditText age;
    private EditText bio;

    private Button save;
    private Button cancel;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Log.d("testt", "edit_profile_1");

        userName = (EditText) findViewById(R.id.edit_profile_userName);
        firstName = (EditText) findViewById(R.id.edit_profile_firstName);
        lastName = (EditText) findViewById(R.id.edit_profile_lastName);
        gender = (EditText) findViewById(R.id.edit_profile_gender);
        age = (EditText) findViewById(R.id.edit_profile_age);
        bio = (EditText) findViewById(R.id.edit_profile_bio);

        save = (Button) findViewById(R.id.edit_profile_save);
        save.setOnClickListener(this);
        cancel = (Button) findViewById(R.id.edit_profile_cancel);
        cancel.setOnClickListener(this);

        user = (User) getIntent().getSerializableExtra(ProfileActivity.KEY_TITLE);

        userName.setText(user.getUserName());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
        gender.setText(user.getGender());
        age.setText("" + user.getAge());
        bio.setText(user.getBio());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.edit_profile_save:
                if (wrongData() == false) {
                    Intent intent = new Intent();
                    intent.putExtra(KEY_TITLE, user);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
            case R.id.edit_profile_cancel:
                finish();
                break;
        }
    }

    private boolean wrongData() {
        if(userName.getText().length() == 0 ||
                firstName.getText().length() == 0 ||
                lastName.getText().length() == 0 ||
                gender.getText().length() == 0 ||
                age.getText().length() == 0) {
            Toast.makeText(this, "Wrong data", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(userName.getText().length() < 3 ||
                firstName.getText().length() < 3 ||
                lastName.getText().length() < 3) {
            Toast.makeText(this, "First name, last name and username must be at least 3 characters long", Toast.LENGTH_SHORT).show();
            return true;
        }

        saveUser();
        return false;
    }

    private void saveUser() {
        user.setUserName(userName.getText().toString());
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setGender(gender.getText().toString());
        user.setAge(Integer.parseInt(age.getText().toString()));
        user.setBio(bio.getText().toString());
    }
}
