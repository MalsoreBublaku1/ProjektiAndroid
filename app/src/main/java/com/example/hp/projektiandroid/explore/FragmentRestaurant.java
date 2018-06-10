package com.example.hp.projektiandroid.explore;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.projektiandroid.R;
import com.example.hp.projektiandroid.databinding.FragmentRestaurantBinding;



public class FragmentRestaurant extends Fragment {
    FragmentRestaurantBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_restaurant, container, false);
        return binding.getRoot();
    }
}
