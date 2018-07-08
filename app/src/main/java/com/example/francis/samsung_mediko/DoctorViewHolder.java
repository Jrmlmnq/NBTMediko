package com.example.francis.samsung_mediko;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DoctorViewHolder extends  RecyclerView.ViewHolder{
    TextView doctorName;
    TextView doctorDescription;

    public DoctorViewHolder(View itemView) {
        super(itemView);
        doctorName = (TextView) itemView.findViewById(R.id.doctorName);
        doctorDescription = (TextView) itemView.findViewById(R.id.doctorDescription);
        //set the stuff here
    }

    public void bindToDoctor(Doctor doctor, View.OnClickListener onClickListener){

    }
}
