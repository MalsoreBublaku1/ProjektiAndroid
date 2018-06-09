package com.example.hp.projektiandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;


public class profile extends Fragment {
    FirebaseAuth mAuth;
    Context c;
    TextView txt1;
    private Firebase mRef;
    DatabaseReference databaseReference;
    ImageView imv;



    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();

        View view = inflater.inflate(R.layout.fragment_profile, container, false);




        txt1 = (TextView) view.findViewById(R.id.emriUserAktiv);
        imv=(ImageView)view.findViewById(R.id.imageView);
        loadUserInformation();
        return view;


    }


    @Override
    public void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(c, MainActivity.class);
            c.startActivity(intent);
        }


    }


    private void loadUserInformation() {
        final FirebaseUser user = mAuth.getCurrentUser();
        String name;
        if (user != null) {


            name=user.getDisplayName();
            txt1.setText(name);





            }


        }




















    }

