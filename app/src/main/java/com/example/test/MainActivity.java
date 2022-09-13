package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText firstname, lastname, emailadress, password;
    RadioGroup gender;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        enter.setOnClickListener(this);
    }


    public void init() {
        firstname = findViewById(R.id.editTextFirstName);
        lastname = findViewById(R.id.editTextLastName);
        emailadress = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        gender = findViewById(R.id.radioGroupGender);
        enter = findViewById(R.id.buttonEnter);


    }

    @Override
    public void onClick(View view) {
        if (check()) {
            Toast.makeText(this, "You successfully entered", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean check() {
        boolean itsOK = true;
        if (firstname.getText().toString().trim().isEmpty()
                || lastname.getText().toString().trim().isEmpty()
                || emailadress.getText().toString().trim().isEmpty()
                || password.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "please fill the empty parts", Toast.LENGTH_LONG).show();
            itsOK = false;
        } else {
            if (firstname.getText().toString().trim().length() < 2) {
                Toast.makeText(this, "first name character is not valid", Toast.LENGTH_LONG).show();
                itsOK = false;
            }
            if (lastname.getText().toString().trim().length() < 2) {
                Toast.makeText(this, "last name character is not valid", Toast.LENGTH_LONG).show();
                itsOK = false;
            }
            if (emailadress.getText().toString().trim().length() < 12) {
                Toast.makeText(this, "email address is not valid", Toast.LENGTH_LONG).show();
                itsOK = false;
            } else {
                if (!emailadress.getText().toString().contains("@")) {
                    Toast.makeText(this, "the email address is not valid", Toast.LENGTH_SHORT).show();
                    itsOK = false;
                }
            }
        }
        return itsOK;
    }
}