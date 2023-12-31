package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Order_Booking extends AppCompatActivity {
    EditText username , address , pincode , mobilenumber;
    Button Book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_booking);
        username = (EditText)findViewById(R.id.UserName);
        address=(EditText)findViewById(R.id.Address);
        pincode=(EditText)findViewById(R.id.PinCode);
        mobilenumber=(EditText)findViewById(R.id.MobileNumber);
        Book=(Button)findViewById(R.id.Book);


    }
}