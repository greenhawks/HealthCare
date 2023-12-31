package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class appointment extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
   Button Book,Back,picktime,pickdate;
   DatePickerDialog datePickerDialog;
   TimePickerDialog timePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointiment);
        t1=(TextView)findViewById(R.id.editTextText2);
        t2=(TextView)findViewById(R.id.editTextTextEmailAddress);
        t3=(TextView)findViewById(R.id.editTextTextPassword2);
        t4=(TextView)findViewById(R.id.editTextTextPassword3);
        pickdate=(Button)findViewById(R.id.Date);
        picktime=(Button)findViewById(R.id.Timepick);
        Book = (Button)findViewById(R.id.button2);
        Back=(Button)findViewById(R.id.Back);
        Intent intent = getIntent();
        String title = intent.getStringExtra("text1");
        String name = intent.getStringExtra("text2");
        String address = intent.getStringExtra("text3");
        String Mobile_number = intent.getStringExtra("text4");
        String fees = intent.getStringExtra("text5");

        t1.setKeyListener(null);
        t2.setKeyListener(null);
        t3.setKeyListener(null);
        t4.setKeyListener(null);

        t1.setText(name);
        t2.setText(address);
        t3.setText(Mobile_number);
        t4.setText("Cons fees"+fees+"/-");
        initDatePicker();
        pickdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        initTimePicker();
        picktime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Successfully Booked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(appointment.this, Home_page.class));
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(appointment.this,DoctorDetails.class));
            }
        });
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                pickdate.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,date);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);
    }
    private void initTimePicker()
    {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                picktime.setText(i+":"+i1);
            }
        };
        Calendar calender = Calendar.getInstance();
        int hour = calender.get(Calendar.HOUR);
        int min = calender.get(Calendar.MINUTE);
        timePickerDialog = new TimePickerDialog(this,timeSetListener,hour,min,false);

    }
}