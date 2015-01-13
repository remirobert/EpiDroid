package me.zirko.epidroid.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import me.zirko.epidroid.network.VolleySingleton;

import me.zirko.epidroid.R;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        public void makeRequest() {
            StringRequest postRequest = new StringRequest(Request.Method.POST, "https://epitech-api.herokuapp.com/login",
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response", error.toString());
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();

                    TextView loginTextView = (TextView)getView().findViewById(R.id.loginTextView);
                    TextView passwordTextView = (TextView)getView().findViewById(R.id.passwordTextView);

                    params.put("login", loginTextView.getText().toString());
                    params.put("password", passwordTextView.getText().toString());

                    Log.i("E", "" + params);
                    return params;
                }
            };

            VolleySingleton.getInstance(getActivity()).addToRequestQueue(postRequest);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView =  inflater.inflate(R.layout.fragment_login, container, false);

            Button buttonConnection = (Button)rootView.findViewById(R.id.buttonConnection);

            buttonConnection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    makeRequest();
                }
            });


            return rootView;
        }
    }
}
