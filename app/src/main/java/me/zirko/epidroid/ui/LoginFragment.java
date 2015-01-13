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
import android.widget.Toast;

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
    private static final String PREFERENCE_CREDENTIALS = "preference:credentials";
    private static final String PREFERENCE_CREDENTIALS_TOKEN = "preference:credentials";

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
        Toast.makeText(getActivity(), "Error connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        final ActionProcessButton processButton = (ActionProcessButton) rootView.findViewById(R.id
                .login_connect);

        //Button buttonConnection = (Button)rootView.findViewById(R.id.buttonConnection);

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
                processButton.setProgress(30);
                //processButton.setMode(ActionProcessButton.Mode.PROGRESS);
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
                Request.Method.POST, "https://epitech-api.herokuapp.com/login", Account.class,
                this, this, params));
    }
}
