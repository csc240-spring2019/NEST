package edu.ncc.nest.nestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class GuestForm extends AppCompatActivity {


    //database where we will store user information
    GuestFormHelper db;

    //variables to store user information
    EditText name, email, phone, date, address, city, zip;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_form);

        //creating the database and passing the correct context as the argument
        db = new GuestFormHelper(this);

        //getting a handle on info from the UI
        name = (EditText)findViewById(R.id.editText6);
        email = (EditText)findViewById(R.id.editText);
        phone = (EditText)findViewById(R.id.editText2);
        date = (EditText)findViewById(R.id.editText6);
        address = (EditText)findViewById(R.id.editText6);
        city = (EditText)findViewById(R.id.editText6);
        zip = (EditText)findViewById(R.id.editText8);

    }


    public void onClick(View view){

        //variable used for checks
        boolean ins = false;

        //adding the values into the database if submit button is pressed
        if(view.getId() == R.id.done_button){
            ins = db.insertData(name.getText().toString(), email.getText().toString(), phone.getText().toString(), date.getText().toString(), address.getText().toString(), city.getText().toString(), zip.getText().toString());
        }

        //notifying the user if the add was successful
        if(ins){
            Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_LONG).show();
        }

    }
/** -- Crashes because of the spinner code************
 Spinner spinner = (Spinner) findViewById(R.id.states_spinner);
 // Create an ArrayAdapter using the string array and a default spinner layout
 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
 R.array.states_array, android.R.layout.simple_spinner_item);
 */
// Specify the layout to use when the list of choices appears
/*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    ...

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);*/
}
