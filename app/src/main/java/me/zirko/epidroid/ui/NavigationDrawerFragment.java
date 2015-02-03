package me.zirko.epidroid.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.NetworkImageView;
import com.linearlistview.LinearListView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import me.zirko.epidroid.R;
import me.zirko.epidroid.event.DashboardEvent;
import me.zirko.epidroid.model.Dashboard;
import me.zirko.epidroid.model.Infos;
import me.zirko.epidroid.model.Photo;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;


/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer
 * .html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
public class NavigationDrawerFragment extends Fragment implements Response.Listener<Photo>,
                                                                  Response.ErrorListener {
    /**
     * Remember the position of the selected item.
     */
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static String API_ROUTE = "/photo";
    /**
     * A pointer to the current callbacks instance (the Activity).
     */
    private NavigationDrawerCallbacks mCallbacks;

    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private LinearListView mDrawerListView;
    private View mFragmentContainerView;

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
    private String mNotification = "0";
    private NavigationDrawerAdapter mAdapter;
    private List<FragmentNavItem> mDrawerNavItems = new ArrayList<>();
    private String mUserUuid;
    private Activity mActivity;
    private String mToken;
    private Infos mData;

    public NavigationDrawerFragment() {
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                toolbar,
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

    public void addNavItem(@DrawableRes int iconRes, String navTitle, String windowTitle,
                           Class<? extends Fragment> fragmentClass) {
        addNavItem(iconRes, navTitle, windowTitle, fragmentClass, null);
    }

    public void addNavItem(@DrawableRes int iconRes, String navTitle, String windowTitle,
                           Class<? extends Fragment> fragmentClass, Bundle args) {
        mAdapter.add(iconRes, navTitle);
        mDrawerNavItems.add(new FragmentNavItem(windowTitle, fragmentClass, args));
    }

    public void addNavItem(@StringRes int navTitle, @StringRes int windowTitle,
                           Class<? extends Fragment> fragmentClass, Bundle args) {
        addNavItem(0, getString(navTitle), getString(windowTitle), fragmentClass, args);
    }

    public void addNavItem(@DrawableRes int iconRes, @StringRes int navTitle,
                           @StringRes int windowTitle,
                           Class<? extends Fragment> fragmentClass, Bundle args) {
        addNavItem(iconRes, getString(navTitle), getString(windowTitle), fragmentClass, args);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
            mActivity = activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        EventBus.getDefault().register(this);
        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }
    }

    private void fetchProfilePhoto(String token, String login) {
        VolleySingleton.getInstance(mActivity).addToRequestQueue(new GsonRequest<>(
                API_ROUTE + "?token=" + token + "&login=" + login, Photo.class, this, this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navdrawer, container, false);

        mDrawerListView = (LinearListView) view.findViewById(R.id.navdrawer_items);
        mDrawerListView.setOnItemClickListener(new LinearListView.OnItemClickListener() {
            @Override
            public void onItemClick(LinearListView parent, View view, int position, long id) {
                selectItem(position);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new NavigationDrawerAdapter(getActionBar().getThemedContext());

        addNavItem(R.drawable.ic_drawer_dashboard, R.string.navdrawer_item_dashboard,
                R.string.navdrawer_item_dashboard, DashboardFragment.class);

        addNavItem(R.drawable.ic_drawer_schedule, R.string.navdrawer_item_schedule,
                R.string.navdrawer_item_schedule, ScheduleFragment.class);

        addNavItem(R.drawable.ic_drawer_modules, R.string.navdrawer_item_marks,
                R.string.navdrawer_item_marks, MarkFragment.class);

        addNavItem(R.drawable.ic_module, R.string.navdrawer_item_modules,
                R.string.navdrawer_item_modules, ModuleFragment.class);

        addNavItem(R.drawable.ic_drawer_projects, R.string.navdrawer_item_projects,
                R.string.navdrawer_item_projects, ProjectsFragment.class);

        addNavItem(R.drawable.ic_drawer_group_photos, R.string.navdrawer_item_group_photos,
                R.string.navdrawer_item_group_photos, DashboardFragment.class);

        addNavItem(R.drawable.ic_logout, R.string.navdrawer_item_logout,
                R.string.navdrawer_item_logout, LogoutFragment.class);

        mDrawerListView.setAdapter(mAdapter);
//        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        if (savedInstanceState == null) {
            selectItem(mCurrentSelectedPosition);
        }
    }

    public void addNavItem(@DrawableRes int iconRes, @StringRes int navTitle,
                           @StringRes int windowTitle,
                           Class<? extends Fragment> fragmentClass) {
        addNavItem(iconRes, getString(navTitle), getString(windowTitle), fragmentClass, null);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
        mActivity = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (mDrawerLayout != null && isDrawerOpen()) {
            inflater.inflate(R.menu.global, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(DashboardEvent event) {
        mData = event.getData().getInfos();
        mToken = event.getToken();
        ensureData();
    }

    public void ensureData() {
        if (mData != null) {
            ((TextView) getView().findViewById(R.id.profile_name_text)).setText(mData.getTitle());
            ((TextView) getView().findViewById(R.id.profile_email_text)).setText(mData.getInternalEmail());

            fetchProfilePhoto(mToken, mData.getLogin());
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ensureData();
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     */
    private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
//        if (mDrawerListView != null) {
//            mDrawerListView.setItemChecked(position, true);
//        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            if (mDrawerNavItems.size() > 0) {
                FragmentNavItem navItem = mDrawerNavItems.get(position);
                Fragment fragment = null;

                try {
                    fragment = navItem.getFragmentClass().newInstance();
                    Bundle args = navItem.getFragmentArgs();
                    if (args != null) {
                        fragment.setArguments(args);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mCallbacks.onNavigationDrawerItemSelected(navItem.getTitle(), fragment);
            }
        }
    }

    @Override
    public void onResponse(Photo photo) {
        ((NetworkImageView) getView().findViewById(R.id.profile_image)).setImageUrl(
                photo.getUrl(), VolleySingleton.getInstance(mActivity).getImageLoader());
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {

    }

    /**
     * Callbacks interface that all activities using this fragment must implement.
     */
    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(String title, Fragment fragment);
    }

    private class FragmentNavItem {
        private Class<? extends Fragment> fragmentClass;
        private String title;
        private Bundle fragmentArgs;

        public FragmentNavItem(String title, Class<? extends Fragment> fragmentClass) {
            this(title, fragmentClass, null);
        }

        public FragmentNavItem(String title, Class<? extends Fragment> fragmentClass, Bundle args) {
            this.fragmentClass = fragmentClass;
            this.fragmentArgs = args;
            this.title = title;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public String getTitle() {
            return title;
        }

        public Bundle getFragmentArgs() {
            return fragmentArgs;
        }
    }
}
