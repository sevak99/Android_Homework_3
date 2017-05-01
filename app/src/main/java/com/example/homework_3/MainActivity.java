package com.example.homework_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_1 = 3;
    public static final int REQUEST_CODE_2 = 4;

    public static final String KEY_TITLE  = "com.example.homework_3.MainActivity.title";

    private User user1;
    private User user2;

    private TextView[] layout;
    private TextView[] fullName;
    private TextView[] gender;
    private TextView[] picture;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        layout = new TextView[2];
        fullName = new TextView[2];
        gender = new TextView[2];
        picture = new TextView[2];

        layout[0] = (TextView) findViewById(R.id.layout_1);
        fullName[0] = (TextView) findViewById(R.id.layout_1_fullName);
        gender[0] = (TextView) findViewById(R.id.layout_1_gender);
        picture[0] = (TextView) findViewById(R.id.layout_1_picture);
        layout[1] = (TextView) findViewById(R.id.layout_2);
        fullName[1] = (TextView) findViewById(R.id.layout_2_fullName);
        gender[1] = (TextView) findViewById(R.id.layout_2_gender);
        picture[1] = (TextView) findViewById(R.id.layout_2_picture);

        layout[0].setOnClickListener(this);
        layout[1].setOnClickListener(this);

        user1 = new User("John", "Smith", "John", "M", 35);
        user2 = new User("Sarah", "Jonson", "Sarah", "F", 30);
        setData(0, user1);
        setData(1, user2);
    }

    private void setData(int layoutNumber, User user) {
        fullName[layoutNumber].setText(user.getFirstName() + " " + user.getLastName());
        gender[layoutNumber].setText(user.getGender());
        picture[layoutNumber].setText("This is the picture of " + user.getUserName());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layout_1:
                picture[1].setVisibility(View.GONE);
                if(picture[0].getVisibility() == View.VISIBLE) {
                    Intent intent = new Intent(this,ProfileActivity.class);
                    intent.putExtra(KEY_TITLE, user1);
                    startActivityForResult(intent, REQUEST_CODE_1);
                }
                else picture[0].setVisibility(View.VISIBLE);
                break;

            case R.id.layout_2:
                picture[0].setVisibility(View.GONE);
                if(picture[1].getVisibility() == View.VISIBLE) {
                    Intent intent = new Intent(this,ProfileActivity.class);
                    intent.putExtra(KEY_TITLE, user2);
                    startActivityForResult(intent, REQUEST_CODE_2);
                }
                else picture[1].setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_CODE_1:
                if(resultCode == RESULT_OK) {
                    user1 = (User) data.getSerializableExtra(ProfileActivity.KEY_TITLE_BACK);
                    setData(0, user1);
                }
                break;
            case REQUEST_CODE_2:
                if(resultCode == RESULT_OK) {
                    user2 = (User) data.getSerializableExtra(ProfileActivity.KEY_TITLE_BACK);
                    setData(1, user2);
                }
                break;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}