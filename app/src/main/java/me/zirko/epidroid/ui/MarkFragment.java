package me.zirko.epidroid.ui;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Mark.Note;
import me.zirko.epidroid.model.Mark.Notes;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class MarkFragment extends ListFragment implements Response.Listener<Notes>, Response.ErrorListener {

    private String mToken;
    private static final String TAG = ModuleFragment.class.getSimpleName();
    private static String API_ROUTE = "/marks";
    private List<Note> mMarks;

    public MarkFragment() {
    }

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
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "error request : " + volleyError.toString());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Note currentMark = (Note)mMarks.get(mMarks.size() - position - 1);


        Log.i(TAG, currentMark.getTitlemodule());

        Intent intent = new Intent(getActivity(), DetailMarkActivity.class);
        intent.putExtra("token", mToken);
        intent.putExtra("title", currentMark.getTitle());
        intent.putExtra("module", currentMark.getTitlemodule());
        intent.putExtra("note", currentMark.getFinalNote());
        intent.putExtra("correcteur", currentMark.getCorrecteur());
        intent.putExtra("comment", currentMark.getComment());


        startActivity(intent);
    }

    @Override
    public void onResponse(final Notes marks) {
        mMarks = marks.getNotes();

        ArrayList<String> displayArray = new ArrayList<String>();
        for (Note currentNote : marks.getNotes()) {
            displayArray.add(currentNote.getTitle() + " : " + currentNote.getFinalNote());
        }
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, displayArray);

        Collections.reverse(displayArray);

        setListAdapter(itemsAdapter);

    }
}