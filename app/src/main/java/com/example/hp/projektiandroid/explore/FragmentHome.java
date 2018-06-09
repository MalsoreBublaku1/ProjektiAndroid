package com.example.hp.projektiandroid.explore;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.projektiandroid.R;
import com.example.hp.projektiandroid.databinding.FragmentHomeBinding;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by HP on 5/13/2018.
 */

public class FragmentHome extends Fragment {
    static FragmentHomeBinding binding;
    static ExploreAdapter adapter;
    static Context c;
    static ArrayList<ExploreModel> fotot_texti;
    FirebaseDatabase FDB;
    DatabaseReference DBR;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_home, container, false);
        c = container.getContext();

        binding.homesRecycle.setLayoutManager(new GridLayoutManager(c, 2));
       // binding.homesRecycle.setAdapter(adapter);
        FDB= FirebaseDatabase.getInstance();

        DBR=FDB.getReference("TabelaExplore");

        fotot_texti=new ArrayList<>();
        adapter = new ExploreAdapter(c, fotot_texti);
        getDataFirebase();



        return binding.getRoot();
    }


    void getDataFirebase()
    {



        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                em=dataSnapshot.getValue(ExploreModel.class);
                fotot_texti.add(em);
                binding.homesRecycle.setAdapter(adapter);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}

