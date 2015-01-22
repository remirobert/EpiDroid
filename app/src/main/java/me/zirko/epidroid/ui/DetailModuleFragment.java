package me.zirko.epidroid.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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

public class DetailModuleFragment extends Fragment implements Response.Listener<DetailModule>, Response.ErrorListener {

    private static final String TAG = DetailModuleFragment.class.getSimpleName();
    private static String API_ROUTE = "/module";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        String url = API_ROUTE + "?token=" + bundle.getString("token");
        url += "&scolaryear=" + bundle.getString("scolaryear");
        url += "&codemodule=" + bundle.getString("codemodule");
        url += "&codeinstance=" + bundle.getString("codeinstance");

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                url, DetailModule.class, this, this));
        return inflater.inflate(R.layout.fragment_detail_module, container, false);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "Error : " + volleyError.toString());
    }

    @Override
    public void onResponse(DetailModule detailModule) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Button buttonActionModule = (Button)getView().findViewById(R.id.buttonAction);

            try {
                Date dateEndRegister = sdf.parse(detailModule.getEndRegister());
                Date currentDate = new Date();

                if (currentDate.before(dateEndRegister)) {
                    buttonActionModule.setVisibility(View.VISIBLE);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        ((TextView)getView().findViewById(R.id.gradeView)).setText(getString(R.string.student_grade_module) + ": " + detailModule.getStudentGrade());
        ((TextView)getView().findViewById(R.id.titleModuleDetail)).setText(detailModule.getTitle());
        ((TextView)getView().findViewById(R.id.creditsModuleDetail)).setText(getString(R.string.number_credits_module) + ": " + detailModule.getCredits().toString());
        ((TextView)getView().findViewById(R.id.descriptionModuleDetail)).setText(detailModule.getDescription());
    }
}