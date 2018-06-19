package com.example.hp.projektiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.projektiandroid.explore.ExploreModel;
import com.example.hp.projektiandroid.explore.ExploreModelid;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class modeli_kryesor_2 extends AppCompatActivity {
    TextView tipi;
    CalendarView clnV;
    FirebaseDatabase db;
    DatabaseReference dataref;
    ExploreModelid ft;
    Button button;
    TextView pershkrimi;
    TextView lokacioni;
    ImageView img;
    TextView cmimi;
    TextView guests;
    TextView beds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeli_kryesor_2);
        //veq me identifiku MyClass
        //per me i pranu te dhenat qe na vine prej adapterit
         ft = (ExploreModelid) getIntent().getSerializableExtra("MyClass");
      //ne qete pjese ki krejt te dhenat ne exploremodelid veq i qet neper textboxa

        tipi = findViewById(R.id.tipi);
        tipi.setText(ft.getTipi());
        pershkrimi=findViewById(R.id.pershkrimi1);
        pershkrimi.setText(ft.getName());
        lokacioni=findViewById(R.id.lokacioni);
        lokacioni.setText(ft.getLocation());
        img=findViewById(R.id.imgV1);
        Picasso.get().load(ft.getFotojaURL()).into(img);
        cmimi=findViewById(R.id.cmimi1);
        cmimi.setText(ft.getCmimi());
        guests=findViewById(R.id.numriGuests);
        guests.setText(ft.getNoOfGuests());
        beds=findViewById(R.id.numriBeds);
        beds.setText(ft.getNoOfBeds());
        clnV=findViewById(R.id.calendar1);
        System.out.println("Data"+ft.getDate());
        String konvertoDaten=ft.getDate();



        String[] dateArray = konvertoDaten.split("/");

        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);

       //clnV.setDate()


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long milliTime = calendar.getTimeInMillis();
        clnV.setDate (milliTime, true, true);









        //clnV.setDate(ft.getDate());










        button=findViewById(R.id.save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();//per update te te dhenave
            }
        });


    }

    private void updateData() {
        //sa here qe te klikohet butoni save vlera ne database e isSaved ndryshon nga false ne true kjo na tregon qe kemi me kalu
        //explore itemin ne aktivitet t ri.
        db = FirebaseDatabase.getInstance();
        dataref = db.getReference();
        dataref.child("TabelaExplore").child(ft.getId()).child("isSaved").setValue(true);

    }
}
