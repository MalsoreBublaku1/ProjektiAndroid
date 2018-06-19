package com.example.hp.projektiandroid;

import android.content.Intent;
        import android.graphics.Color;
import android.support.annotation.NonNull;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

import com.example.hp.projektiandroid.explore.ChooseActivity;
import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView TV1;
    private EditText et1;
    private Button btn1;
    private TextView TV2;
    private TextView TV3;
    private EditText et2;
    private EditText et3;
    private Button btn2;

    FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn2=(Button)findViewById(R.id.btnMain);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail = (EditText) findViewById(R.id.etEmail);
        editTextPassword = (EditText) findViewById(R.id.etPassword);

        et3=findViewById(R.id.etEmail);
        et3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(b)
                {
                    view.setBackgroundColor(Color.rgb(218,223,224));
                }
                else
                {
                    view.setBackgroundColor(Color.WHITE);
                }

            }
        });
        findViewById(R.id.tvSignUp).setOnClickListener(this);
        findViewById(R.id.btnMain).setOnClickListener(this);



        et2=findViewById(R.id.etPassword);
        et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    view.setBackgroundColor(Color.rgb(218,223,224));
                }
                else
                {
                    view.setBackgroundColor(Color.WHITE);
                }
            }
        });
/*
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et3.getText().toString().equals("android")||!et2.getText().toString().equals("projekti"))
                {
                    AlertDialog.Builder a_builder=new AlertDialog.Builder(MainActivity.this);
                    a_builder.setTitle("Wrong Credentials")
                            .setMessage("Invalid username or password")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                 dialogInterface.cancel();
                                }
                            });
                    AlertDialog ad=a_builder.create();
                    ad.show();
                }



            }
        });*/
        TV1=(TextView)findViewById(R.id.tvFP);
        TV1.setOnClickListener(MainActivity.this);
        TV3=(TextView) findViewById(R.id.tvSignUp);
        TV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("signUp-filter");
                startActivity(intent);
            }
        });





    }
    public void userLogin(){

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();



        if(email.isEmpty()){
            editTextEmail.setError("Email is Required!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is Required!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length()<6) {
            editTextPassword.setError("Minimum length is 6!");
            editTextPassword.requestFocus();
            return;
        }

        //sign-in funksioni
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(MainActivity.this, Kryesore.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this,Kryesore.class));
        }
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder dialogu=new AlertDialog.Builder(MainActivity.this);
        View view1=getLayoutInflater().inflate(R.layout.forgot_password_dialog,null);
        et1=(EditText)view1.findViewById(R.id.emailAddress);
        btn1=(Button)view1.findViewById(R.id.btnSend);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et1.getText().toString().isEmpty())
                {
                    Intent i=new Intent("second-filter");
                    startActivity(i);

                    et1.setBackgroundResource(R.drawable.etext_bg);
                }
                else
                {
                    et1.setError("Your email is empty!");
                    et1.setBackgroundResource(R.drawable.etext_error);
                }
            }
        });

        // dialogu.setView(view1);
        //AlertDialog dialogu2=dialogu.create();
        //dialogu2.show();

        //kodi per autentikim ne Firebase

        switch(view.getId()){
            case R.id.tvSignUp:
                finish();
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.btnMain:
                userLogin();

                break;
        }
    }
}