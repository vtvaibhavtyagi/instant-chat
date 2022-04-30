//package com.my.myapplication;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//public class Programming_adapter extends RecyclerView.Adapter<Programming_adapter.programmingViewHolder> {
//
//    private static String name;
//    private static String status;
//Users users;
//    public Programming_adapter(String name, String status) {
//        this.name=name;
//        this.status=status;
//    }
//
////    public void programming_adapter(String name,String status)
////    {
////           this.name=name;
////           this.status=status;
////    }
//
//    @NonNull
//    @Override
//    public programmingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
//        View view=inflater.inflate(R.layout.users_single,parent,false);
//        return new programmingViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull programmingViewHolder holder, int position) {
//        // String title=name;
//         holder.userNameView.setText(users.getName());
//         System.out.println("in pa***************name*****"+users.getName());
//        holder.userNameView.setText(users.getStatus());
//        System.out.println("in pa**************status"+users.getStatus());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 3;
//    }
//
//    public static class programmingViewHolder extends RecyclerView.ViewHolder {
//        View mView;
//        private TextView userNameView;
//        private TextView userStatusView;
//        public programmingViewHolder(View itemView) {
//            super(itemView);
//             mView=itemView;
//            TextView userNameView=(TextView)mView.findViewById(R.id.user_singleName);
//            userNameView.setText(name);
//            TextView userStatusView=(TextView)mView.findViewById(R.id.user_singleStatus);
//            userStatusView.setText(status);
//
//        }
//    }
//
//
//
//}
