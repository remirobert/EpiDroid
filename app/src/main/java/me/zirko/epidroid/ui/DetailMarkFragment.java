package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
