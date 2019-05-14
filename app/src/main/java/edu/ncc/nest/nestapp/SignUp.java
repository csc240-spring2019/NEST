package edu.ncc.nest.nestapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.sign_up_button:
                //if the user presses the 'Sign Up' button, the email they entered should be checked to see if it is a valid email address
                //phone number should be checked to see if its a valid number

                //assuming everything is valid, account needs to be created, dialog needs to explain account preferences for contact information
                //and notifications

                //so, if valid account creation:
                validSignUpDialog(true);
                break;

                //if invalid account creation, do validSignUpDialog(false);


        }
    }

    //implements the menu options for the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.homeBtn){
            home();
        }

        if(item.getItemId() == R.id.accountManagementBtn){
            accountManagement();
        }

        return super.onOptionsItemSelected(item);
    }

    public void validSignUpDialog(Boolean validSignUp){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SignUp.this);
        alertBuilder.setCancelable(false);

        if(validSignUp){

            alertBuilder.setMessage("NEST account created. You can manage your account credentials and notification preferences in " +
                    "the overflow menu on the app bar.");
            alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //launch signUp activity
                    home();
                }
            });

        }

        else{

            alertBuilder.setMessage("Invalid email/phone number.");
            alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

        }

        AlertDialog alert = alertBuilder.create();

        alert.show();
    }

    /**
     * home method - goes to the home screen
     */
    public void home(){
        Intent intent = new Intent(this, Choose.class);
        startActivity(intent);
        finish();
    }

    /**
     * accountManagement method - goes to SignIn activity, to manage account preferences
     */
    public void accountManagement(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
