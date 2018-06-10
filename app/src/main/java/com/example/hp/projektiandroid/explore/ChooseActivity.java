package com.example.hp.projektiandroid.explore;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.projektiandroid.R;
import com.example.hp.projektiandroid.explore.ExploreModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;


public class ChooseActivity extends AppCompatActivity {
    Spinner spinner, spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter,adapter1,adapter2,adapter3,adapter4;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnNext1;
    static String noOfBeds="";
    static String noOfGuests="";
    static Context c;
    static String url="";
    DatabaseReference databaseReference;

    //variablat per foto
    private Button btnChoose,btnUpload;
    private ImageView imageView;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST =71;

    //Firebase
    FirebaseStorage storage;
    StorageReference storageReference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Spinner spinner3;
        final Spinner spinner4;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        //first spinner(drop down list)
        spinner =(Spinner) findViewById(R.id.spinner);




        btnNext1=(Button)findViewById(R.id.btnNext);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("TabelaExplore");





        adapter = ArrayAdapter.createFromResource(this,R.array.homes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
                String homes_restaurants=parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(),"HR="+homes_restaurants,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //second spinner (drop down list)
        spinner1 =(Spinner) findViewById(R.id.spinner1);
        adapter1 = ArrayAdapter.createFromResource(this,R.array.pyetja2,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
                String property_type=parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //third spinner(drop down list)
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.guests,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);





        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String guests_have=parent.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(),guests_have,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3=(Spinner)findViewById(R.id.spinner3);
        adapter3 = ArrayAdapter.createFromResource(this,R.array.noOfBeds,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noOfBeds=spinner3.getSelectedItem().toString();
                Toast.makeText(getBaseContext(),noOfBeds,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        noOfBeds=spinner3.getSelectedItem().toString();
        System.out.println("numri i shtreterve:"+noOfBeds);


        spinner4=(Spinner)findViewById(R.id.spinner4);
        adapter4 = ArrayAdapter.createFromResource(this,R.array.noOfGuests,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noOfGuests=spinner4.getSelectedItem().toString();
                Toast.makeText(getBaseContext(),noOfGuests,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        noOfGuests=spinner4.getSelectedItem().toString();

//ketu shtohetn te dhenat ne databaze
        System.out.println("No of Beds ne 1 "+noOfBeds);
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExploreModel em=new ExploreModel("Malsore","Kosova","20euro",noOfBeds+" beds",url,noOfGuests);
                // addnew(em)
                System.out.println("No of beds:"+noOfBeds);
                //System.out.println("mesazhi shkoj");
                ShtoTeDhenat(em);
            }
        });





        //Firebase innit
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        //Init view
        btnChoose = (Button)findViewById(R.id.btnChoose);
        btnUpload = (Button)findViewById(R.id.btnUpload);
        imageView = (ImageView)findViewById(R.id.imgView);

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }
//
    private void uploadImage() {
        if(filePath != null){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            url=taskSnapshot.getDownloadUrl().toString();
                            Toast.makeText(ChooseActivity.this,"Uploaded",Toast.LENGTH_LONG).show();
                            //databaseReference.push().setValue(url);

                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(ChooseActivity.this,"Failed"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }

    }


    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() !=null){
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e){
                e.printStackTrace();

            }
        }


















    }
    public void checkedButton(View v){
        radioGroup = (RadioGroup)findViewById(R.id.radioG);
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);

        //Toast.makeText(this,"Selected radio button:"+ radioButton,Toast.LENGTH_LONG).show();
    }



    public void ShtoTeDhenat(ExploreModel model) {


        databaseReference.push().setValue(model);
    }
}