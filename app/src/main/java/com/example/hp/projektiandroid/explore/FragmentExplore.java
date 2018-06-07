package com.example.hp.projektiandroid.explore;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.projektiandroid.R;
import com.example.hp.projektiandroid.databinding.FragmentExploreBinding;


public class FragmentExplore extends Fragment {

    FragmentExploreBinding binding;
    ExploreAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_explore, container, false);

        binding.firstPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentHome();
                openFragment(fragment);
            }
        });
        binding.secondPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentRestaurant();
                openFragment(fragment);

            }
        });
        binding.btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogu=new AlertDialog.Builder(getContext());
                View view1=getLayoutInflater().inflate(R.layout.activity_calendar,null);
                dialogu.setView(view1);
                AlertDialog dialogu2=dialogu.create();
                dialogu2.show();
            }

        });
        return binding.getRoot();


    }



    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, fragment);
        fragmentTransaction.commit();
    }


}
