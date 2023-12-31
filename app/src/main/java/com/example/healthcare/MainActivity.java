package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database db = new Database(getApplicationContext(),"healthcare",null,1);
        e1=(EditText)findViewById(R.id.editTextText);
        e2=(EditText)findViewById(R.id.editTextTextPassword);
        t=(TextView)findViewById(R.id.textView2);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = e1.getText().toString();
                String password = e2.getText().toString();

                //Toast.makeText(getApplicationContext(),"User is"+user,Toast.LENGTH_SHORT).show();
                if(user.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Username and password required",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(db.check(user,password))
                    {
                        Intent intent = new Intent(MainActivity.this, Home_page.class);
                        intent.putExtra("username",user);
                        savesharedpreferences(user);
                        Toast.makeText(getApplicationContext(),"Successfully logged in",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Register First",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, register_page.class));
            }
        });
    }
    void savesharedpreferences(String username)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("username",username);
        edit.commit();
    }
}