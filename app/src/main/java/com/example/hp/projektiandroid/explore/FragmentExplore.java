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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
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
    EditText search;
    static String dateis = "";
    static String noOfGuests = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_explore, container, false);//hapet explore
        FragmentHome fragmentHome = new FragmentHome();
        openFragment(fragmentHome);//hapet fragmenti Home
        //per search
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.equals("") && !s.equals(null)) {
                    FragmentHome fragmentHome = new FragmentHome();
                    Bundle bundle = new Bundle();
                    String search_word = s.toString();//e marrim fjalen e shkuruar ne search

                    bundle.putString("search", search_word);//dergohet me key-search
                    fragmentHome.setArguments(bundle);
                    openFragment(fragmentHome);
                }
                else
                {
                    FragmentHome fragmentHome = new FragmentHome();
                    openFragment(fragmentHome);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.btnGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getContext());//hapet dialogu per me i marr numrin e guests
            }
        });

        binding.firstPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentHome();
                openFragment(fragment);//per homes
            }
        });
        binding.secondPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentRestaurant();
                openFragment(fragment);//per restaurents

            }
        });
        binding.btnDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDates(getContext());//per me e  marr daten qe po dojna me search
            }

        });
        return binding.getRoot();


    }




//per hapjen e te gjitha fragmenteve
    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, fragment);
        fragmentTransaction.commit();
    }

    //-----------------------GUESTS DIALOGU------------------------------
    private void openDialog(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_dialog_guest);
        final Spinner sp;

        sp = (Spinner) dialog.findViewById(R.id.spinnerGuests);


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noOfGuests = sp.getSelectedItem().toString();//me marr numrin e guests
             //   Toast.makeText(getContext(), noOfGuests, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        noOfGuests = sp.getSelectedItem().toString();
        //kur butoni te klikohet dergojna bundle te fragmenti Homes me key guests edhe parameter noOf guests
        Button btn = dialog.findViewById(R.id.searchbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("Number of gustes" + noOfGuests);
                FragmentHome fragment = new FragmentHome();
                Bundle bundle = new Bundle();
                bundle.putString("guests", noOfGuests);//me dergu bundle me key  guests
                fragment.setArguments(bundle);
                openFragment(fragment);
                dialog.dismiss();

            }
        });


        noOfGuests = sp.getSelectedItem().toString();


        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();


    }
    //-----------------------------------GUESTS----------------------------------------------





    private void openDialogDates(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_calendar);


        Button btn = dialog.findViewById(R.id.saveDates);
        final CalendarView calendarView = dialog.findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int month1 = month + 1;
                String f="";
//bone gjithe me mujin qershor
                if(month1==6) {
                f="Jun";
                }
                dateis = dayOfMonth + "/" + f + "/" + year;




                System.out.println("Te dialogu data" + dateis);

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
