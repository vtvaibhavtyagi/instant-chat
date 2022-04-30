package com.my.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class ChatAct extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTabLayout;
public String name_original;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);





        mViewPager=(ViewPager)findViewById(R.id.main_tabPager);
        mSectionsPagerAdapter =new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout=(TabLayout)findViewById(R.id.main_tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch (id) {
            case R.id.settings:
                Intent l = new Intent(ChatAct.this, SettingsActivity.class);
                startActivity(l);
                  break;
            case R.id.allUsers:
                Intent v = new Intent(ChatAct.this, all_users.class);
                startActivity(v);
                break;
            case R.id.Logo:
                FirebaseAuth.getInstance().signOut();
                sendToStart();
        }
      return true;
    }

    public void sendToStart()
    {
        Intent h=new Intent(ChatAct.this,Main2Activity.class);
        startActivity(h);
        finish();
    }
}
