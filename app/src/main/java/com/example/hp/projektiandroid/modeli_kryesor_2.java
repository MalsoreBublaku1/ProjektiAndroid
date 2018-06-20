package com.example.hp.projektiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.projektiandroid.explore.ExploreModel;
import com.example.hp.projektiandroid.explore.ExploreModelid;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    TextView bedR;
    TextView bathR;
    TextView nights;
    CalendarPickerView clP;

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
        //clnV=findViewById(R.id.calendar1);
        bedR = findViewById(R.id.numriBedrooms);
        bedR.setText(ft.getNoOfBedR());
        bathR = findViewById(R.id.nrBathrooms);
        bathR.setText(ft.getNoOfBathR());
        nights = findViewById(R.id.nightMin);
        nights.setText(ft.getNights());
        System.out.println("Data"+ft.getDate());
        String konvertoDaten=ft.getDate();





       //clnV.setDate()







        clP = (CalendarPickerView) findViewById(R.id.calendar_view);
//getting current
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Date today = new Date();

//add one year to calendar from todays date
        clP.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE);



//

//

        List<String> lista=ft.getList();
        List<String>lista2=new ArrayList<>();
        System.out.println("Te lista");
        for(int i=0;i<lista.size();i++)
        {

            System.out.println("Elementet e listes:"+lista.get(i).toString());
        }






        //Date date;

        List<String> dateStringList = new ArrayList<String>();//lista
        List<Date> dateList = new ArrayList<Date>();

        dateStringList.add("2018-06-21");//
        dateStringList.add("2018-06-22");//

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");

        for (String dateString : lista) {
            try {
                dateList.add(simpleDateFormat.parse(dateString));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        for (Date date : dateList) {
            System.out.println("Date " + simpleDateFormat.format(date));
        }




        clP.highlightDates(dateList);


        clP.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //skena hiq nevoje per Listener
              //  Toast.makeText(getApplicationContext(),"Selected Date is : " +date.toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDateUnselected(Date date) {

               // Toast.makeText(getApplicationContext(),"UnSelected Date is : " +date.toString(),Toast.LENGTH_SHORT).show();
            }
        });









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
