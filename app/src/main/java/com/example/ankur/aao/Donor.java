package com.example.ankur.aao;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Donor extends AppCompatActivity {
        EditText edt1,edt2,edt3,edt4;
        Spinner sp;
        Button btn;

        RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donor);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref=database.getReference("users");
        getSupportActionBar().setTitle("Donor");

        //relativeLayout=(RelativeLayout)findViewById(R.id.change_background);
        //We change the color to RED for the first time as the program loads
        //relativeLayout.setBackgroundColor(Color.RED);
        //Create the timer object which will run the desired operation on a schedule or at a given time
        //Timer timer = new Timer();
        //Create a task which the timer will execute.  This should be an implementation of the TimerTask interface.
        //I have created an inner class below which fits the bill.
        //MyTimer mt = new MyTimer();
        //We schedule the timer task to run after 1000 ms and continue to run every 1000 ms.
        //timer.schedule(mt, 1000, 1000);                //We change the color to RED for the first time as the program loads
        //relativeLayout.setBackgroundColor(Color.RED);


        edt1=(EditText) findViewById(R.id.editText3);
        edt2=(EditText) findViewById(R.id.editText4);
        edt3=(EditText) findViewById(R.id.editText5);
        edt4=(EditText) findViewById(R.id.editText6);
        sp=(Spinner) findViewById(R.id.spinner);
        btn =(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                String etname= edt1.getText().toString().trim();
                String eemail= edt2.getText().toString().trim();
                String ephone= edt3.getText().toString().trim();
                String eaddress= edt4.getText().toString().trim();
                String ebg=sp.getSelectedItem().toString().trim();

                if (etname.isEmpty()||etname.length()<3)
                {
                   edt1.setError("Error");
                   edt1.requestFocus();
                   return;
                }
                else if(eemail.isEmpty())
                {
                    edt2.setError("Error");
                    edt2.requestFocus();
                    return;
                }
                else if(ephone.isEmpty()||ephone.length()<9)
                {
                    edt3.setError("Error");
                    edt3.requestFocus();
                    return;
                }
                else if(eaddress.isEmpty())
                {
                    edt4.setError("Error");
                    edt4.requestFocus();
                    return;
                }
                else if (ebg=="Blood Group")
                {
                    Toast.makeText(getApplicationContext(),"Select Blood Group",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    Users user=new Users(etname,eemail,ephone,eaddress,ebg);
                    String key=ref.push().getKey();
                    ref.child(key).setValue(user);

                    Toast.makeText(getApplicationContext(), "data saved", Toast.LENGTH_LONG).show();

                    edt1.setText(" ");
                    edt2.setText(" ");
                    edt3.setText(" ");
                    edt4.setText(" ");
                    sp.setSelection(0);


                }
            }
        });
    }
    //An inner class which is an implementation of the TImerTask interface to be used by the Timer.
    class MyTimer extends TimerTask {

        public void run() {

            //This runs in a background thread.
            //We cannot call the UI from this thread, so we must call the main UI thread and pass a runnable
            runOnUiThread(new Runnable() {

                public void run() {
                    Random rand = new Random();
                    //The random generator creates values between [0,256) for use as RGB values used below to create a random color
                    //We call the RelativeLayout object and we change the color.  The first parameter in argb() is the alpha.
                    relativeLayout.setBackgroundColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                }
            });
        }
    }
    }
