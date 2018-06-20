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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FragmentHome extends Fragment {
    static FragmentHomeBinding binding;
    static ExploreAdapter adapter;
    static Context c;
    static ArrayList<ExploreModelid> fotot_texti;


    FirebaseDatabase FDB;
    DatabaseReference DBR;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_home, container, false);//u thirr fragmenti home
        c = container.getContext();
        //per firebase
        FDB = FirebaseDatabase.getInstance();
        DBR = FDB.getReference("TabelaExplore");//per tabelen explore

        fotot_texti = new ArrayList<>();

        adapter = new ExploreAdapter(c, fotot_texti);

        binding.homesRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));

        Bundle bundle = this.getArguments();
//pranimi i te gjithe bundles
        if (bundle != null) {
            System.out.println("Erdhi bundle");
            String guests = bundle.getString("guests", "0");//pranimi i bundles per guest
            String data = bundle.getString("dates", "nodata");//pranimi i bundle per dates
            String search = bundle.getString("search", "nosearch");//pranimi i bundle per search


            if (!guests.equals("0")) {
                getDataFirebaseGuests(guests);//merre numrin e guests
            } else if (!data.equals("nodata")) {
                System.out.println("date ne fragmentHome "+data);
                getDataFirebaseDates(data);
            } else if (!search.equals("nosearch")) {
                //System.out.println("U thirr search");
                getDataFirebaseSearch(search);
            }
          //
            //
            //Toast.makeText(getContext(), "Erdh info guests" + guests + " data" + data+ "search "+search, Toast.LENGTH_SHORT).show();

        } else {
            System.out.println("Nuk eshte thirrur search");
            getDataFirebase();//i qet pa filtrime
        }


        return binding.getRoot();
    }


    void getDataFirebase() {


        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                em =dataSnapshot.getValue(ExploreModel.class);
                ExploreModelid ex = new ExploreModelid(dataSnapshot.getKey(), em.getNoOfBeds(), em.name, em.getLocation(), em.cmimi, em.getFotojaURL(), em.getNoOfGuests(), em.getDate(), em.getTipi(),em.getNoOfBedR(), em.getNoOfBathR(), em.getNights(), em.isSaved,em.getLista());
                fotot_texti.add(ex);


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


    //per data
    void getDataFirebaseDates(final String date) {

        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                em = dataSnapshot.getValue(ExploreModel.class);
                ExploreModelid ex = new ExploreModelid(dataSnapshot.getKey(), em.getNoOfBeds(), em.name, em.getLocation(), em.cmimi, em.getFotojaURL(), em.getNoOfGuests(), em.getDate(), em.getTipi(),em.getNoOfBedR(), em.getNoOfBathR(), em.getNights(), em.isSaved,em.getLista());


                List<String>lista=em.getLista();
                List<String>lista1=new ArrayList<>();

               for(int i=0;i<lista.size();i++)
               {
                   SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");

                   Date convertedDate = new Date();
                   try {
                       convertedDate = dateFormat.parse(lista.get(i));
                       SimpleDateFormat sdfnewformat = new SimpleDateFormat("dd/MMM/yyyy");
                       String finalDateString = sdfnewformat.format(convertedDate);
                       lista1.add(finalDateString);
                   } catch (ParseException e) {
                       e.printStackTrace();
                   }


                  // System.out.println("Elementet e listes:"+lista.get(i));
                   System.out.println("Elementet e lists 1 jane:"+lista1.get(i));

               }
                System.out.println("Madhesia:"+lista1.size());


























                if(lista1.contains(date))
                {
                    System.out.println("PO E PERMBAN");
                    fotot_texti.add(ex);
                }
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


//-----------------------------------------------PARAQITJA E FRAGMENT HOME ME NUMB OF GUESTS TE KERKUARA---------------------------

    void getDataFirebaseGuests(final String numGuests) {


        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                //i marrim qeto t dhena prej explore modelit
                em = dataSnapshot.getValue(ExploreModel.class);
                //qeto te dhena fillimisht shtohen ne db
                ExploreModelid ex = new ExploreModelid(dataSnapshot.getKey(), em.getNoOfBeds(), em.getName(), em.getLocation(), em.getCmimi(), em.getFotojaURL(), em.getNoOfGuests(), em.getDate(), em.getTipi(),em.getNoOfBedR(), em.getNoOfBathR(), em.getNights(), em.getSaved(),em.getLista());

                if (em.getNoOfGuests().equals(numGuests)) {
                    fotot_texti.add(ex);
                }

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

    //----------------per paraqitjen e itemave qe e plotesojne kushtin e searchit----------------------------

    void getDataFirebaseSearch(final String search) {


        DBR.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ExploreModel em = new ExploreModel();
                em = dataSnapshot.getValue(ExploreModel.class);
                ExploreModelid ex = new ExploreModelid(dataSnapshot.getKey(), em.getNoOfBeds(), em.name, em.getLocation(), em.cmimi, em.getFotojaURL(), em.getNoOfGuests(), em.getDate(), em.getTipi(),em.getNoOfBedR(), em.getNoOfBathR(), em.getNights(), em.isSaved,em.getLista());
                String search_string=search.toLowerCase();
                //qetu percaktohet ne baze te qka me u bo search psh ktu ekem bo search ne baze te datas,lokacionit,qmimit,emrit
                if (ex.getDate().toLowerCase().contains(search_string) || ex.getLocation().toLowerCase().contains(search_string) || ex.getName().toLowerCase().contains(search_string) || ex.getCmimi().toLowerCase().contains(search_string)) {
                    fotot_texti.add(ex);
                }

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

