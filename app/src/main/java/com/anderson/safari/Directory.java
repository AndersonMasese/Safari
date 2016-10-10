package com.anderson.safari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Directory extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfullogin);
        //sendMoney();withdrawMoney();ownAccount();invest();

        Intent intent=getIntent();
        final String telephone=intent.getStringExtra("telephone");
        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent=new Intent(Directory.this,WithdrawMoney.class);
                                          intent.putExtra("telephone",telephone);
                                          Directory.this.startActivity(intent);
                                      }
                                  }
                //propagate an intent of username which will be unique and and the ease of sstring
                //projections throughout the system
        );
        Button button1=(Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent=new Intent(Directory.this,SendMoney.class);
                                           intent.putExtra("telephone",telephone);
                                           Directory.this.startActivity(intent);
                                       }
                                   }
        );
        Button button2=(Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent=new Intent(Directory.this,MainActivity2.class);
                                           intent.putExtra("telephone",telephone);
                                           Directory.this.startActivity(intent);
                                       }
                                   }
        );
        Button button3=(Button) findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent=new Intent(Directory.this,Deposit.class);
                                           intent.putExtra("telephone",telephone);
                                           Directory.this.startActivity(intent);
                                       }
                                   }
        );
        Button button4=(Button) findViewById(R.id.button6);
        button4.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent=new Intent(Directory.this,Statement.class);
                                           intent.putExtra("telephone",telephone);
                                           Directory.this.startActivity(intent);
                                       }
                                   }
        );

    }
    //create the methods for the various buttons which will be called in method onCreate
    //these mehods will redirect intents for invest,send money and withdraw & invest in own account
    //methods removed to be able to pass the telephone sessio variable properly
}
