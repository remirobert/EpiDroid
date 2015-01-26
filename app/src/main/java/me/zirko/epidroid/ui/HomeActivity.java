package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import me.zirko.epidroid.R;

public class HomeActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static final String TAG = HomeActivity.class.getSimpleName();
    private static final String STATE_TOOLBAR_TITLE = "state:toolbar:title";
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private CharSequence mGlobalTitle;
    private String mToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mToken = getIntent().getStringExtra("token");
        if (savedInstanceState != null) {
            mTitle = savedInstanceState.getCharSequence(STATE_TOOLBAR_TITLE);
        } else {
            mGlobalTitle = mTitle = getTitle();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.theme_primary_dark));
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navdrawer_fragment);
        setSupportActionBar(toolbar);
        mNavigationDrawerFragment.setUp(R.id.navdrawer, drawerLayout, toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.menu_home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(STATE_TOOLBAR_TITLE, mTitle);
    }

    @Override
    public void onNavigationDrawerItemSelected(String title, Fragment fragment) {
        mTitle = title;
        if (fragment != null) {
            Bundle args = new Bundle();
            args.putString("token", mToken);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
}
