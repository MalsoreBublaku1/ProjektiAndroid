package com.example.hp.projektiandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by HP on 5/8/2018.
 */

public class FragmentInbox extends Fragment {

 profileAdapter adapter1;
 private RecyclerView rcv;
 Context c=getContext();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inbox,container,false);
        adapter1 = new profileAdapter(getContext(), merrTeDhenat1());


        rcv=(RecyclerView)view.findViewById(R.id.profileRec);
        rcv.setAdapter(adapter1);
       rcv.setLayoutManager(new LinearLayoutManager(c));
        return view;//per me kthy fragmentin



    }

    private ArrayList<ProfileModel1> merrTeDhenat1() {

        ArrayList<ProfileModel1> strings = new ArrayList<>();
        strings.add(new ProfileModel1("List your space"));
        strings.add(new ProfileModel1("Log out"));
        strings.add(new ProfileModel1("Give us feedback"));
        strings.add(new ProfileModel1("Settings"));

        return strings;

    }







}
