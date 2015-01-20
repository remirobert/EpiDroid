package me.zirko.epidroid.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import me.zirko.epidroid.R;

public class DetailModuleActivity extends ActionBarActivity {

    public DetailModuleActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();

        if (savedInstanceState == null) {
            DetailModuleFragment detailModuleFragment = new DetailModuleFragment();
            detailModuleFragment.setArguments(intent.getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, detailModuleFragment)
                    .commit();
        }
    }

}
