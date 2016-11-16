package com.example.n56j.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegisterAdmin extends AppCompatActivity {

    //Explicit
    private String urlAddUserString = "http://swiftcodingthai.com/pbru/add_user_master.php";
    private EditText userEditText, passwordEditText, phoneEditText, emailEditText;
    private String userString, passwordString, phoneString, emailString;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_register_admin);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText10);
        passwordEditText = (EditText) findViewById(R.id.editText11);
        phoneEditText = (EditText) findViewById(R.id.editText15);
        emailEditText = (EditText) findViewById(R.id.editText14);
        button = (Button) findViewById(R.id.button7);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value From Edit Text
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();
                emailString = emailEditText.getText().toString().trim();

                //Check Space
                if (userString.equals("") || passwordString.equals("") ||
                        phoneString.equals("") || emailString.equals("")) {
                    //Have Space
                    MyAlert myAlert = new MyAlert(ActivityRegisterAdmin.this,
                            R.drawable.doremon48,
                            getResources().getString(R.string.title_haveSpace),
                            getResources().getString(R.string.message_haveSpace));
                    myAlert.myDialog();

                } else {

                    try {

                        //No Space
                        AddUserTABLE addUserTABLE = new AddUserTABLE(ActivityRegisterAdmin.this, 0);
                        addUserTABLE.execute(urlAddUserString,
                                userString,
                                passwordString,
                                phoneString,
                                emailString);

                        if (Boolean.parseBoolean(addUserTABLE.get())) {
                            finish();
                        } else {
                            Toast.makeText(ActivityRegisterAdmin.this,
                                    "Cannot Upload", Toast.LENGTH_SHORT).show();
                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }   // if

            }   // onClick
        });

    }   // Main Method


}   // Main Class
