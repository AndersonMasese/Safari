package com.anderson.safari;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

 /**
 * Created by Anderson on 7/31/2016.
 */
public class MainActivityRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://safarizone.comxa.com/investor.php";
    private Map<String, String> params;

    public MainActivityRequest(String mytelephone, String telephone2, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("mytelephone", mytelephone);
        params.put("telephone2", telephone2);

    }
    //telephone2 is the session telephone
    //mytelephone is the alien telephone


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

