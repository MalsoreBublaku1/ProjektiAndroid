package com.example.hp.projektiandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.projektiandroid.explore.ExploreAdapter;
import com.example.hp.projektiandroid.explore.ExploreModel;
import com.example.hp.projektiandroid.explore.ExploreModelid;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by HP on 5/8/2018.
 */

public class FragmentSave extends Fragment {
    static ExploreAdapter adapter;
    static Context c;
    static ArrayList<ExploreModelid> fotot_texti;
    RecyclerView saved_recycle;


    FirebaseDatabase FDB;
    DatabaseReference DBR;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved,
                container, false);

        c = container.getContext();
        //per firebase
        FDB = FirebaseDatabase.getInstance();
        DBR = FDB.getReference("TabelaExplore");//per tabelen explore

        fotot_texti = new ArrayList<>();
        adapter = new ExploreAdapter(c, fotot_texti);
        saved_recycle = view.findViewById(R.id.saved_recycle);
        saved_recycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
        getDataFirebase();
        return view;

    }

    void getDataFirebase() {


        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                em = dataSnapshot.getValue(ExploreModel.class);
                ExploreModelid ex = new ExploreModelid(dataSnapshot.getKey(), em.getNoOfBeds(), em.getName(), em.getLocation(), em.getCmimi(), em.getFotojaURL(), em.getNoOfGuests(), em.getDate(), em.getTipi(), em.getSaved());
                if (ex.getSaved()) {
                    fotot_texti.add(ex);
                }

                saved_recycle.setAdapter(adapter);

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
