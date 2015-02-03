package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Note;

public class DetailMarkFragment extends Fragment {

    private String mTitle;
    private ArrayList<Note> marks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mTitle = getArguments().getString("title");

            TextView t = (TextView)getActivity().findViewById(R.id.final_note);
            t.setText("salu");
            //((TextView)getView().findViewById(R.id.module_title)).setText("salut");
            //((TextView)getActivity().findViewById(R.id.module_title)).setText(getArguments().getString("module"));
            //((TextView)getActivity().findViewById(R.id.final_note)).setText(getArguments().getString("note"));
            //((TextView)getActivity().findViewById(R.id.correcteur)).setText(getArguments().getString("correcteur"));
            //((TextView)getActivity().findViewById(R.id.comment)).setText(getArguments().getString("comment"));

//            marks = getArguments().get("marks");
        }

        getActivity().setTitle(mTitle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_mark, container, false);
    }
}
