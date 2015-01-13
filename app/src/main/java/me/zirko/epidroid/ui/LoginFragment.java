package me.zirko.epidroid.ui;

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

/**
 * Created by remirobert on 13/01/15.
 */
public class LoginFragment extends Fragment implements Response.Listener<Account>, Response.ErrorListener{

    public LoginFragment() {
    }


    @Override
    public void onResponse(Account user) {
        Log.i("USER DEBUG", "token : " + user.getToken());
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(getActivity(), "Error connection", Toast.LENGTH_SHORT).show();
        Log.e("ERROR REQUEST", "error : "+  volleyError.toString());

    }

    private void makeRequest() {
        Map<String, String>  params = new HashMap<String, String>();
        TextView loginTextView = (TextView)getView().findViewById(R.id.loginTextView);
        TextView passwordTextView = (TextView)getView().findViewById(R.id.passwordTextView);

        params.put("login", loginTextView.getText().toString());
        params.put("password", passwordTextView.getText().toString());

        VolleySingleton.getInstance(getActivity()).addToRequestQueue(new GsonRequest<>(
                Request.Method.POST,"https://epitech-api.herokuapp.com/login", Account.class, this, this, params));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_login, container, false);

        final ActionProcessButton processButton = (ActionProcessButton)rootView.findViewById(R.id.flatButtonConnection);

        //Button buttonConnection = (Button)rootView.findViewById(R.id.buttonConnection);

        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // makeRequest();
                processButton.setProgress(30);
                //processButton.setMode(ActionProcessButton.Mode.PROGRESS);
            }
        });

        return rootView;
    }
}
