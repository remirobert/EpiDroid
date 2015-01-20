package me.zirko.epidroid.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;
import com.linearlistview.LinearListView;

import org.w3c.dom.Text;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Dashboard;
import me.zirko.epidroid.model.History;
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
    private HistoryAdapter mHistoryAdapter;

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

        mToken = getArguments().getString("token");

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
        return mView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onResponse(Dashboard dashboard) {
        if (isAdded()) {
            ((NetworkImageView) mView.findViewById(R.id.profile_image))
                    .setImageUrl("https://cdn.local.epitech.eu/userprofil/" + dashboard.getInfos()
                                    .getPicture(),
                            VolleySingleton.getInstance(mActivity).getImageLoader());
            ((TextView) mView.findViewById(R.id.full_name)).setText(dashboard.getInfos().getTitle
                    ());

            ((TextView) mView.findViewById(R.id.login)).setText(dashboard.getInfos().getLogin());
            ((TextView) mView.findViewById(R.id.promo)).setText(getString(R.string.promo,
                    dashboard.getInfos().getPromo()));
            ((TextView) mView.findViewById(R.id.semester)).setText(getString(R.string.semester,
                    dashboard.getCurrent().getSemesterCode()));
            ((TextView) mView.findViewById(R.id.city)).setText(dashboard.getInfos().getLocation());
            Float activeLog = Float.valueOf(dashboard.getCurrent().getActiveLog());
            ((TextView) mView.findViewById(R.id.active_log)).setText(String.format("%.1fh",
                    activeLog));

            mHistoryAdapter = new HistoryAdapter(mActivity, dashboard.getHistory());
            ((LinearListView) mView.findViewById(R.id.list)).setAdapter(mHistoryAdapter);
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorResponse " + volleyError.getLocalizedMessage());
    }
}
