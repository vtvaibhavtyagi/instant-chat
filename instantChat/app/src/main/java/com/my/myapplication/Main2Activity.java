package com.my.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button button;
    private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.needNewAcc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(Main2Activity.this,Register.class);
                startActivity(p);
                System.out.println("Register started");
            }
        });
        b2=(Button)findViewById(R.id.haveanAcc);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(Main2Activity.this,LogIn.class);
                startActivity(z);
            }
        });
    }


}
