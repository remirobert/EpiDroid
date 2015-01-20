package me.zirko.epidroid.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.dd.processbutton.iml.ActionProcessButton;

import java.util.HashMap;
import java.util.Map;

import me.zirko.epidroid.R;
import me.zirko.epidroid.model.Account;
import me.zirko.epidroid.network.GsonRequest;
import me.zirko.epidroid.network.VolleySingleton;

public class LoginFragment extends Fragment
        implements Response.Listener<Account>, Response.ErrorListener {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private static String API_ROUTE = "/login";
    private static final String PREFERENCE_CREDENTIALS = "preference:credentials";
    private static final String PREFERENCE_CREDENTIALS_TOKEN = "preference:credentials";
    private View rootView;

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                PREFERENCE_CREDENTIALS, Context.MODE_PRIVATE);
        String token = sharedPref.getString(PREFERENCE_CREDENTIALS_TOKEN, null);

        if (token != null) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("token", token);
            startActivity(intent);
            getActivity().finish();
        }
    }

    @Override
    public void onResponse(Account user) {
        ((ActionProcessButton) this.rootView.findViewById(R.id.login_connect)).setProgress(100);
        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                PREFERENCE_CREDENTIALS, Context.MODE_PRIVATE);
        sharedPref.edit().putString(PREFERENCE_CREDENTIALS_TOKEN, user.getToken()).commit();

        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.putExtra("token", user.getToken());
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, "err: " + volleyError.toString());
        ((ActionProcessButton) this.rootView.findViewById(R.id.login_connect)).setProgress(-1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        this.rootView = rootView;
        final ActionProcessButton processButton = (ActionProcessButton) rootView.findViewById(R.id
                .login_connect);

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
                processButton.setProgress(1);
            }
        });

        return rootView;
    }

    private void makeRequest() {
        Map<String, String> params = new HashMap<String, String>();
        TextView loginTextView = (TextView) getView().findViewById(R.id.login_username);
        TextView passwordTextView = (TextView) getView().findViewById(R.id.login_password);

        params.put("login", loginTextView.getText().toString());
        params.put("password", passwordTextView.getText().toString());

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                API_ROUTE, Account.class, this, this, params));
    }
}
