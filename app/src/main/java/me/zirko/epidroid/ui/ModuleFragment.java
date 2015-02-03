package me.zirko.epidroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.ListModuleItem;
import me.zirko.epidroid.model.ModuleList;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class ModuleFragment extends ListFragment
        implements Response.Listener<ModuleList>, Response.ErrorListener {

    private static final String TAG = ModuleFragment.class.getSimpleName();
    private static String API_ROUTE = "/modules";

    private String mToken;
    private ArrayAdapter<ListModuleItem> mAdapter;

    public ModuleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (getArguments() != null) {
            mToken = getArguments().getString("token");
        }

        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        if (savedInstanceState == null) {
            fetchModules();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setEmptyText("Vous n'avez pas de modules");
    }

    public void fetchModules() {
        String url = API_ROUTE + "?token=" + mToken;

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, ModuleList.class, this, this));
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "error request : " + volleyError.toString());
    }

    @Override
    public void onResponse(final ModuleList module) {
        Collections.reverse(module.getModules());
        mAdapter.addAll(module.getModules());

        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ListModuleItem currentModule = mAdapter.getItem(position);

        Intent intent = new Intent(getActivity(), DetailModuleActivity.class);
        intent.putExtra("token", mToken);
        intent.putExtra("title", currentModule.getTitle());
        intent.putExtra("scolaryear", currentModule.getScolaryear());
        intent.putExtra("codemodule", currentModule.getCodemodule());
        intent.putExtra("codeinstance", currentModule.getCodeinstance());
        startActivity(intent);
    }
}
