package com.example.hp.projektiandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SendEmailActivity extends AppCompatActivity {

    private EditText editText;
    private Button butoni;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        editText = (EditText) findViewById(R.id.email2);
        butoni = (Button) findViewById(R.id.buton2);
        mAuth = FirebaseAuth.getInstance();

        butoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editText.getText().toString().trim();

                if(userEmail.equals("")){
                    Toast.makeText(SendEmailActivity.this, "Please, enter your email!",Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                //Toast.makeText(SendEmailActivity.this,"Password reset email sent!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(SendEmailActivity.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(SendEmailActivity.this,"Error in sendind password reset email!",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
    }
}
