package com.example.hp.projektiandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import com.example.hp.projektiandroid.explore.RuajTeDhenat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private TextView TV1;
    private Button btn1;
    private Button btn;
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
        TV1 = (TextView) findViewById(R.id.tvLogin);
        TV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmail = editTextEmail.getText().toString().trim();
                String getPassword = editTextPassword.getText().toString().trim();
                // callsignin(getEmail,getPassword);
            }
        });
        btn1 = (Button) findViewById(R.id.btnSignUp);
        editTextFirstName = (EditText) findViewById(R.id.tvFirstName);
        editTextLastName = (EditText) findViewById(R.id.tvLastName);
        editTextEmail = (EditText) findViewById(R.id.tvEmail);
        editTextPassword = (EditText) findViewById(R.id.tvPassord);
        editTextConP = (EditText) findViewById(R.id.etConfirm);
        //progressBar = (ProgressBar) findViewById(R.id.progressB);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (mAuth.getCurrentUser() != null) {

            //useri jo i kycur
            finish();
            startActivity(new Intent(getApplicationContext(), Welcome_Activity.class));

        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackground(getResources().getDrawable(R.drawable.button_border));
                String getEmail = editTextEmail.getText().toString().trim();
                String getPassword = editTextPassword.getText().toString().trim();
                callsignup(getEmail, getPassword);
                ShtoTeDhenat();
                Intent intent1 = new Intent("welcome-filter");
                startActivity(intent1);

            }
        });

    }

    public void ShtoTeDhenat() {
        String emri = editTextFirstName.getText().toString().trim();
        String mbiemri = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String pass = editTextPassword.getText().toString().trim();
        RuajTeDhenat ruajTeDhenat = new RuajTeDhenat(emri, mbiemri, email, pass);
        databaseReference.push().setValue(ruajTeDhenat);
    }

//    private void registerUser() {
//
//        String email = editTextEmail.getText().toString().trim();
//        String password = editTextPassword.getText().toString().trim();
//        String conP = editTextConP.getText().toString().trim();
//
//
//        if (email.isEmpty()) {
//            editTextEmail.setError("Email is Required!");
//            editTextEmail.requestFocus();
//            return;
//        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            editTextEmail.setError("Please enter a valid email");
//            editTextEmail.requestFocus();
//            return;
//        }
//        if (password.isEmpty()) {
//            editTextPassword.setError("Password is Required!");
//            editTextPassword.requestFocus();
//            return;
//        }
//        if (password.length() < 6) {
//            editTextPassword.setError("Minimum length is 6!");
//            editTextPassword.requestFocus();
//            return;
//        }
//        // if(conP != password){
//        //   editTextConP.setError("Write again");
//        // editTextConP.requestFocus();
//        //return;
//        // }
//       // progressBar.setVisibility(View.VISIBLE);
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("hello", "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("hello", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//
//                        }
//
//                        // ...
//                    }
//                });
//    }


    private void callsignup(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(getApplicationContext(), "Useri u krijua", Toast.LENGTH_LONG).show();
                    Log.d("TESTING", "createUserWithEmail:success" + task.isSuccessful());
                    //FirebaseUser user = mAuth.getCurrentUser();
                    //updateUI(user);
                }
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "" + task.getException(), Toast.LENGTH_LONG).show();
                    Log.w("Testing", "createUserWithEmail:failure", task.getException());

                }
//                        else
//                        {
//
//
//                            userProfile();
//                            Toast.makeText(SignUpActivity.this,"Created user",Toast.LENGTH_LONG).show();
//                            Log.d("Testing","Created Account");
//
//                        }

                // ...
            }

        });
    }

/*
    private void userProfile() {
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null)
        {
            UserProfileChangeRequest profileUpdates=new UserProfileChangeRequest.Builder().setDisplayName(editTextEmail.getText().toString().trim()).build();

            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Log.d("Testing","User profile updated");

                    }
                }
            });
        }
    }
*/

//    @Override
//    public void onClick(View view) {
//        //Intent intent = new Intent("first-filter");
//        //startActivity(intent);
//        switch (view.getId()) {
//            case R.id.btnSignUp: {
//                String getEmail = editTextEmail.getText().toString().trim();
//                String getPassword = editTextPassword.getText().toString().trim();
//                callsignup(getEmail, getPassword);
//            }
//               // ShtoTeDhenat();
//               // Intent intent1=new Intent("welcome-filter");
//                 //startActivity(intent1);
//
//                break;
//
//            case R.id.tvLogin:
//                startActivity(new Intent(this, MainActivity.class));
//                break;
//        }
//    }

   /* private void callsignin(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Testing","SignIN successfull"+task.isSuccessful());
                if(!task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Nuk pati sukses",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent i=new Intent(SignUpActivity.this,Welcome_Activity.class);
                    finish();
                    startActivity(i);
                }
            }
        });


    }*/


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