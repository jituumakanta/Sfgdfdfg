package com.example.volmopc1.sfgdfdfg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Databasehandle v=new Databasehandle(this);

        /*DataBean a1=new DataBean("Ravi", "1");
        DataBean a2=new DataBean("Srinivas", "2");
        DataBean a3=new DataBean("Tommy", "3");
        DataBean a4=new DataBean("Karthik", "4");*/
        DataBean a5=new DataBean(9, "jitu","6778","pune");
       // DataBean a6=new DataBean(10, "pradeep","7882","bengaluru");

       /* v.createRow(a1);
        v.createRow(a2);
        v.createRow(a3);
        v.createRow(a4);*/
        v.createRow(a5);
       // v.createRow(a6);
        v.getAllContacts();
    /*    v.getData();
       // v.getAllContacts();


        List<DataBean> dataBean = v.getAllContacts();

        for (DataBean cn : dataBean) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);


    }*/
    }
}
