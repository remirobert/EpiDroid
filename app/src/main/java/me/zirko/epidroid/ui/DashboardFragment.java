package me.zirko.epidroid.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.linearlistview.LinearListView;

import java.util.HashMap;
import java.util.Map;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Dashboard;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment
        implements Response.Listener<Dashboard>, Response.ErrorListener {
    private static final String TAG = DashboardFragment.class.getSimpleName();
    private static String API_ROUTE = "/infos";
    private Activity mActivity;
    private View mView;
    private String mToken;
    private HistoryAdapter mAdapter;
    private Dashboard mData;

    public DashboardFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        Log.e(TAG, "onCreate ");
        if (getArguments() != null) {
            mToken = getArguments().getString("token");
        }

        if (savedInstanceState == null) {
            fetchDashboard();
        }
    }

    private void fetchDashboard() {
        Map<String, String> params = new HashMap<>();
        params.put("token", mToken);

        VolleySingleton.getInstance(mActivity).addToRequestQueue(new GsonRequest<>(
                API_ROUTE, Dashboard.class, this, this, params));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        if (mAdapter == null) {
            mAdapter = new HistoryAdapter(mActivity);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ensureData();
    }

    private void ensureData() {
        if (mAdapter != null) {
            ((LinearListView) mView.findViewById(R.id.list)).setAdapter(mAdapter);
        }
        if (mData != null) {
            fillDashboard(mData);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mActivity = null;
    }

    @Override
    public void onResponse(Dashboard dashboard) {
        mData = dashboard;
        if (mView != null && mActivity != null) {
            fillDashboard(dashboard);
            mAdapter.addAll(dashboard.getHistory());
            ((LinearListView) mView.findViewById(R.id.list)).setAdapter(mAdapter);
        }
    }

    void fillDashboard(Dashboard dashboard) {
        ((NetworkImageView) mView.findViewById(R.id.profile_image))
                .setImageUrl("https://cdn.local.epitech.eu/userprofil/profilview/" + dashboard
                                .getInfos()
                                .getPicture().replace("bmp", "jpg"),
                        VolleySingleton.getInstance(mActivity).getImageLoader());
        ((TextView) mView.findViewById(R.id.full_name)).setText(dashboard.getInfos().getTitle());

        ((TextView) mView.findViewById(R.id.login)).setText(dashboard.getInfos().getLogin());
        ((TextView) mView.findViewById(R.id.promo)).setText(getString(R.string.promo,
                dashboard.getInfos().getPromo()));
        ((TextView) mView.findViewById(R.id.semester)).setText(getString(R.string.semester,
                dashboard.getCurrent().getSemesterCode()));
        ((TextView) mView.findViewById(R.id.city)).setText(dashboard.getInfos().getLocation());
        Float activeLog = Float.valueOf(dashboard.getCurrent().getActiveLog());
        ((TextView) mView.findViewById(R.id.active_log)).setText(String.format("%.1fh", activeLog));
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorResponse " + volleyError.getLocalizedMessage());
    }
}
