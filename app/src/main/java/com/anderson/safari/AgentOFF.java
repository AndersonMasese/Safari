package com.anderson.safari;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anderson on 7/28/2016.
 */
public class AgentOFF extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://safarizone.comxa.com/agentstatusoff.php";
    private Map<String, String> params;
    public AgentOFF(String telephone2, Response.Listener<String> listener)
    {
        super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();

        params.put("telephone2",telephone2);
        //the strings are mapped as exactly as they are expected in the caller function
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

