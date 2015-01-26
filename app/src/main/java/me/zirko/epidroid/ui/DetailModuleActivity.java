package me.zirko.epidroid.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import me.zirko.epidroid.R;

public class DetailModuleActivity extends ActionBarActivity {

    private static final String TAG = DetailModuleActivity.class.getSimpleName();
    private Toolbar mToolbar;

    public DetailModuleActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.theme_primary_dark));
        }

        setContentView(R.layout.activity_detail_module);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Intent intent = getIntent();

            Fragment fragment = new DetailModuleFragment();
            if (intent != null) {
                fragment.setArguments(intent.getExtras());
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        Log.e(TAG, "setTitle called");
        if (mToolbar != null) {
            Log.e(TAG, "title set !");
            getSupportActionBar().setTitle(title);
        }
    }
}
