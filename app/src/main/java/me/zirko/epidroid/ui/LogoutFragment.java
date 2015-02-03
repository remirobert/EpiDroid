package me.zirko.epidroid.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class LogoutFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                LoginFragment.PREFERENCE_CREDENTIALS, Context.MODE_PRIVATE);
        sharedPref.edit().putString(LoginFragment.PREFERENCE_CREDENTIALS_TOKEN, "").commit();

        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
