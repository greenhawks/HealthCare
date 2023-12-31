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

import org.w3c.dom.Text;

public class lab_test_details extends AppCompatActivity {
    TextView t1,t2;
    EditText et1;
    Button book , back;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        t1=(TextView)findViewById(R.id.textViewtitle);
        t2=(TextView)findViewById(R.id.textViewfees);
        et1=(EditText)findViewById(R.id.editTextTextMultiLine);
        book = (Button)findViewById(R.id.button3);
        back=(Button)findViewById(R.id.button4);
        et1.setKeyListener(null);
        Database db = new Database(getApplicationContext(),"healthcare",null,1);
        Intent intent = getIntent();
        t1.setText(intent.getStringExtra("text1"));
        et1.setText(intent.getStringExtra("text2"));
        t2.setText(intent.getStringExtra("text3"));
        SharedPreferences sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
        username = sharedPreferences.getString("username","");
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username==null)
                {
                    Toast.makeText(getApplicationContext(),"Provide username",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(username, t1.getText().toString(), t2.getText().toString(), "Lab");
                    Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(lab_test_details.this, Lab_Test.class));
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lab_test_details.this,Lab_Test.class));
            }
        });

    }

}