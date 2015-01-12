package me.zirko.epidroid.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import me.zirko.epidroid.BuildConfig;

/**
 * Volley adapter for GET JSON requests that will be parsed into Java objects by Gson.
 */
public class GsonRequest<T> extends Request<T> {
    private final static String BASE_URL = BuildConfig.API_ENDPOINT;
    private final String TAG = getClass().getSimpleName();
    private final Gson gson =
            new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
    private final Class<T> clazz;
    private final Response.Listener<T> listener;
    private final Map<String, String> params;

    /**
     * Make a GET request and return a POJO from parsed JSON
     * to the {@link Response.Listener} callback
     *
     * @param url           URL of the request to make
     * @param listener      Response listener
     * @param errorListener Error Response listener
     * @param clazz         Relevant class object, for Gson's reflection
     */
    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, BASE_URL + url, clazz, listener, errorListener, null);
    }

    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener, Map<String, String> params) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
        this.params = params;
    }

    /**
     * Make a GET/POST request and return a POJO from parsed JSON
     * to the {@link Response.Listener} callback
     *
     * @param url           URL of the request to make
     * @param listener      Response listener
     * @param errorListener Error Response listener
     * @param clazz         Relevant class object, for Gson's reflection
     */
    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener, Map<String, String> params) {
        this(params == null ? Method.GET : Method.POST, BASE_URL + url, clazz, listener,
                errorListener, params);
    }

    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener, Map<String, String> params,
                       boolean base) {
        this(params == null ? Method.GET : Method.POST, base ? BASE_URL + url : url, clazz,
                listener, errorListener, params);
    }

    @Override
    public Map<String, String> getParams() {
        return this.params;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

}