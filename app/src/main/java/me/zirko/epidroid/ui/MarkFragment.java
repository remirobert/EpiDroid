package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.ListModuleItem;
import me.zirko.epidroid.model.Marks;
import me.zirko.epidroid.model.ModuleList;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class MarkFragment extends Fragment implements Response.Listener<Marks>, Response.ErrorListener{

    private String mToken;
    private static final String TAG = ModuleFragment.class.getSimpleName();
    private ArrayAdapter mAdapter;
    private static String API_ROUTE = "/marks";

    public MarkFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mToken = getArguments().getString("token");
        }
        Log.i(TAG, "create fragments");
        fetchMarks();
    }

    public void fetchMarks() {
        String url = API_ROUTE + "?token=" + mToken;

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, Marks.class, this, this));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_marks, container, false);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "error request : " + volleyError.toString());
    }

    @Override
    public void onResponse(final Marks marks) {
        Log.i(TAG, "debug + " + marks);
    }
}
