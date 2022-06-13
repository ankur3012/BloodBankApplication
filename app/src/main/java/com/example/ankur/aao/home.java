package com.example.ankur.aao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt3;

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogOut;



    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        bt1 = (Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home.this, Donor.class);
                startActivity(i);
            }
        });

        bt3 = (Button) findViewById(R.id.button4);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(home.this, Search_Blood.class);
                startActivity(i);
            }
        });

     firebaseAuth=FirebaseAuth.getInstance();
             if(firebaseAuth.getCurrentUser()==null){
             finish();
             startActivity(new Intent(this,LoginActivity.class));
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();
        textViewUserEmail=(TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("welcome"+user.getEmail());
        buttonLogOut=(Button) findViewById(R.id.buttonLogOut);
        buttonLogOut.setOnClickListener(this);
        }

@Override
public void onClick(View view){
        if(view==buttonLogOut){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this,LoginActivity.class));
        }

        }
        }
