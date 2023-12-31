package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register_page extends AppCompatActivity {
        TextView t;
        Button b;
        EditText username,npassword,cpassword,email,fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Database Data = new Database(getApplicationContext(),"healthcare",null,1);
        t= findViewById(R.id.textView4);
        b= findViewById(R.id.button2);
        username = findViewById(R.id.editTextText2);
        fullname= findViewById(R.id.editTextText3);
        npassword= findViewById(R.id.editTextTextPassword2);
        cpassword= findViewById(R.id.editTextTextPassword3);
        email= findViewById(R.id.editTextTextEmailAddress);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = npassword.getText().toString();
                String eamil1 = email.getText().toString();
                String cpass = cpassword.getText().toString();
                if(check(pass,cpass)) {
                    if (user.length() == 0 || pass.length() == 0 || eamil1.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Enter the details", Toast.LENGTH_SHORT).show();
                    } else {
                        Data.register(user, eamil1, pass);
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("username",user);
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Password doesn't match",Toast.LENGTH_SHORT).show();
                }
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean check(String npass , String cpass)
    {
        if(npass.equals(cpass))
        {
            return true;
        }
        return false;
    }
}