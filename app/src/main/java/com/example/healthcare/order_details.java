package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class order_details extends AppCompatActivity {
    TextView cost;
    ArrayList a;
    ListView l;
    SimpleAdapter sa;
    HashMap<String,String> m;
    Button Back , Book;
    private String[][] packages={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        cost=(TextView)findViewById(R.id.Cost);
        a=new ArrayList();
        Back=(Button)findViewById(R.id.Back);
        Book=(Button)findViewById(R.id.Confirm);
        l=(ListView)findViewById(R.id.Listview);
       Database db = new Database(getApplicationContext(),"healthcare",null,1);
        SharedPreferences sharedPreferences = getSharedPreferences("name",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
       float tamount = 0;
        ArrayList list = db.getData(username,"Lab");
        packages=new String[list.size()][];
        for(int i=0;i<list.size();i++)
        {
            packages[i]=new String[5];
        }
        for(int i=0;i<list.size();i++)
        {
            String arrData = list.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0]=strData[0];
            packages[i][4]="Cost :"+strData[1]+"/-";
            tamount=tamount+Float.parseFloat(strData[1]);
        }
        cost.setText(Float.toString(tamount));
        for(int i=0;i<packages.length;i++)
        {
            m=new HashMap<>();
            m.put("line1",packages[i][0]);
            m.put("line2",packages[i][1]);
            m.put("line3",packages[i][2]);
            m.put("line4",packages[i][3]);
            m.put("line5",packages[i][4]);
            a.add(m);
        }
        sa=new SimpleAdapter(order_details.this,a,R.layout.list_items,new String[]{"line1","line2","line3","line4","line5"},new int[]{androidx.core.R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});
        l.setAdapter(sa);
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(order_details.this, Home_page.class));
            }
        });
    }
}