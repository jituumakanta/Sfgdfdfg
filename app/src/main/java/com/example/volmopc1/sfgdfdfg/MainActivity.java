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



        v.addRow(new DataBean("Ravi", "1"));
        v.addRow(new DataBean("Srinivas", "2"));
        v.addRow(new DataBean("Tommy", "3"));
        v.addRow(new DataBean("Karthik", "4"));

        v.getData();
        v.getAllContacts();


        List<DataBean> dataBean = v.getAllContacts();

        for (DataBean cn : dataBean) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);


    }}
}
