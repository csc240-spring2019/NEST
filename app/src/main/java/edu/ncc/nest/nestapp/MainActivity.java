package edu.ncc.nest.nestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setBackgroundDrawableResource(R.drawable.veg_table);
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
}
