package com.example.hp.projektiandroid;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.hp.projektiandroid.explore.FragmentExplore;
import com.example.hp.projektiandroid.databinding.ActivityKryesoreBinding;

public class Kryesore extends AppCompatActivity {

    private RecyclerView recyclerView;
    //deklaroimi i array me foto


    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityKryesoreBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_kryesore);
        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bnv.setOnNavigationItemSelectedListener(navigationL);

        fragment = new FragmentExplore();
        openFragment(fragment);

//        binding.chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               fragment=new FragmentInbox();
//               openFragment(fragment);
//            }
//        });


    }


    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


    //kodi per me  i selektu items ne bottom navigation bar edhe per me i shfaq fragmentet
    //njejte si me kriju ma nalt ne vend te navigationL me new Bottom.....
    private BottomNavigationView.OnNavigationItemSelectedListener navigationL =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragmentiSelektuar = null;

                    switch (item.getItemId()) {
                        case R.id.nav_explore:
                            fragmentiSelektuar = new FragmentExplore();
                            break;
                        case R.id.nav_fav:
                            fragmentiSelektuar = new FragmentSave();
                            break;
                        case R.id.nav_chat:
                            fragmentiSelektuar = new FragmentInbox();
                            break;

                    }

                    /*
//                    * per me startu fragmenti nevojitet klasa FragmentManager
//                    * njejte si me shkru
//                    * FragmentManager fragmentManger=getFragmentManager;
//                    * FragmentTransaction ft=fragmentManager.beginTransaction();
//                    * FragmentExplore fe=new FragmentExplore();
//                    * ft.add(R.id.fragment_container,FragmentiExplore);
//                    * ft.commit();
//                    * krijohet nje metode me ListenerEvent edhe ne kuader te public void onClick
//                    * krijohet prap objekti i FragmentManager,FragmentTransaction
//                    * edhe vendoset ft.replace(R.id.Fragment_contanier,FragmentSave),ku mas pari krijohet instanca per
//                    * FragmentSave
//                    * */
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentiSelektuar).commit();
//
                    return true;//true sepse deshirojna me selektu itemin,nese false itemi nuk do te selektohej
//
//                }
//            };
                }
            };
}

