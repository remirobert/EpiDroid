package me.zirko.epidroid.ui;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Board;
import me.zirko.epidroid.model.ListModuleItem;
import me.zirko.epidroid.model.Module;
import me.zirko.epidroid.model.ModuleList;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class ModuleFragment extends Fragment implements Response.Listener<ModuleList>, Response.ErrorListener {

    private static final String TAG = ModuleFragment.class.getSimpleName();
    private static String API_ROUTE = "/modules";
    private ModuleList moduleList;

    private String mToken;


    public ModuleFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mToken = getArguments().getString("token");

        this.launchRequestModule();
        return inflater.inflate(R.layout.fragment_module, container, false);
    }

    public void launchRequestModule() {
        String url = API_ROUTE + "?token=" + mToken;

        /*
        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("token", mToken);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST,
                "https://epitech-api.herokuapp.com/infos",
                new JSONObject(jsonParams), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "REPOSNSE JSON = " + response);
                // TODO Auto-generated method stub
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
            }
        });

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(jsObjRequest);
    */

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, ModuleList.class, this, this));
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "error request : " + volleyError.toString());
    }

    @Override
    public void onResponse(final ModuleList module) {

        Log.i(TAG, "request over");
        moduleList = module;

        List<String> titlesModule = new ArrayList<>();

        for (ListModuleItem currentModule: module.getModules()) {
            Log.i(TAG, "title : " + currentModule.getIdUserHistory());
            titlesModule.add(currentModule.getTitle());
        }

        ListView listView = (ListView)getView().findViewById(R.id.module_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                titlesModule);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                List<ListModuleItem> listModuleItems = module.getModules();
                ListModuleItem currentModule = (listModuleItems.get(position));

                Intent intent = new Intent(getActivity(), DetailModuleActivity.class);
                intent.putExtra("token", mToken);
                intent.putExtra("scolaryear", currentModule.getScolaryear().toString());
                intent.putExtra("codemodule", currentModule.getCodemodule().toString());
                intent.putExtra("codeinstance", currentModule.getCodeinstance().toString());
                startActivity(intent);
            }
        });

    }
}
