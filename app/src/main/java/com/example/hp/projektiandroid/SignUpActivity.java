package com.example.hp.projektiandroid;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import com.example.hp.projektiandroid.explore.RuajTeDhenat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView TV1;
    private Button btn1;
    private Toolbar toolbar1;

    EditText editTextFirstName, editTextLastName, editTextPassword, editTextEmail, editTextConP;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    DatabaseReference databaseReference;

    ProgressBar pb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //toolbar1=(Toolbar)findViewById(R.id.tb1);
        //setSupportActionBar(toolbar1);
        TV1 = (TextView) findViewById(R.id.tvLogin);
        //TV1.setOnClickListener(SignUpActivity.this);
        //  btn1=(Button) findViewById(R.id.btnSignUp);
        // btn1.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
        //     btn1.setBackground(getResources().getDrawable(R.drawable.button_border));
        //  Intent intent1=new Intent("welcome-filter");
        // startActivity(intent1);


        //}
        //});
        editTextFirstName = (EditText) findViewById(R.id.tvFirstName);
        editTextLastName = (EditText) findViewById(R.id.tvLastName);
        editTextEmail = (EditText) findViewById(R.id.tvEmail);
        editTextPassword = (EditText) findViewById(R.id.tvPassord);
        editTextConP = (EditText) findViewById(R.id.etConfirm);
        //progressBar = (ProgressBar) findViewById(R.id.progressB1);
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        findViewById(R.id.btnSignUp).setOnClickListener(this);
    }

    public void ShtoTeDhenat() {
        String emri = editTextFirstName.getText().toString().trim();
        String mbiemri = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String pass = editTextPassword.getText().toString().trim();
        RuajTeDhenat ruajTeDhenat = new RuajTeDhenat(emri, mbiemri, email, pass);
        databaseReference.push().setValue(ruajTeDhenat);
    }

    private void registerUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String conP = editTextConP.getText().toString().trim();


        if (email.isEmpty()) {
            editTextEmail.setError("Email is Required!");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is Required!");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Minimum length is 6!");
            editTextPassword.requestFocus();
            return;
        }
         if(!conP.equals(password)){
           editTextConP.setError("Write again");
           editTextConP.requestFocus();
        return;
         }
       // progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               // progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(SignUpActivity.this, Welcome_Activity.class));
                    Toast.makeText(getApplicationContext(), "User Registred Succesfully", Toast.LENGTH_SHORT).show();
                    TextView tv=(TextView)findViewById(R.id.tvFirstName);
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String displayName="";
                    displayName=tv.getText().toString();

                    UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                            .setDisplayName(displayName).build();

                    //per update te profilit
                    user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();
                        }
                    });



                } else {
                    Toast.makeText(getApplicationContext(), "Some Error Ocurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        //Intent intent = new Intent("first-filter");
        //startActivity(intent);
        switch (view.getId()) {
            case R.id.btnSignUp:
                registerUser();
                ShtoTeDhenat();
                break;

            case R.id.tvLogin:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mI = getMenuInflater();
        mI.inflate(R.menu.my_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);


    }

}