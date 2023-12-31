package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoctorDetails extends AppCompatActivity {
    TextView t1;
    ListView l;
    private String[][] DoctorList1= {
            {"DoctorName : rajesh","Address : chintal","EXP : 5yrs","Mobile Number : 8977643766","400"},
            {"DoctorName : bharat","Address : lb nagar","EXP : 15yrs","Mobile Number : 8977643766","500"},
            {"DoctorName : dinesh","Address : medchal","EXP : 12yrs","Mobile Number : 8977643766","600"},
            {"DoctorName : manoj","Address : kukatpally","EXP : 10yrs","Mobile Number : 8977643766","700"},
            {"DoctorName : ashok","Address : panjaguta","EXP : 8yrs","Mobile Number : 8977643766","800"},
    } ;
    private String[][] DoctorList2= {
            {"DoctorName : rajesh","Address : chintal","EXP : 5yrs","Mobile Number : 8977643766","400"},
            {"DoctorName : bharat","Address : lb nagar","EXP : 15yrs","Mobile Number : 8977643766","500"},
            {"DoctorName : dinesh","Address : medchal","EXP : 12yrs","Mobile Number : 8977643766","600"},
            {"DoctorName : manoj","Address : kukatpally","EXP : 10yrs","Mobile Number : 8977643766","700"},
            {"DoctorName : ashok","Address : panjaguta","EXP : 8yrs","Mobile Number : 8977643766","800"},
    } ;
    private String[][] DoctorList3= {
            {"DoctorName : rajesh","Address : chintal","EXP : 5yrs","Mobile Number : 8977643766","400"},
            {"DoctorName : bharat","Address : lb nagar","EXP : 15yrs","Mobile Number : 8977643766","500"},
            {"DoctorName : dinesh","Address : medchal","EXP : 12yrs","Mobile Number : 8977643766","600"},
            {"DoctorName : manoj","Address : kukatpally","EXP : 10yrs","Mobile Number : 8977643766","700"},
            {"DoctorName : ashok","Address : panjaguta","EXP : 8yrs","Mobile Number : 8977643766","800"},
    } ;
    private String[][] DoctorList4= {
            {"DoctorName : rajesh","Address : chintal","EXP : 5yrs","Mobile Number : 8977643766","400"},
            {"DoctorName : bharat","Address : lb nagar","EXP : 15yrs","Mobile Number : 8977643766","500"},
            {"DoctorName : dinesh","Address : medchal","EXP : 12yrs","Mobile Number : 8977643766","600"},
            {"DoctorName : manoj","Address : kukatpally","EXP : 10yrs","Mobile Number : 8977643766","700"},
            {"DoctorName : ashok","Address : panjaguta","EXP : 8yrs","Mobile Number : 8977643766","800"},
    } ;
    private String[][] DoctorList5= {
            {"DoctorName : rajesh","Address : chintal","EXP : 5yrs","Mobile Number : 8977643766","400"},
            {"DoctorName : bharat","Address : lb nagar","EXP : 15yrs","Mobile Number : 8977643766","500"},
            {"DoctorName : dinesh","Address : medchal","EXP : 12yrs","Mobile Number : 8977643766","600"},
            {"DoctorName : manoj","Address : kukatpally","EXP : 10yrs","Mobile Number : 8977643766","700"},
            {"DoctorName : ashok","Address : panjaguta","EXP : 8yrs","Mobile Number : 8977643766","800"},
    } ;
    ArrayList names;
    Map<String,String> m;
    String Doctorlist[][];
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        t1=(TextView)findViewById(R.id.Doctor);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        t1.setText(title);
        if(title.compareTo("FamilyDoctor")==0)
        {
            Doctorlist = DoctorList1;
        }
        else if(title.compareTo("dietitian")==0)
        {
            Doctorlist=DoctorList2;
        }
        else if(title.compareTo("dentist")==0)
        {
            Doctorlist=DoctorList3;
        }
        else if(title.compareTo("surgeon")==0)
        {
            Doctorlist = DoctorList4;
        }
        else
        {
            Doctorlist = DoctorList5;
        }
        names = new ArrayList();
        for(int i=0;i<Doctorlist.length;i++)
        {
            m = new HashMap<>();
            m.put("line1",Doctorlist[i][0]);
            m.put("line2",Doctorlist[i][1]);
            m.put("line3",Doctorlist[i][2]);
            m.put("line4",Doctorlist[i][3]);
            m.put("line5",Doctorlist[i][4]+"/-");
            names.add(m);
        }
        sa = new SimpleAdapter(getApplicationContext(),names,R.layout.list_items,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});
        l=(ListView)findViewById(R.id.ListView);
        l.setAdapter(sa);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), appointment.class);
                intent.putExtra("text1",title);
                intent.putExtra("text2",Doctorlist[i][0]);
                intent.putExtra("text3",Doctorlist[i][1]);
                intent.putExtra("text4",Doctorlist[i][3]);
                intent.putExtra("text5",Doctorlist[i][4]);
                startActivity(intent);
            }
        });
    }
}