package com.my.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button b;
   // private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   mAuth = FirebaseAuth.getInstance();



        Button b = (Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAct();
            }
        });
    }

   /* @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            Intent o = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(o);
            finish();
        }

    }
}*/
        public void openAct () {
            Intent f = new Intent(this, Main2Activity.class);
            startActivity(f);
            finish();
        }

}



/*
                c=0;
                Map<String, Object> map2 = (HashMap<String, Object>) dataSnapshot.child("Users").getValue();
                assert map2 != null;
                for (String key : map2.keySet()) {
                    user_name1[c] = (String) dataSnapshot.child("Users").child(key).child("name").getValue();
                    user_status1[c] = (String) dataSnapshot.child("Users").child(key).child("status").getValue();
                    itemlist.add(user_name1[c]);
                    itemlist.add(user_status1[c]);
                    c = c + 1;
                }*/