package com.example.hp.projektiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.projektiandroid.explore.ExploreModel;
import com.example.hp.projektiandroid.explore.ExploreModelid;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class modeli_kryesor_2 extends AppCompatActivity {
    TextView tipi;
    FirebaseDatabase db;
    DatabaseReference dataref;
    ExploreModelid ft;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeli_kryesor_2);
        //veq me identifiku MyClass
         ft = (ExploreModelid) getIntent().getSerializableExtra("MyClass");
      //ne qete pjese ki krejt te dhenat ne exploremodelid veq i qet neper textboxa

        tipi = findViewById(R.id.tipi);
        tipi.setText(ft.getId());
        button=findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });


    }

    private void updateData() {
        db = FirebaseDatabase.getInstance();
        dataref = db.getReference();
        dataref.child("TabelaExplore").child(ft.getId()).child("isSaved").setValue(true);

    }
}
