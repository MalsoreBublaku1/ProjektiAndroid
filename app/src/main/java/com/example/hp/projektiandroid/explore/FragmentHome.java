package com.example.hp.projektiandroid.explore;

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

import java.util.ArrayList;

/**
 * Created by HP on 5/13/2018.
 */

public class FragmentHome extends Fragment {
    FragmentHomeBinding binding;
    ExploreAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_home, container, false);
        adapter = new ExploreAdapter(getContext(), merrTeDhenat());

        binding.homesRecycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.homesRecycle.setAdapter(adapter);
        return binding.getRoot();
    }

    private ArrayList<ExploreModel> merrTeDhenat() {

        ArrayList<ExploreModel> fotot_texti = new ArrayList<>();
        fotot_texti.add(new ExploreModel("Loft Studio in the Central Area", R.mipmap.fotoja, "Moscow, Russia", "187 US$ per night"));
        fotot_texti.add(new ExploreModel("Loft Studio in the Central Area", R.mipmap.foto0, "Moscow, Russia", "187 US$ per night"));
        fotot_texti.add(new ExploreModel("Loft Studio in the Central Area", R.mipmap.foto03, "Moscow, Russia", "187 US$ per night"));
        fotot_texti.add(new ExploreModel("Loft Studio in the Central Area", R.mipmap.foto1, "Moscow, Russia", "187 US$ per night"));

        return fotot_texti;

    }
}

