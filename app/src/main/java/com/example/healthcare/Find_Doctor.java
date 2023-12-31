package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Find_Doctor extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        c1=(CardView)findViewById(R.id.familydoctor);
        c2=(CardView)findViewById(R.id.dietican);
        c3=(CardView)findViewById(R.id.dentist);
        c4=(CardView)findViewById(R.id.surgon);
        c5=(CardView)findViewById(R.id.cardiologist);
        c6=(CardView)findViewById(R.id.back);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Doctor.this,DoctorDetails.class);
                intent.putExtra("title","FamilyDoctor");
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Doctor.this,DoctorDetails.class);
                intent.putExtra("title","dietitian");
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Doctor.this,DoctorDetails.class);
                intent.putExtra("title","dentist");
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Doctor.this,DoctorDetails.class);
                intent.putExtra("title","surgeon");
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Find_Doctor.this,DoctorDetails.class);
                intent.putExtra("title","cardiologist");
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Find_Doctor.this, Home_page.class));
            }
        });
    }
}