package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
        }

        getActivity().setTitle(mTitle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.module_title)).setText("salut");
        ((TextView) view.findViewById(R.id.module_title)).setText(getArguments().getString("module"));
        ((TextView) view.findViewById(R.id.final_note)).setText(getArguments().getString("note"));
        ((TextView) view.findViewById(R.id.correcteur)).setText(getArguments().getString("correcteur"));
        ((TextView) view.findViewById(R.id.comment)).setText(getArguments().getString("comment"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_mark, container, false);
    }
}
