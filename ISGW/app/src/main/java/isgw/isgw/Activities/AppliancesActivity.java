package isgw.isgw.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import isgw.isgw.R;

public class AppliancesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        getSupportActionBar().hide();
    }
}