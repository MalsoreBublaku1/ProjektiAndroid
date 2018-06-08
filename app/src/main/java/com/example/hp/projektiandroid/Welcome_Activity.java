package com.example.hp.projektiandroid;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Welcome_Activity extends AppCompatActivity {
    private int koha=3700;
private  ProgressBar progBar;
private TextView tv;
private Handler mHandler=new Handler();
private int mProgressStatus=0;

FirebaseAuth mAuth;

/*private  Button btn1;
ProgressBar pb;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        mAuth=FirebaseAuth.getInstance();
        final View myLayout=(View)findViewById(R.id.layout1);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i=new Intent(Welcome_Activity.this,Kryesore.class);
                startActivity(i);
                finish();
            }
        },koha);
        progBar=(ProgressBar)findViewById(R.id.progressBar);

        dosomething();
 /* btn1=(Button)findViewById(R.id.btnKliko);
  pb=(ProgressBar)findViewById(R.id.progress_bar);
  btn1.setOnClickListener(this);*/

     /*   if (mAuth.getCurrentUser() != null) {

            //user not logged in
            finish();
            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));

        }



        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null)
        {

            tv.setText("Welcome"+user.getDisplayName());




        }*/


    }
    public void dosomething()
    {
     new Thread(new Runnable() {
         @Override
         public void run() {
             final int persentage=0;
             while(mProgressStatus<100)
             {
                 mProgressStatus+=1;
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {
                         progBar.setProgress(mProgressStatus);
                     }
                 });
                 try{
                     Thread.sleep(40);
                 }catch(InterruptedException e)
                 {
                     e.printStackTrace();
                 }
             }

         }
     }).start();
    }


   // @Override
   /* public void onClick(View view) {
        pb.setProgress(0);
        new Thread(new Task()).start();


    }
    class Task implements  Runnable
    {

        @Override
        public void run() {
            for(int i=0;i<=6;i++)
            {
                final int value;
                value=i;
                try{
                    Thread.sleep(500);

                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                pb.setProgress(value);
            }
        }
    }
*/
}
