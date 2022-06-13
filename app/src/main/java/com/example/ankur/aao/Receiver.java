package com.example.ankur.aao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Receiver extends AppCompatActivity {
   /* EditText edt1,edt2,edt3,edt4;
    Spinner sp;
    Button btn;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_receiver);final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref=database.getReference("consumer");
        getSupportActionBar().setTitle("Receiver");

        edt1=(EditText) findViewById(R.id.editText7);
        edt2=(EditText) findViewById(R.id.editText8);
        edt3=(EditText) findViewById(R.id.editText9);
        edt4=(EditText) findViewById(R.id.editText10);
        sp=(Spinner) findViewById(R.id.spinner1);
        btn =(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String etname = edt1.getText().toString().trim();
                String eemail = edt2.getText().toString().trim();
                String ephone = edt3.getText().toString().trim();
                String eaddress = edt4.getText().toString().trim();
                String ebg = sp.getSelectedItem().toString().trim();
                if (etname.isEmpty() || etname.length() < 3) {
                    edt1.setError("Error");
                    edt1.requestFocus();
                    return;
                }

                else if (eemail.isEmpty()) {
                    edt2.setError("Error");
                    edt2.requestFocus();
                    return;
                }

                else if (ephone.isEmpty() || ephone.length() < 9) {
                    edt3.setError("Error");
                    edt3.requestFocus();
                    return;
                }

                else if (eaddress.isEmpty()) {
                    edt4.setError("Error");
                    edt4.requestFocus();
                    return;
                }

                else if (ebg == "Blood Group") {
                    Toast.makeText(getApplicationContext(), "Select Blood Group", Toast.LENGTH_LONG).show();
                    return;
                }

                else
                {
                    Users user=new Users(etname,eemail,ephone,eaddress,ebg);
                    String key=ref.push().getKey();
                    ref.child(key).setValue(user);
                }
            }
        });*/
    }
}

