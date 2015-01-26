package me.zirko.epidroid.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.zirko.epidroid.model.Schedule;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends ListFragment
        implements Response.Listener<Schedule[]>, Response.ErrorListener {
    private static final String TAG = ScheduleFragment.class.getSimpleName();
    private static String API_ROUTE = "/planning";
    private Activity mActivity;
    private String mToken;
    private ScheduleAdapter mAdapter;

    public ScheduleFragment() {
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
            fetchSchedule();
        }
    }

    private void fetchSchedule() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        String date = df.format(new Date());

        date = "2015-02-11";
        String url = API_ROUTE + "?start=" + date + "&end=" + date + "&token=" + mToken;

        VolleySingleton.getInstance(mActivity).addToRequestQueue(new GsonRequest<>(
                url, Schedule[].class, this, this));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAdapter = new ScheduleAdapter(mActivity);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDividerHeight(0);
    }

    @Override
    public void onResponse(Schedule[] schedule) {
        List<Schedule> eventList = new ArrayList<>();


        for (Schedule event : schedule) {
            if (event.getPast() != null && !event.getPast()
                    && "registered".equals(event.getEventRegistered())) {
                eventList.add(event);
            }
        }

        mAdapter.addAll(eventList);

        if (getListAdapter() == null) {
            setListAdapter(mAdapter);
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorResponse " + volleyError.getLocalizedMessage());
    }
}
