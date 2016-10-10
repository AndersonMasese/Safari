package com.anderson.safari;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Deposit extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        Intent intent=getIntent();
        final String telephone=intent.getStringExtra("telephone");
        final Button button=(Button)findViewById(R.id.button);
        final EditText telephone1=(EditText) findViewById(R.id.telephone);
        final EditText amount=(EditText) findViewById(R.id.amount);
        final Button on=(Button)findViewById(R.id.button0);
        final Button off=(Button)findViewById(R.id.buttonz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mytelephone=telephone1.getText().toString();
                final String myamount=amount.getText().toString();
                final String telephone2=telephone;

                Response.Listener<String> responselistener=new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean successfulRegistration=jsonResponse.getBoolean("success");
                            if(successfulRegistration){
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Transaction Successful")
                                        .setNegativeButton("Okay",null)
                                        .create()
                                        .show();

                            }
                            else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Transaction Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                DepositRequest depositRequest=new DepositRequest(myamount,mytelephone,telephone2,responselistener);
                RequestQueue queue= Volley.newRequestQueue(Deposit.this);
                queue.add(depositRequest);


            }
        });
        //Now set the two other buttons here which will create a json map and set
        //server status as either 1 or 0 to be used by the showactive agents class
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String telephone2=telephone;

                Response.Listener<String> responselistener=new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean successfulRegistration=jsonResponse.getBoolean("success");
                            if(successfulRegistration){
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Agent visibility status:ON")
                                        .setNegativeButton("Okay",null)
                                        .create()
                                        .show();

                            }
                            else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Status Change Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //call Registerrequest to pass the specified arguments to the new class

                AgentON agentON=new AgentON(telephone2,responselistener);
                RequestQueue queue= Volley.newRequestQueue(Deposit.this);
                queue.add(agentON);
                //class deduction should now receive the same parameters:-[




            }
        });

        //buttonz
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String telephone2=telephone;

                Response.Listener<String> responselistener=new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean successfulRegistration=jsonResponse.getBoolean("success");
                            if(successfulRegistration){
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Agent visibilit status:OFF")
                                        .setNegativeButton("Okay",null)
                                        .create()
                                        .show();

                            }
                            else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Deposit.this);
                                builder.setMessage("Status change Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //call Registerrequest to pass the specified arguments to the new class

                AgentOFF agentOFF=new AgentOFF(telephone2,responselistener);
                RequestQueue queue= Volley.newRequestQueue(Deposit.this);
                queue.add(agentOFF);
                //class deduction should now receive the same parameters:-[



            }
        });
        //end here before the ide even realizes what  is happening
        //create a table status to hold the statuses.



    }
}
