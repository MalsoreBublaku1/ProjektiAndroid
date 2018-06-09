package com.example.hp.projektiandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class profile extends Fragment {
    FirebaseAuth mAuth;
    Context c;
    TextView txt1;

    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        txt1 = (TextView) view.findViewById(R.id.emriUserAktiv);
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
        String name, email, photoUrl, uid, emailVerified;
        if (user != null) {

            Toast.makeText(getContext(),"user aktiv",Toast.LENGTH_LONG).show();
            name=user.getDisplayName();
            Toast.makeText(getContext(),name,Toast.LENGTH_LONG).show();



            }


        }


    }

