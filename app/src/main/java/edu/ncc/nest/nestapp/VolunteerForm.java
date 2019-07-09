package edu.ncc.nest.nestapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VolunteerForm extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;

    EditText firstName, lastName, email, phone, address, city, zip;
    Spinner contact_form;
    CheckBox push_not;
    private Pattern pattern;
    private Matcher matcher;
    Button submit;


    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_form);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone_number);
        email = findViewById(R.id.email_address);
        city = findViewById(R.id.city);
        zip = findViewById(R.id.zip_code);
        address = findViewById(R.id.postal_address);
        contact_form = findViewById(R.id.contact_spinner);
        push_not = findViewById(R.id.push_not);
        submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                if (checkFill() == true) {
                    intent = new Intent(this, availability.class);
                    startActivity(intent);
                }

                break;

        }
    }


    public boolean checkFill() {
        Toast fix = null;
        if (firstName.getText().toString().equals("")) {
            fix.makeText(this, "Please fill out the First Name field", Toast.LENGTH_SHORT).show();
            return false;

        } else if (lastName.getText().toString().equals("")) {
            fix.makeText(this, "Please fill out the Last Name field", Toast.LENGTH_SHORT).show();
            return false;

        } else if (phone.getText().toString().equals("") || phone.getText().toString().length() != 10 || !isNumeric(phone.getText().toString())) {
            fix.makeText(this, "Please enter a proper phone number with no hyphens i.e. 5165558888", Toast.LENGTH_SHORT).show();
            return false;

        } else if (!isValid(email.getText().toString())) {
            fix.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;
    }


    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    //    public boolean properEmail(String address) {
//
//        matcher = pattern.matcher(address);
//        return matcher.matches();
//    }
//
//    public void EmailValidator() {
//        pattern = Pattern.compile(EMAIL_PATTERN);
//    }
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


}
