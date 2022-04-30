package com.my.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AllUsers extends AppCompatActivity {
private RecyclerView musersList;
private DatabaseReference mUsersDatabase;
private FirebaseUser cUser;
Users user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
    }}



//
//
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        itemlist.clear();
//        Map<String,Object> map= (HashMap<String, Object>)dataSnapshot.getValue();
//        Collection<Object> list= map.values();
//        System.out.println(list);
//        for(Object myitem:list){
//
//            //String testName = myitem.child("name").getValue(String.class);
//            System.out.println(myitem);
//
//            //Users info=myitem.getValue(Users.class);
//
//            Toast.makeText(getApplicationContext(),"name"+myitem,Toast.LENGTH_LONG).show();










//
//    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        itemlist.clear();
//        Map<String, Object> map = (HashMap<String, Object>) dataSnapshot.child("Users").getValue();
//                /*for ( String key : map.keySet() ) {
//                    user_key[c]=key ;
//                }*/
//        assert map != null;
//        for (String key : map.keySet()) {
//            user_name1[c] = (String) dataSnapshot.child("Users").child(key).child("name").getValue();
//            user_status1[c] = (String) dataSnapshot.child("Users").child(key).child("status").getValue();
//            itemlist.add(user_name1[c]);
//            itemlist.add(user_status1[c]);
//            c = c + 1;
//        }
//





























/*        mUsersDatabase=FirebaseDatabase.getInstance().getReference().child("Users");
          cUser=FirebaseAuth.getInstance().getCurrentUser();
        musersList=(RecyclerView)findViewById(R.id.programming_list);
        musersList.setHasFixedSize(true);
        musersList.setLayoutManager(new LinearLayoutManager(this));*/
//String UID=cUser.getUid();
//mUsersDatabase=FirebaseDatabase.getInstance().getReference().child("Users").child(UID);

  /*  musersList.setAdapter(new Programming_adapter("pooja","hi"));
    System.out.println(cUser.getUid()+"****************");
        System.out.println(cUser.getEmail()+"****************");
        System.out.println(cUser.getDisplayName()+"****************");

    }
    }
*/
//    @Override
//    public void onStart() {
//        super.onStart();
//
//    }


//    public class UsersViewHolder extends RecyclerView.ViewHolder{
//
//        View mView;
//        public UsersViewHolder(View itemView) {
//            super(itemView);
//            mView=itemView;
//        }
//
//
//    public void setName(String name)
//    {
//        TextView userNameView=(TextView)mView.findViewById(R.id.user_singleName);
//        userNameView.setText(name);
//    }
//}
