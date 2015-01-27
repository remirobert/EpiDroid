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

import java.util.ArrayList;
import java.util.List;

import me.zirko.epidroid.model.Project;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProjectsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProjectsFragment extends ListFragment
        implements Response.Listener<Project[]>, Response.ErrorListener {
    private static final String TAG = ScheduleFragment.class.getSimpleName();
    private static String API_ROUTE = "/projects";
    private Activity mActivity;
    private String mToken;
    private ProjectAdapter mAdapter;

    public ProjectsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ProjectsFragment.
     */
    public static ProjectsFragment newInstance() {
        ProjectsFragment fragment = new ProjectsFragment();

        return fragment;
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

        if (getArguments() != null) {
            mToken = getArguments().getString("token");
        }

        if (savedInstanceState == null) {
            fetchProjects();
        }
    }

    private void fetchProjects() {
        VolleySingleton.getInstance(mActivity).addToRequestQueue(new GsonRequest<>(
                API_ROUTE + "?token=" + mToken, Project[].class, this, this));
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mActivity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAdapter = new ProjectAdapter(mActivity);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDividerHeight(0);
    }

    @Override
    public void onResponse(Project[] projects) {
        List<Project> projectList = new ArrayList<>();


        for (Project project : projects) {
            if (Integer.valueOf(1).equals(project.getRegistered()) && "proj".equals(project.getTypeActiCode())) {
                projectList.add(project);
            }
        }

        mAdapter.addAll(projectList);

        if (getListAdapter() == null) {
            setListAdapter(mAdapter);
        }
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "onErrorResponse " + volleyError.getLocalizedMessage());
    }
}
