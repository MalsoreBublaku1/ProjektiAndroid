package com.example.hp.projektiandroid.explore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.projektiandroid.R;
import com.example.hp.projektiandroid.databinding.FragmentExploreBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FragmentExplore extends Fragment {

    FragmentExploreBinding binding;
    ExploreAdapter adapter;
    static String dateis = "";
    static String noOfGuests = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_explore, container, false);
        FragmentHome fragmentHome=new FragmentHome();
        openFragment(fragmentHome);

        binding.btnGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getContext());
            }
        });

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
                openDialogDates(getContext());
            }

        });
        return binding.getRoot();


    }


    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, fragment);
        fragmentTransaction.commit();
    }

    private void openDialog(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_dialog_guest);
        final Spinner sp;

        sp = (Spinner) dialog.findViewById(R.id.spinnerGuests);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noOfGuests = sp.getSelectedItem().toString();
                Toast.makeText(getContext(), noOfGuests, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        noOfGuests = sp.getSelectedItem().toString();
        Button btn=dialog.findViewById(R.id.searchbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Number of gustes"+noOfGuests);
                FragmentHome fragment = new FragmentHome();
                Bundle bundle = new Bundle();
                bundle.putString("guests", noOfGuests);
                fragment.setArguments(bundle);
                openFragment(fragment);
                dialog.dismiss();

            }
        });

        noOfGuests = sp.getSelectedItem().toString();


        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();


    }
    private void openDialogDates(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_calendar);



        Button btn=dialog.findViewById(R.id.saveDates);
        final CalendarView calendarView=dialog.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int month1=month+1;
                dateis = dayOfMonth + "/" + month1 + "/" + year;
                System.out.println("Te dialogu data"+dateis);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Butoni u klikua");
                FragmentHome fragment = new FragmentHome();
                Bundle bundle = new Bundle();
                bundle.putString("dates", dateis);
                fragment.setArguments(bundle);
                openFragment(fragment);
                dialog.dismiss();

            }
        });




        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();


    }

}
