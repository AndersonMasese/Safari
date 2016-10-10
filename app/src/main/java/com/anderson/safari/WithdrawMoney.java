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

public class WithdrawMoney extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.withdraw);
        Intent intent=getIntent();
        final String telephone=intent.getStringExtra("telephone");
        final Button button=(Button)findViewById(R.id.button);
        final EditText telephone1=(EditText) findViewById(R.id.telephone);
        final EditText amount=(EditText) findViewById(R.id.amount);
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
                                AlertDialog.Builder builder=new AlertDialog.Builder(WithdrawMoney.this);
                                builder.setMessage("Withdraw Successful")
                                        .setNegativeButton("Okay",null)
                                        .create()
                                        .show();

                            }
                            else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(WithdrawMoney.this);
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
                //call Registerrequest to pass the specified arguments to the new class
                WithdrawRequest withdrawRequest=new WithdrawRequest(myamount,mytelephone,telephone2,responselistener);
                RequestQueue queue= Volley.newRequestQueue(WithdrawMoney.this);
                queue.add(withdrawRequest);



            }
        });
    }
}
