package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home_page extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        c1=(CardView)findViewById(R.id.labtest);
        c2=(CardView)findViewById(R.id.buymedicine);
        c3=(CardView)findViewById(R.id.finddoctor);
        c4=(CardView)findViewById(R.id.healtharticles);
        c5=(CardView)findViewById(R.id.otherdetails);
        c6=(CardView)findViewById(R.id.logout);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Home_page.this, Lab_Test.class);
                intent1.putExtra("username",username);
                startActivity(intent1);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(Home_page.this, Find_Doctor.class));
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Successfully logged out",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_page.this, MainActivity.class));
            }
        });
    }
}