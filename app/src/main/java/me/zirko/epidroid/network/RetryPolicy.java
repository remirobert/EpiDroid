package me.zirko.epidroid.network;

import android.util.Log;

import com.android.volley.VolleyError;


/**
 * Implementation of RetryPolicy. Global configuration for the application
 *
 * @author Guillaume Fillon
 * @version 0.1
 * @since 0.1
 */
public class RetryPolicy implements com.android.volley.RetryPolicy {
    private static final String TAG = RetryPolicy.class.getSimpleName();

    /**
     * Returns the current timeout (used for logging).
     */
    @Override
    public int getCurrentTimeout() {
        return 5000;
    }

    /**
     * Returns the current retry count (used for logging).
     */
    @Override
    public int getCurrentRetryCount() {
        return 3;
    }

    /**
     * Prepares for the next retry by applying a backoff to the timeout.
     *
     * @param error The error code of the last attempt.
     *
     * @throws com.android.volley.VolleyError In the event that the retry could not be performed
     *                                        (for example if we
     *                                        ran out of attempts), the passed in error is thrown.
     */
    @Override
    public void retry(VolleyError error) throws VolleyError {
        Log.e(TAG, error.getMessage());
    }
}
