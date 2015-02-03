package me.zirko.epidroid.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.DetailModule.DetailModule;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class DetailModuleFragment extends Fragment
        implements Response.Listener<DetailModule>, Response.ErrorListener {

    private static final String TAG = DetailModuleFragment.class.getSimpleName();
    private static String API_ROUTE = "/module";
    private String mToken;
    private Integer mScolarYear;
    private String mCodeModule;
    private String mCodeInstance;
    private String mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mToken = getArguments().getString("token");
            mTitle = getArguments().getString("title");
            mScolarYear = getArguments().getInt("scolaryear");
            mCodeModule = getArguments().getString("codemodule");
            mCodeInstance = getArguments().getString("codeinstance");
        }

        getActivity().setTitle(mTitle);

        if (savedInstanceState == null) {
            fetchModule();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_module, container, false);
    }

    private void fetchModule() {
        String url = API_ROUTE + "?token=" + mToken;
        url += "&scolaryear=" + mScolarYear;
        url += "&codemodule=" + mCodeModule;
        url += "&codeinstance=" + mCodeInstance;

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, DetailModule.class, this, this));
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "Error : " + volleyError.toString());
    }

    @Override
    public void onResponse(DetailModule detailModule) {
        if (getView() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Button buttonActionModule = (Button) getView().findViewById(R.id.module_unsubscribe);

            try {
                Date dateEndRegister = sdf.parse(detailModule.getEndRegister());
                Date currentDate = new Date();

                if (currentDate.before(dateEndRegister)) {
                    buttonActionModule.setVisibility(View.VISIBLE);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ((TextView) getView().findViewById(R.id.module_grade))
                    .setText(getString(R.string.student_grade_module,
                            detailModule.getStudentGrade()));

            ((TextView) getView().findViewById(R.id.module_credits)).setText(
                    getString(R.string.number_credits_module,
                            detailModule.getCredits()));

            ((TextView) getView().findViewById(R.id.module_detail))
                    .setText(detailModule.getDescription());
        }
    }
}