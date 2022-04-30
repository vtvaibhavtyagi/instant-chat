package com.my.myapplication;

import android.app.Notification;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{

    private FirebaseAuth mAuth;
    private List<Messages> mMessageList;

    OnBottomReachedListener onBottomReachedListener;
    public MessageAdapter(List<Messages> mMessageList)
    {
        this.mMessageList=mMessageList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.message_single,parent,false);
        return new MessageViewHolder(v);
    }
    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        if (position == mMessageList.size() - 1){

            onBottomReachedListener.onBottomReached(position);

        }
        mAuth=FirebaseAuth.getInstance();
       String current_user_id=mAuth.getCurrentUser().getUid();

        Messages c=mMessageList.get(position);
        holder.msg_text.setText(c.getMessage());
        String from_user=c.getFrom();
      if(from_user.equals(current_user_id))
      {
          holder.msg_text.setBackgroundColor(Color.WHITE);
          holder.msg_text.setTextColor(Color.BLACK);
          holder.msg_text.getCompoundPaddingLeft();
      }
      else
      {
          holder.msg_text.setBackgroundResource(R.drawable.message_text);
          holder.msg_text.setTextColor(Color.WHITE);
      }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView msg_text;
        public MessageViewHolder(View View) {
            super(View);
            msg_text=(TextView)View.findViewById(R.id.msg_text);
        }
    }
}
