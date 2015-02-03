package me.zirko.epidroid.ui;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.zirko.epidroid.R;
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
    private static String TOKEN_API_ROUTE = "/token";
    private Activity mActivity;
    private String mToken;
    private ScheduleAdapter mAdapter;
    private Schedule[] scheduleList;

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

        String date = df.format(new Date(System.currentTimeMillis() - (48 * 60 * 60 * 1000)));
        String now = df.format(new Date());

        String url = API_ROUTE + "?start=" + date + "&end=" + now + "&token=" + mToken;

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
        setEmptyText("Vous n'êtes inscrit à aucune activité");

        getListView().setDividerHeight(0);
    }

    @Override
    public void onResponse(Schedule[] schedule) {
        List<Schedule> eventList = new ArrayList<>();

        scheduleList = schedule;
        for (Schedule event : schedule) {
            if (((event.getPast() != null && !event.getPast()) ||
                    (event.getAllowToken() != null && event.getAllowToken()))
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
    public void onListItemClick(ListView l, View v, final int position, long id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Token");
        //alert.setMessage("Message");

// Set an EditText view to get user input
        final EditText input = new EditText(getActivity());
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Schedule currentSchedule = scheduleList[position];

                /*
                 PARAMS REQUEST POST
                  */

                //Map<String, String> params = new HashMap<String, String>();
                //params.put("token", mToken);
                //params.put("scolaryear", currentSchedule.getScolaryear());
                //params.put("codemodule", currentSchedule.getCodemodule());
                //params.put("codeinstance", currentSchedule.getCodeinstance());
                //params.put("codeacti", currentSchedule.getCodeacti());
                //params.put("codeevent", currentSchedule.getCodeevent());
                //params.put("tokenvalidationcode", input.getText().toString());

                // PREPARING REQUEST :
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://epitech-api.herokuapp.com" + TOKEN_API_ROUTE);

                try {
                    // Add your data
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                    nameValuePairs.add(new BasicNameValuePair("token", mToken));
                    nameValuePairs.add(new BasicNameValuePair("scolaryear", currentSchedule.getScolaryear()));
                    nameValuePairs.add(new BasicNameValuePair("codemodule", currentSchedule.getCodemodule()));
                    nameValuePairs.add(new BasicNameValuePair("codeinstance", currentSchedule.getCodeinstance()));
                    nameValuePairs.add(new BasicNameValuePair("codeacti", currentSchedule.getCodeacti()));
                    nameValuePairs.add(new BasicNameValuePair("codeevent", currentSchedule.getCodeevent()));
                    nameValuePairs.add(new BasicNameValuePair("tokenvalidationcode", input.getText().toString()));

                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    // Execute HTTP Post Request
                    HttpResponse response = httpclient.execute(httppost);
                    Log.i(TAG, "cher : " + response);
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                }


            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorResponse " + volleyError.getLocalizedMessage());
    }
}
