//package com.my.myapplication;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class personListAdapter extends ArrayAdapter<Users> {
//    private static final String TAG="personListAdapter";
//    private Context mContext;
//
//    public personListAdapter(@NonNull Context context, int resource, @NonNull Users[] objects) {
//        super(context, resource, objects);
//    }
//
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        String name=getItem(position).getName();
//        LayoutInflater inflater=LayoutInflater.from(mContext);
//    }
//}
