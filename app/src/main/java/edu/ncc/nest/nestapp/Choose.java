package edu.ncc.nest.nestapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

public class Choose extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        findViewById(R.id.scheduleBtn).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.inventoryBtn).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.guestFormBtn).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.volunteerFormBtn).setOnClickListener((View.OnClickListener) this);

        //this.getWindow().setBackgroundDrawable(null);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scheduleBtn:
                setContentView(R.layout.activity_schedule);
                intent = new Intent(Choose.this, Schedule.class);
                startActivity(intent);
                break;
            case R.id.inventoryBtn:
                setContentView(R.layout.activity_inventory);
                intent = new Intent(Choose.this, Inventory.class);
                startActivity(intent);
                break;
            case R.id.guestFormBtn:
                setContentView(R.layout.activity_guest_form);
                intent = new Intent(Choose.this, GuestForm.class);
                startActivity(intent);
                break;
            case R.id.volunteerFormBtn:
                setContentView(R.layout.activity_volunteer_form);
                intent = new Intent(Choose.this, VolunteerForm.class);
                startActivity(intent);
                break;
        }
    }

}
