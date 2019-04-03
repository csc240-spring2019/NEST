package edu.ncc.nest.nestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Inventory extends AppCompatActivity {

    @Override
    /**
     * onCreate method -
     * loads the 'activity_inventory layout' which has only a TextView as a placeholder for now
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }
}
