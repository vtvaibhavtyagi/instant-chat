package com.my.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class all_users extends AppCompatActivity {

    ListView l1;
    ArrayAdapter<String> adapter;
    String defaultitems[] = new String[]{"name", "password", "status"};
    DatabaseReference databaseReference;
    Users info;
    List<String> itemlist;
    public int c=0;
    public String user_name1[]=new String[100];
    public String user_status1[]=new String[100];
    public String user_key1[]=new String[100];
    public String name1;
    public FirebaseAuth firebaseAuth;
    public String user_id;
    @Nullable

    public String options[]={"Open profile","Send message"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users2);
        l1 = findViewById(R.id.listview);


        itemlist = new ArrayList<>();
        c = 0;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlist.clear();
                Map<String, Object> map = (HashMap<String, Object>) dataSnapshot.child("Users").getValue();
                for ( String key3 : map.keySet() ) {
                    user_key1[c]=key3 ;
                    System.out.println(key3);
                    c=c+1;
                }

                c=0;
                Map<String, Object> map2 = (HashMap<String, Object>) dataSnapshot.child("Users").getValue();
                assert map2 != null;
                for (String key : map2.keySet()) {
                    user_name1[c] = (String) dataSnapshot.child("Users").child(key).child("name").getValue();
                    user_status1[c] = (String) dataSnapshot.child("Users").child(key).child("status").getValue();
                    itemlist.add(user_name1[c]);
                    itemlist.add(user_status1[c]);
                    c = c + 1;
                }
                //adapter = new ArrayAdapter<>(all_users.this, android.R.layout.simple_list_item_1, itemlist);

                CustomAdapter customAdapter=new CustomAdapter();
                l1.setAdapter(customAdapter);
                  registerOnClick();

                //l1.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "There is some error", Toast.LENGTH_LONG).show();
            }
        });

    }


    private void registerOnClick() {
        l1 = findViewById(R.id.listview);
          l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                  RelativeLayout message=(RelativeLayout)viewClicked;
                  user_id=user_key1[position];
                  name1=user_name1[position];
                  //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+user_id);

                  AlertDialog.Builder builder=new AlertDialog.Builder(all_users.this);
                  builder.setTitle("Select Options");
                  builder.setItems(options, new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          assert options != null;
                          if(which==0)
                          {Intent w=new Intent(all_users.this,ProfileActivity.class);
                              w.putExtra("idf",user_id);
                              startActivity(w);
                          }
                          else if(which==1)
                          {
                              Intent w1=new Intent(all_users.this,ChatPage.class);
                              w1.putExtra("idf1",user_id);
                              w1.putExtra("name1",name1);
                              startActivity(w1);
                          }
                      }
                  });
                  AlertDialog alertDialog=builder.create();
                  alertDialog.show();
              }
          });
    }


    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return c;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view=getLayoutInflater().inflate(R.layout.users_single,null);
            TextView user_name=(TextView)view.findViewById(R.id.user_singleName);
            TextView user_status=(TextView)view.findViewById(R.id.user_singleStatus);
            user_name.setText(user_name1[position]);
            user_status.setText(user_status1[position]);
            return view;
        }

    }
}
