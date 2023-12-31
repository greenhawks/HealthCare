package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab_Test extends AppCompatActivity {
 ArrayList<HashMap<String,String>> a;
 SimpleAdapter sa;
 HashMap<String , String> m;
 ListView listView;
 Button Book , Back;
 private String[][] package1={
         {"Package : Full Body Checkup","","","","1000"},
         {"Package : Blood Sugar Checkup","","","","2000"},
         {"Package : Thyroid Test","","","","500"},
         {"Package : Blood Pressure Check","","","","200"},
         {"Package : Covid Test","","","","3000"}
 };
 private String[] package_details = {
         "Blood Glucose Fasting\n"+"Complete Hemogram\n"+"Hb1ac\n"+"Iron Studies\n"+"Kidney Function Tests\n"+"LDH Lactate Dehydrogenase , Serum\n"+"Lipid Profile \n"+"Liver Function Test","Blood Glucose Fasting","COVID_19 Antibody =IgG","Thyroid Profile-Total(T3,T4 & TSH Ultra=sensitive)","Complete HemoGram\n"+"CRP(C Reactive Protien) Quantitive , Serum\n"+"Iron Studies\n"+"Kidney Function Test\n"+"Vitamin D Total-25 Hydroxy\n"
 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        a=new ArrayList<>();
        listView=(ListView)findViewById(R.id.ListView);
        Book=(Button)findViewById(R.id.Book);
        Back=(Button)findViewById(R.id.Back);
        Intent i1 = getIntent();
        String username = i1.getStringExtra("username");
        for(int i=0;i<package1.length;i++)
        {
            m = new HashMap<>();
            m.put("line_1",package1[i][0]);
            m.put("line_2",package1[i][1]);
            m.put("line_3",package1[i][2]);
            m.put("line_4",package1[i][3]);
            m.put("line_5",package1[i][4]);
            a.add(m);
        }
        sa=new SimpleAdapter(getApplicationContext(),a,R.layout.list_items,new String[]{"line_1","line_2","line_3","line_4","line_5"},new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Lab_Test.this, lab_test_details.class);
                intent.putExtra("username",username);
                intent.putExtra("text1",package1[i][0]);
                intent.putExtra("text2",package_details[i]);
                intent.putExtra("text3",package1[i][4]);
                startActivity(intent);
            }
        });
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab_Test.this,order_details.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lab_Test.this, Home_page.class));
            }
        });
    }
}