package com.my.myapplication;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class changeStatus extends AppCompatActivity {


    private EditText mStatus;
    private Button mSaveBtn;
    private DatabaseReference mStatusDatabase;
    private FirebaseUser mCurrentUser;
    private ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_status);

        mCurrentUser =FirebaseAuth.getInstance().getCurrentUser();
        String current_uid=mCurrentUser.getUid();
        mStatusDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);

        String statusoriginal=getIntent().getStringExtra("status value").toString();

        mStatus=(EditText)findViewById(R.id.changed_status);
        mStatus.setText(statusoriginal);
        mSaveBtn=(Button)findViewById(R.id.status_saveButton);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress=new ProgressDialog(changeStatus.this);
                mProgress.setTitle("Saving changes");
                mProgress.setMessage("Please wait while the changes are being saved");
                mProgress.show();
                String status=mStatus.getEditableText().toString();
                mStatusDatabase.child("status").setValue(status).addOnCompleteListener(new OnCompleteListener<Void>() {
                     @Override
                     public void onComplete(@NonNull Task<Void> task) {
                         if(task.isSuccessful())
                         {
                             mProgress.dismiss();
                         }
                         else
                         {
                             Toast.makeText(getApplicationContext(),"Some error in saving changes",Toast.LENGTH_LONG).show();
                         }
                     }
                 });
            }
        });

    }
}
