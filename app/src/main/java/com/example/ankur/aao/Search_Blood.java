package com.example.ankur.aao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Search_Blood extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__blood);


        recyclerView=findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase=firebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("users");



        FirebaseRecyclerAdapter<Show_details,MyHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Show_details,MyHolder>(
                Show_details.class,
                R.layout.Show_detais,
                MyHolder.class,
                databaseReference
        ){
            @Override
            protected void populateViewHolder(MyHolder viewHolder, Show_details model, int position){
                viewHolder.setDetails(getApplicationContext(),model.getName(),model.getEmail(),model.getPhone(),model.getAddress(),model.getBg());
            }
         };
                recyclerView.setAdapter(firebaseRecyclerAdapter);
            }




}
