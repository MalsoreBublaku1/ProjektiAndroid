package com.example.hp.projektiandroid.explore;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        FDB= FirebaseDatabase.getInstance();
        DBR=FDB.getReference("TabelaExplore");

        fotot_texti=new ArrayList<>();
        adapter = new ExploreAdapter(c, fotot_texti);
        binding.homesRecycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            System.out.println("Erdh inggoo");
            String guests = bundle.getString("guests", "0");
            String data = bundle.getString("dates", "nodata");
            if(!guests.equals("0"))
            {
                getDataFirebaseGuests(guests);
            }
            else if(!data.equals("nodata"))
            {
                getDataFirebaseDates(data);
            }
            Toast.makeText(getContext(),"Erdh info guests"+guests+" data"+data,Toast.LENGTH_SHORT).show();

        }
        else
        {
            System.out.println("Nuk eshte thirrur search");
            getDataFirebase();
        }





        return binding.getRoot();
    }


    void getDataFirebase()
    {



        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em=new ExploreModel();
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
    void getDataFirebaseDates(final String date)
    {

        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em=new ExploreModel();
                em=dataSnapshot.getValue(ExploreModel.class);
                if(em.getDate().equals(date)){
                    fotot_texti.add(em);}

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

    void getDataFirebaseGuests(final String numGuests)
    {



        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em=new ExploreModel();
                em=dataSnapshot.getValue(ExploreModel.class);
                if(em.getNoOfGuests().equals(numGuests)){
                fotot_texti.add(em);}

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

