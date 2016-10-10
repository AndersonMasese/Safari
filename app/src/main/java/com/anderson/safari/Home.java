package com.anderson.safari;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerMethod();registerLogin();registerQuestion();

    }
    public void registerMethod()
    {
        Button button7=(Button)findViewById(R.id.button7);
        final Context context=this;
        button7.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View V)
            {
                //Intent i=new Intent(context, Register.class);
                //startActivity(i);
                Intent intent=new Intent(Home.this,RegisterActivity.class);
                Home.this.startActivity(intent);
            }
        });

    }
    public void registerLogin()
    {
        Button button8=(Button)findViewById(R.id.button8);
        final Context context=this;
        button8.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View V)
            {
                Intent i=new Intent(context, LoginActivity.class);
                startActivity(i);
            }
        });
    }
    public void registerQuestion()
    {
        Button button9=(Button)findViewById(R.id.button9);
        final Context context=this;
        button9.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View V)
            {
                Intent i=new Intent(context, AboutSafari.class);
                startActivity(i);
                //display the links and other explanation that can inform the
                //the user wat Safarizone is all  about preferably in an offline view mode
            }
        });

    }
}
