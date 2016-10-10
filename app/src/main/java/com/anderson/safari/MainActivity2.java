package com.anderson.safari;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {

    String url="http://safarizone.comxa.com/phpfiletalkedto.php";
//give a statement of your own url
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView lv= (ListView) findViewById(R.id.lv);
        final Downloader d=new Downloader(this,url,lv);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EXECUTE DOWNLOAD
                d.execute();
            }
        });
/*
        //program the choose telephone editText and button10 here to connect to database
        //using the send money buttons loginc, carrying the same arguments but different buttons
        Intent intent=getIntent();
        final String telephone=intent.getStringExtra("telephone");
        //intent carried on from the android intent system as string telephone
        final Button button=(Button)findViewById(R.id.button10);
        final EditText telephone1=(EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mytelephone=telephone1.getText().toString();
                //final String myamount=amount.getText().toString();
                final String telephone2=telephone;

                Response.Listener<String> responselistener=new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean successfulRegistration=jsonResponse.getBoolean("success");
                            if(successfulRegistration){
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
                                builder.setMessage("Investment Successful")
                                        .setNegativeButton("Okay",null)
                                        .create()
                                        .show();

                            }
                            else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
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

                //class deduction should now receive the same parameters:-[
                MainActivityRequest mainActivityRequest=new MainActivityRequest(mytelephone,telephone2,responselistener);
                RequestQueue queue= Volley.newRequestQueue(MainActivity2.this);
                queue.add(mainActivityRequest);




            }
        });
*/


    }

}