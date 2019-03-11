package edu.ncc.nest.nestapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        //this.getWindow().setBackgroundDrawable(null);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgotPass:
                //setContentView(R.layout.activity_forgot_password);
                break;
            case R.id.scheduleBtn:
                setContentView(R.layout.activity_schedule);
                break;
            case R.id.inventoryBtn:
                setContentView(R.layout.activity_inventory);
                break;
            case R.id.guestFormBtn:
                setContentView(R.layout.activity_guest_form);
                break;
        }
    }

}
