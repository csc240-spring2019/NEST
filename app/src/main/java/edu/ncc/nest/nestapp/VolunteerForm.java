package edu.ncc.nest.nestapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class VolunteerForm extends AppCompatActivity {

    EditText firstName, lastName, email, phone, address, city, zip;
    Spinner contact_form;
    CheckBox push_not;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_form);
        this.getWindow().setBackgroundDrawableResource(R.drawable.veg_table);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone_number);
        email = findViewById(R.id.email_address);
        city = findViewById(R.id.city);
        zip = findViewById(R.id.zip_code);
        address = findViewById(R.id.postal_address);
        contact_form = findViewById(R.id.contact_spinner);
        push_not = findViewById(R.id.push_not);
    }


    public void checkFill() {
        Toast fix = null;
        if (firstName.getText().equals("")) {
            fix.makeText(this, "Please fill out the First Name field", Toast.LENGTH_SHORT).show();

        } else if (lastName.getText().equals("")) {
            fix.makeText(this, "Please fill out the Last Name field", Toast.LENGTH_SHORT).show();

        } else if (!isnum(phone.getText())) {
            fix.makeText(this, "Please enter a proper phone number with no hyphens i.e. 5165558888", Toast.LENGTH_SHORT).show();

        } else if (!properEmail(email.getText())) {
            fix.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();

        }
    }

    public boolean isnum(Editable num) {
        boolean decision = false;
        for (int i = 0; i < 7; i++) {
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
                decision = true;
            else {
                decision = false;
                return decision;
            }

        }


        return decision;
    }

    public boolean properEmail(Editable address) {

        int end = address.length() - 4;
        String com = address.toString().substring(end);

        if (!address.toString().contains("@"))
            return false;


        if (com != ".com")
            return false;


        return true;
    }



}
