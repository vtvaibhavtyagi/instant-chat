package com.my.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    public DatabaseReference mref;
    private TextView p_name,p_status;
    Button send_request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String user_uid=getIntent().getStringExtra("idf");
        p_name=(TextView)findViewById(R.id.profile_display_name);
        p_status=(TextView)findViewById(R.id.profile_display_status);
        send_request=(Button)findViewById(R.id.profile_display_button);

        mref=FirebaseDatabase.getInstance().getReference().child("Users").child(user_uid);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 String pName=dataSnapshot.child("name").getValue().toString();
                String pStatus=dataSnapshot.child("status").getValue().toString();

                p_name.setText(pName);
                p_status.setText(pStatus);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
