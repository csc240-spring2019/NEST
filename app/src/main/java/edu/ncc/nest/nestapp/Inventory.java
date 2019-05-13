package edu.ncc.nest.nestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    /**
     * onClick method -
     * launches the FoodPantryLifeActivity Activity
     * @param view
     */
    public void onClick(View view) {
        Intent intent = new Intent(this, FoodPantryLifeActivity.class);
        startActivity(intent);
        finish();
    }
}
