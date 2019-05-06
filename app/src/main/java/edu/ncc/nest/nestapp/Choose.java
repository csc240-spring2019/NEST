package edu.ncc.nest.nestapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

        Button schedule = findViewById(R.id.scheduleBtn);
        Button inventory = findViewById(R.id.inventoryBtn);
        Button guest = findViewById(R.id.guestFormBtn);


        schedule.setOnClickListener(this);
        inventory.setOnClickListener(this);
        guest.setOnClickListener(this);


        this.getWindow().setBackgroundDrawableResource(R.drawable.veg_table);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scheduleBtn:
                intent = new Intent(this, Schedule.class);
                startActivity(intent);
                break;
            case R.id.inventoryBtn:
                intent = new Intent(this, Inventory.class);
                startActivity(intent);
                break;
            case R.id.guestFormBtn:
                intent = new Intent(this, GuestForm.class);
                startActivity(intent);
                break;
            case R.id.volunteerFormBtn:
                intent = new Intent(this, VolunteerForm.class);
                startActivity(intent);
                break;
        }
    }

}


