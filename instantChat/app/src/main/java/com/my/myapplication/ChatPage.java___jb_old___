package com.my.myapplication;

import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatPage extends AppCompatActivity {
      public String mChatUser;
      private Toolbar mToolbar;
      private DatabaseReference mDataRef;
      private EditText mChatText;
      private Button mChatButton;
      private DatabaseReference mRootRef;
      private FirebaseAuth mAuth;
      private String mCurrentUserId;
      private String chat_user_name;
      private RecyclerView mMessagesList;
      private final List<Messages> messagesList=new ArrayList<>();
      private LinearLayoutManager mLinearLayout;
      private MessageAdapter mAdapter;
     private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);
          mMessagesList=(RecyclerView)findViewById(R.id.msg_recyclerView);
          mLinearLayout=new LinearLayoutManager(this);

          mAdapter=new MessageAdapter(messagesList);
          mMessagesList.setHasFixedSize(true);
          mMessagesList.setLayoutManager(mLinearLayout);

        chat_user_name=getIntent().getStringExtra("name1");
        mChatUser=getIntent().getStringExtra("idf1");
        mRootRef=FirebaseDatabase.getInstance().getReference();
        mChatText=(EditText)findViewById(R.id.chat_msg);
        mChatButton=(Button)findViewById(R.id.chat_sendbtn);
        mDataRef=FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        mCurrentUserId=mAuth.getCurrentUser().getUid();
       System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+mCurrentUserId);
        setTitle(chat_user_name);
    //    setContentView(R.layout.activity_chat_page);


       mChatButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String message=mChatText.getText().toString();
              sendMessage();
           }
       });


        mMessagesList.setAdapter(mAdapter);
        mAdapter.setOnBottomReachedListener(new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                
            }
        });
        loadMessages();

    }

    private void loadMessages() {
        mRootRef.child("messages").child(mCurrentUserId).child(mChatUser).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
               Messages message=dataSnapshot.getValue(Messages.class);

               messagesList.add(message);
               mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void sendMessage() {
         message=mChatText.getText().toString();
if(!TextUtils.isEmpty(message)) {

    String current_user_ref="messages/"+mCurrentUserId+"/"+mChatUser;
    String chat_user_ref="messages/"+mChatUser+"/"+mCurrentUserId;
  //mRootRef=FirebaseDatabase.getInstance().getReference().child("Messages").child(mCurrentUserId);
    DatabaseReference user_name_push=mRootRef.child("Messages").child(mCurrentUserId).child(mChatUser).push();
    String push_id=user_name_push.getKey();

    Map messageMap = new HashMap();
    messageMap.put("message",message);
    messageMap.put("type","text");
    messageMap.put("time",ServerValue.TIMESTAMP);
    messageMap.put("from",mCurrentUserId);
    Map messageUserMap=new HashMap();
    messageUserMap.put(current_user_ref+"/"+push_id,messageMap);
    messageUserMap.put(chat_user_ref+"/"+push_id,messageMap);


    mRootRef.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
        @Override
        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
/*
            if(databaseError!=null)
            {
                Log.d("CHAT_LOG", databaseError.getMessage());
            }*/
        }
    });

}
    }
}
