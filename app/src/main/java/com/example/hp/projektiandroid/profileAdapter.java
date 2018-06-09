package com.example.hp.projektiandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by HP on 6/8/2018.
 */



public class profileAdapter extends RecyclerView.Adapter<profileAdapter.ViewHolder> {


    Context c;//
    ArrayList<ProfileModel1> strings;//
    FirebaseAuth mAuth;

    public profileAdapter(Context c, ArrayList<ProfileModel1> strings)//konstruktori me ni parameter array
    {
        this.c = c;
        this.strings = strings;//asocimi i vlerave
    }








    @NonNull
    @Override





    public profileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_profile_model, parent, false);
        ViewHolder ViewHolder = new ViewHolder(view);

        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull profileAdapter.ViewHolder holder, int position) {

        ProfileModel1 ft = strings.get(position);

        holder.tv1.setText(ft.getPershkrimi());
        holder.img1.setImageResource(ft.getImage());
            if(holder.tv1.getText().equals(" Log out")) {
                holder.tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(c, MainActivity.class);
                        c.startActivity(intent);


                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder {

        /*This constructor will take the parent View of the item layout allowing you to
         setup any views you will need to use when displaying your data. */
        TextView tv1;
        ImageView img1;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.item);
            img1=itemView.findViewById(R.id.profileIV);


        }
    }


}
