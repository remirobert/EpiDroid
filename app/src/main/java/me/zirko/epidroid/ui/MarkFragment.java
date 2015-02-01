package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Mark.Note;
import me.zirko.epidroid.model.Mark.Notes;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class MarkFragment extends Fragment implements Response.Listener<Notes>, Response.ErrorListener{

    private String mToken;
    private static final String TAG = ModuleFragment.class.getSimpleName();
    private ArrayAdapter mAdapter;
    private static String API_ROUTE = "/marks";
    private HashMap<String, ArrayList> moduleMap;

    public MarkFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mToken = getArguments().getString("token");
        }
        Log.i(TAG, "create fragments ok");
        fetchMarks();
    }

    public void fetchMarks() {
        String url = API_ROUTE + "?token=" + mToken;

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, Notes.class, this, this));
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
    public void onResponse(final Notes marks) {
        Log.i(TAG, "get notes okay");

        moduleMap = new HashMap<String, ArrayList>();
        for (Note currentNote: marks.getNotes()) {
            if (!moduleMap.containsKey(currentNote.getCodemodule())) {
                moduleMap.put(currentNote.getTitlemodule(), new ArrayList());
            }
            moduleMap.get(currentNote.getTitlemodule()).add(currentNote);
            Log.i(TAG, "debug + " + currentNote.getTitlemodule());
        }

        ArrayList<String> displayArray = new ArrayList<String>();

        for (ArrayList currentMarkModule: moduleMap.values()) {
            Double averageMark = 0.0;
            String nameModule = ((Note)currentMarkModule.get(0)).getTitlemodule();


            for (Object currentMark: currentMarkModule) {
                averageMark += ((Note)currentMark).getFinalNote();
            }
            averageMark /= currentMarkModule.size();
            displayArray.add(nameModule + " : " + averageMark.toString());
        }



        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, displayArray);

        ((ListView)getActivity().findViewById(R.id.marks_list)).setAdapter(itemsAdapter);


        Log.i(TAG, "keys : " + moduleMap.keySet());
    }
}
