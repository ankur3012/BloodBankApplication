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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSignIn;
    private EditText editTextEmail;
    private  EditText editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            //profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),home.class));
        }

        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        textViewSignUp=(TextView) findViewById(R.id.textViewSignUp);
        buttonSignIn=(Button) findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

        progressDialog=new ProgressDialog(this);


    }
    private void UserLogin(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"PLease enter  Email",Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;

        }
        if(TextUtils.isEmpty(password)){
            //password id empty
            Toast.makeText(this,"PLease enter  Password",Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        progressDialog.setMessage("Registering User ");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    //start the profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(),home.class));
                }
            }
        });

    }

    @Override
    public void onClick(View view){
        if(view ==buttonSignIn){
            UserLogin();
        }
        if(view==textViewSignUp){
            finish();
            startActivity(new Intent(this,Registration.class));
        }

    }

}

