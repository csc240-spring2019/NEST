package edu.ncc.nest.nestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.drawable.veg_table);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgotPass:
//                intent = new Intent(this, .class);
//                startActivity(intent);
                break;
            case R.id.signUp:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.log_in_button:
                intent = new Intent(this, Choose.class);
                startActivity(intent);
                break;
        }
    }
}
