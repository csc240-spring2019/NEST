package edu.ncc.nest.nestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getWindow().setBackgroundDrawableResource(R.drawable.veg_table);
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgotPass:
                //setContentView(R.layout.activity_forgot_password);
                break;
            case R.id.signUp:
                setContentView(R.layout.activity_sign_up);
                break;
            case R.id.log_in_button:
                setContentView(R.layout.activity_choose);
                break;
        }
    }

    /**
     * home method - goes to the home screen
     */
    public void home(){
        Intent intent = new Intent(this, Choose.class);
        startActivity(intent);
    }

    /**
     * accountManagement method - goes to SignIn activity, to manage account preferences
     */
    public void accountManagement(){
        Intent intent = new Intent(this, AccountManagement.class);
        startActivity(intent);
    }
}
