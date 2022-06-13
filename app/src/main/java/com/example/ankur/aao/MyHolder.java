package com.example.ankur.aao;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ankur.aao.R;

public class MyHolder extends RecyclerView.ViewHolder{
    View mView;
    public MyHolder(View itemView){
        super(itemView);
        mView=itemView;
    }
    public void setDetails(Context c,String name, String email, String phone, String address, String Blood_group)
    {
        TextView NAME= mView.findViewById(R.id.tv1);
        TextView EMAIL=mView.findViewById(R.id.tv2);
        TextView PHONE=mView.findViewById(R.id.tv3);
        TextView ADDRESS=mView.findViewById(R.id.tv4);
        TextView BLOOD_GROUP=mView.findViewById(R.id.tv5);

        NAME.setText(name);
        EMAIL.setText(email);
        PHONE.setText(phone);
        ADDRESS.setText(address);
        BLOOD_GROUP.setText(Blood_group);
    }
}

