package com.my.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class Register extends AppCompatActivity {


    private EditText regDisplay_name;
    private EditText regEmail;
    private EditText regPass;
    private Button reg;
    private Firebase mroot;
    private DatabaseReference mDatabase;
    //Firebase Auth
    private FirebaseAuth mAuth;
    private ProgressDialog mRegProgress;
    public String display_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        //mroot=new Firebase("https://my-chat-app-3e0ea.firebaseio.com/");

        //Android fields
        regDisplay_name = (EditText) findViewById(R.id.regaccName);
        regEmail = (EditText) findViewById(R.id.regeditTextEmail);
        regPass = (EditText) findViewById(R.id.regeditTextPassword);
        reg = (Button) findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_name = regDisplay_name.getText().toString();
                System.out.println(display_name);
                String email = regEmail.getText().toString();
                String password = regPass.getText().toString();
                System.out.println(password);
                 Users s=new Users();
                 s.setName(display_name);
                 s.setStatus(password);
                register_user(display_name, email, password);
                System.out.println("yassssssssssss"+s.getName());

            }
        });


    }

    public void register_user(final String display_n, final String email, final String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() && (!(email=="")&& !(password=="")) ) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            String uid=user.getUid();

                            mDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                            HashMap<String ,Object> userMap=new HashMap<>();
                            userMap.put("name",display_n);
                            userMap.put("email",email);
                            userMap.put("password",password);
                            userMap.put("status","Hola there! You are using the most amazing chatApp ever!");
                            userMap.put("image","default_image");
                            userMap.put("thumb_image","default");

                            mDatabase.setValue(userMap);

                                        Toast.makeText(Register.this, "Authentication successful!!.", Toast.LENGTH_SHORT).show();
                                        Intent k = new Intent(Register.this, ChatAct.class);
                                        startActivity(k);
                                        finish();



                        } else {
                            // If sign in fails, display a message to the user.


                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }
}
