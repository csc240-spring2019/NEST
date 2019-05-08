package edu.ncc.nest.nestapp;


import android.content.DialogInterface;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;

public class Choose extends AppCompatActivity implements OnClickListener {
    private Intent intent;
    private Button schedule;
    private Button inventory;
    private Button guest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this.getWindow().setBackgroundDrawable(null);
    }

    //implements the menu options for the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }



    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inventoryBtn:
                launchInventory();
                break;
            case R.id.scheduleBtn:
                launchSchedule();
                break;
            case R.id.guestFormBtn:
                launchGuestForm();
                break;
            case R.id.signUpBtn:
                createAccountDialog();
                break;
        }
    }

    /**
     * createAccountDialog method - this method creates an alert dialog when the 'Create Nest Account' button is clicked. An alert dialog
     * will be displayed telling the user what creating an account entails, and will ask them if they want to create an account or not.
     * If they select 'Yes' they will be directed to the SignUp activity. If they select 'No' the dialog will close.
     */
    public void createAccountDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Choose.this);
        alertBuilder.setCancelable(false);
        alertBuilder.setMessage("Creating a NEST account will allow you to receive notifications relating to guest, donator, or volunteer " +
                "opportunities. You will be allowed to manage your notification preferences once your account is created. Your name, email " +
                "address, and phone number will be required." + "\n" + "Create an account?");
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //launch signUp activity
                launchSignUp();
            }
        });

        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertBuilder.create();

        alert.show();
    }

    /**
     * launchInventory - starts the Inventory activity
     */
    public void launchInventory(){
        Intent intent = new Intent(this, Inventory.class);
        startActivity(intent);
    }

    /**
     * launchSchedule - starts the Schedule activity
     */
    public void launchSchedule(){
        Intent intent = new Intent(this, Schedule.class);
        startActivity(intent);
    }

    /**
     * launchGuestForm - starts the GuestForm activity
     */
    public void launchGuestForm(){
        Intent intent = new Intent(this, GuestForm.class);
        startActivity(intent);
    }

    /**
     * launchSignUp - starts the SignUp activity
     */
    public void launchSignUp(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }


}


