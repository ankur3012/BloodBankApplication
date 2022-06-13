package com.example.ankur.aao;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textviewSignin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Registration);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog=new ProgressDialog(this);
        buttonRegister=(Button) findViewById(R.id.buttonRgister);

        editTextEmail=(EditText) findViewById(R.id.editTextemail);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);

        textviewSignin=(TextView) findViewById(R.id.textViewSignin);

        buttonRegister.setOnClickListener(this);
        textviewSignin.setOnClickListener(this);
    }

    private void registerUser(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            //stopping the function executinfurther
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            //stopping the function executinfurther
            return;
        }
        //if validations are ok
        //we will first show a progressbar

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        //creating new user
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    finish();
                    startActivity(new Intent(getApplicationContext(),home.class));
                } else {

                    Toast.makeText(Registration.this, " Could not registered.Please try Again", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
    @Override
    public void onClick(View view) {
        if (view==buttonRegister){
            registerUser();
        }
            if(view ==textviewSignin){
                startActivity(new Intent(this,LoginActivity.class));
            }

    }
}
